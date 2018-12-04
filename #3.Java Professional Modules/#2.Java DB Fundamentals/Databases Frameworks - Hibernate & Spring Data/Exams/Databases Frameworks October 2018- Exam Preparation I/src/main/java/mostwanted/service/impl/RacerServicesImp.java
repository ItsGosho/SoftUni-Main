package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.json.RacerImportJSONDto;
import mostwanted.domain.entities.Racer;
import mostwanted.domain.entities.Town;
import mostwanted.repository.RacerRepository;
import mostwanted.repository.TownRepository;
import mostwanted.service.inter.RacerService;
import mostwanted.util.inter.FileUtil;
import mostwanted.util.inter.ValidationUtil;
import mostwanted.util.inter.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RacerServicesImp implements RacerService {

    private final RacerRepository racerRepository;
    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public RacerServicesImp(RacerRepository racerRepository, TownRepository townRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.racerRepository = racerRepository;
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean racersAreImported() {
        return this.racerRepository.findAll().size()>=1;
    }

    @Override
    public String readRacersJsonFile() throws IOException {
        return this.fileUtil.readFile("files\\racers.json");
    }

    @Override
    public String importRacers(String racersFileContent) {
        List<String> result = new ArrayList<>();
        RacerImportJSONDto[] racerImportJSONDtos = null;
        try {
            racerImportJSONDtos = this.gson.fromJson(this.readRacersJsonFile(), RacerImportJSONDto[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(racerImportJSONDtos).forEach(x -> {
            if (this.validationUtil.isValid(x)) {
                Town town = this.townRepository.findTownByName(x.getHomeTown());
                if(this.racerRepository.findRacerByName(x.getName())==null){
                    Racer racer = this.modelMapper.map(x,Racer.class);
                    racer.setHomeTown(town);
                    this.racerRepository.save(racer);
                    result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Racer",x.getName()));
                }else{
                    result.add(Constants.DUPLICATE_DATA_MESSAGE);
                }
            } else {
                result.add(Constants.INCORRECT_DATA_MESSAGE);
            }
        });
        return String.join("\n",result);
    }

    @Override
    public String exportRacingCars() {
        List<String> result = new ArrayList<>();
        this.racerRepository.findAll().stream()
                .filter(x->x.getCars().size()>0)
                .sorted((x1,x2)->{
                    if(x1.getCars().size()!=x2.getCars().size()){
                        return Integer.compare(x2.getCars().size(),x1.getCars().size());
                    }else{
                        return x1.getName().compareTo(x2.getName());
                    }
                }).forEach(x->{
                    List<String> resNames = x.getCars().stream()
                            .map(z->String.format(" %s %s %s",z.getBrand(),z.getModel(),z.getYearOfProduction()))
                            //.sorted((x1,x2)->x2.compareTo(x1))
                            .collect(Collectors.toList());
            if (x.getAge() != null && x.getAge()!=0) {
                result.add(String.format("Name: %s\nAge: %d\nCars:\n%s",x.getName(),x.getAge(),String.join("\n",resNames)));
            }else{
                result.add(String.format("Name: %s\nCars:\n%s",x.getName(),String.join("\n",resNames)));
            }
        });
        return String.join("\n\n",result);
    }
}
