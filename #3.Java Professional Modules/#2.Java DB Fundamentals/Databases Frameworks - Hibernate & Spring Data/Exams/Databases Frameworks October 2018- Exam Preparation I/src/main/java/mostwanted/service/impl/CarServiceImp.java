package mostwanted.service.impl;

import com.google.gson.Gson;
import mostwanted.common.Constants;
import mostwanted.domain.dtos.json.CarImportJSONDto;
import mostwanted.domain.entities.Car;
import mostwanted.domain.entities.Racer;
import mostwanted.repository.CarRepository;
import mostwanted.repository.RacerRepository;
import mostwanted.service.inter.CarService;
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
public class CarServiceImp implements CarService {

    private final CarRepository carRepository;
    private final RacerRepository racerRepository;
    private final FileUtil fileUtil;
    private final Gson gson;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarServiceImp(CarRepository carRepository, RacerRepository racerRepository, FileUtil fileUtil, Gson gson, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carRepository = carRepository;
        this.racerRepository = racerRepository;
        this.fileUtil = fileUtil;
        this.gson = gson;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public Boolean carsAreImported() {
        return this.carRepository.findAll().size() >= 1;
    }

    @Override
    public String readCarsJsonFile() throws IOException {
        return this.fileUtil.readFile("files\\cars.json");
    }

    @Override
    public String importCars(String carsFileContent) {
        List<String> result = new ArrayList<>();
        CarImportJSONDto[] carImportJSONDtos = null;
        try {
            carImportJSONDtos = this.gson.fromJson(this.readCarsJsonFile(), CarImportJSONDto[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Arrays.stream(carImportJSONDtos).forEach(x -> {
            if (this.validationUtil.isValid(x)) {
                Racer racer = this.racerRepository.findRacerByName(x.getRacerName());
                 Car car = this.modelMapper.map(x, Car.class);
                 car.setRacer(racer);
                 this.carRepository.save(car);
                 result.add(String.format(Constants.SUCCESSFUL_IMPORT_MESSAGE,"Car",x.getBrand()+" "+x.getModel()+" @ "+x.getYearOfProduction()));
            } else {
                result.add(Constants.INCORRECT_DATA_MESSAGE);
            }
        });
        return String.join("\n",result);
    }
}
