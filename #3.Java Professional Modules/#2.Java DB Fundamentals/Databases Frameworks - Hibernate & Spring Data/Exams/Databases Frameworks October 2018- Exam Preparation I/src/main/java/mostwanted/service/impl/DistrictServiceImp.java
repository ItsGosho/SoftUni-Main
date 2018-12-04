package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.json.DistrictImportJSONDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Town;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.TownRepository;
import mostwanted.service.inter.DistrictService;
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
public class DistrictServiceImp implements DistrictService {

    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;


    public DistrictServiceImp(DistrictRepository districtRepository, TownRepository townRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.districtRepository = districtRepository;
        this.townRepository = townRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean districtsAreImported() {
        return this.districtRepository.findAll().size()>=1;
    }

    @Override
    public String readDistrictsJsonFile() throws IOException {
        return this.fileUtil.readFile("files\\districts.json");
    }

    @Override
    public String importDistricts(String districtsFileContent) {
        List<String> result = new ArrayList<>();
        DistrictImportJSONDto[] districtImportJSONDtos = null;
        try {
            districtImportJSONDtos = this.gson.fromJson(this.readDistrictsJsonFile(), DistrictImportJSONDto[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(districtImportJSONDtos).forEach(x -> {
            if (this.validationUtil.isValid(x)) {
                Town town = this.townRepository.findTownByName(x.getTownName());
                if(this.districtRepository.findDistinctByName(x.getName())==null){
                    District district = this.modelMapper.map(x,District.class);
                    district.setTown(town);
                    this.districtRepository.save(district);
                    result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"District",x.getName()));
                }else{
                    result.add(Constants.DUPLICATE_DATA_MESSAGE);
                }
            } else {
                result.add(Constants.INCORRECT_DATA_MESSAGE);
            }
        });
        return String.join("\n",result);
    }
}
