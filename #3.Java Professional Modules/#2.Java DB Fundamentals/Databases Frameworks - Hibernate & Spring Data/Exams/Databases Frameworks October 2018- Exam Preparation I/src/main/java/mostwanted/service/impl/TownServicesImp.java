package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.exports.RacingTownsExportDto;
import mostwanted.domain.dtos.json.TownImportJSONDto;
import mostwanted.domain.entities.Racer;
import mostwanted.domain.entities.Town;
import mostwanted.repository.RacerRepository;
import mostwanted.repository.TownRepository;
import mostwanted.service.inter.TownService;
import mostwanted.util.inter.FileUtil;
import mostwanted.util.inter.ValidationUtil;
import mostwanted.util.inter.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TownServicesImp implements TownService {

    private final TownRepository townRepository;
    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public TownServicesImp(TownRepository townRepository, RacerRepository racerRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean townsAreImported() {
        return this.townRepository.findAll().size()>=1;
    }

    @Override
    public String readTownsJsonFile() throws IOException {
        return this.fileUtil.readFile("files\\towns.json");
    }

    @Override
    public String importTowns(String townsFileContent) {
        List<String> result = new ArrayList<>();
        TownImportJSONDto[] townImportJSONDtos = null;
        try {
            townImportJSONDtos = this.gson.fromJson(this.readTownsJsonFile(), TownImportJSONDto[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(townImportJSONDtos).forEach(x -> {
            if (this.validationUtil.isValid(x)) {
                if(this.townRepository.findTownByName(x.getName())==null){
                    Town town = this.modelMapper.map(x,Town.class);
                    this.townRepository.save(town);
                    result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Town",x.getName()));
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
    public String exportRacingTowns() {
        List<String> result = new ArrayList<>();
        List<RacingTownsExportDto> racingTownsExportDtos = new ArrayList<>();
        this.townRepository.findAll()
                .forEach(x->{
                    List<Racer> racers = this.racerRepository.findAllByHomeTown(x);
                    if(racers.size()>0){
                        RacingTownsExportDto racingTownsExportDto = new RacingTownsExportDto();
                        racingTownsExportDto.setTownName(x.getName());
                        racingTownsExportDto.setRacersCount(racers.size());
                        racingTownsExportDtos.add(racingTownsExportDto);
                    }
        });
        racingTownsExportDtos.stream().sorted((x1,x2)->{
            if (x1.getRacersCount()!=x2.getRacersCount()) {
                return Integer.compare(x2.getRacersCount(),x1.getRacersCount());
            }else{
                return x1.getTownName().compareTo(x2.getTownName());
            }
        }).forEach(x->{
            result.add(String.format("Name: %s\nRacers: %d",x.getTownName(),x.getRacersCount()));
        });
        return String.join("\n\n",result);
    }
}
