package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.xml.RaceEntryWrapperXMLDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.RaceEntry;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RaceEntryRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.service.inter.RaceEntryService;
import mostwanted.util.inter.FileUtil;
import mostwanted.util.inter.ValidationUtil;
import mostwanted.util.inter.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class RaceEntryServiceImp implements RaceEntryService {

    private final RaceEntryRepository raceEntryRepository;
    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public RaceEntryServiceImp(RaceEntryRepository raceEntryRepository, CarRepository carRepository, RacerRepository racerRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.raceEntryRepository = raceEntryRepository;
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean raceEntriesAreImported() {
        return this.raceEntryRepository.findAll().size()>=1;
    }

    @Override
    public String readRaceEntriesXmlFile() throws IOException {
        return this.fileUtil.readFile("files\\race-entries.xml");
    }

    @Override
    public String importRaceEntries() {
        List<String> result = new ArrayList<>();
        RaceEntryWrapperXMLDto raceEntryWrapperXMLDto = null;
        try {
            raceEntryWrapperXMLDto = this.xmlParser.parseXml(RaceEntryWrapperXMLDto.class,"files\\race-entries.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        raceEntryWrapperXMLDto.getRaceEntryImportXMLDtos().stream().forEach(x->{
            if(this.validationUtil.isValid(x)){
                Car car = this.carRepository.findById(x.getCar()).orElse(null);
                Racer racer = this.racerRepository.findRacerByName(x.getRacerName());
                RaceEntry raceEntry = this.modelMapper.map(x,RaceEntry.class);
                raceEntry.setCar(car);
                raceEntry.setRacer(racer);
                this.raceEntryRepository.save(raceEntry);
                result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"RaceEntry",raceEntry.getId()));
            }else{
                result.add(Constants.INCORRECT_DATA_MESSAGE);
            }
        });

        return String.join("\n",result);
    }
}
