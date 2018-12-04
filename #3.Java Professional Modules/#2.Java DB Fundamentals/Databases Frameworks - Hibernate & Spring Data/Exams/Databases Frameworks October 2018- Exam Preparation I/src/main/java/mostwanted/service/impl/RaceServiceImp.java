package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.xml.RacesWrapperXMLDto;
import mostwanted.domain.entities.District;
import mostwanted.domain.entities.Race;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.repository.DistrictRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RaceRepository;
import mostwanted.service.inter.RaceService;
import mostwanted.util.inter.FileUtil;
import mostwanted.util.inter.ValidationUtil;
import mostwanted.util.inter.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RaceServiceImp implements RaceService {

    private final RaceRepository raceRepository;
    private final DistrictRepository districtRepository;
    private final RaceEntryRepository raceEntryRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public RaceServiceImp(RaceRepository raceRepository, DistrictRepository districtRepository, RaceEntryRepository raceEntryRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.raceRepository = raceRepository;
        this.districtRepository = districtRepository;
        this.raceEntryRepository = raceEntryRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean racesAreImported() {
        return this.raceRepository.findAll().size()>=1;
    }

    @Override
    public String readRacesXmlFile() throws IOException {
        return this.fileUtil.readFile("files\\races.xml");
    }

    @Override
    public String importRaces() {
        List<String> result = new ArrayList<>();
        RacesWrapperXMLDto raceEntryWrapperXMLDto = null;
        try {
            raceEntryWrapperXMLDto = this.xmlParser.parseXml(RacesWrapperXMLDto.class,"files\\races.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        raceEntryWrapperXMLDto.getRacesImportXMLDtos().stream().forEach(x->{

            District district = this.districtRepository.findDistinctByName(x.getDistrictName());
            if(this.validationUtil.isValid(x) && district!=null){
                Race race = this.modelMapper.map(x,Race.class);
                race.setDistrict(district);
                Set<RaceEntry> raceEntries = new HashSet<>();

                x.getEntriesWrapperXMLDto().getEntryImportXMLDtos().stream().forEach(z->{
                    RaceEntry raceEntry = this.raceEntryRepository.findById(z.getEntryId()).orElse(null);
                      if(raceEntries!=null){
                          raceEntries.add(raceEntry);
                      }
                });
                this.raceRepository.save(race);
                result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Race",race.getId()));
            }else{
                result.add(Constants.INCORRECT_DATA_MESSAGE);
            }
        });

        return String.join("\n",result);
    }
}
