package app.retake.services.impl;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.domain.models.Animal;
import app.retake.domain.models.Passport;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalRepository;
import app.retake.repositories.PassportRepository;
import app.retake.services.api.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private ModelParser modelParser;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private PassportRepository passportRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
   @Override
    public void create(AnimalJSONImportDTO dto) throws ParseException {
       Animal animal=new Animal();
       animal.setName(dto.getName());
       animal.setAge(dto.getAge());
       animal.setType(dto.getType());
       Passport passport=new Passport();
       passport.setAnimal(animal);
       passport.setOwnerName(dto.getPassportJSONImportDTO().getOwnerName());
       passport.setOwnerPhoneNumber(dto.getPassportJSONImportDTO().getOwnerPhoneNumber());
       passport.setSerialNumber(dto.getPassportJSONImportDTO().getSerialNumber());
       String res=dto.getPassportJSONImportDTO().getRegistrationDate();
       String to=res.replace("-","/");
       passport.setRegistrationDate(sdf.parse(to));
       animal.setPassport(passport);
       this.passportRepository.saveAndFlush(passport);
    }

    @Override
    public List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber) {
        List<Animal> animals = this.animalRepository.getAnimalsByPassportOwnerPhoneNumber(phoneNumber);
        List<AnimalsJSONExportDTO> done=new LinkedList<>();
        for (Animal an : animals) {
            AnimalsJSONExportDTO asd=new AnimalsJSONExportDTO();
            asd.setOwnerName(an.getName());
            asd.setAnimalName(an.getPassport().getOwnerName());
            asd.setAge(an.getAge());
            asd.setSerialNumber(an.getPassport().getSerialNumber());
            asd.setRegisteredOn(an.getPassport().getRegistrationDate());
            done.add(asd);
        }
       List<AnimalsJSONExportDTO> rdy= done.stream().sorted((x1,x2)->x1.getAge().compareTo(x2.getAge()))
               .sorted((x1,x2)->x2.getSerialNumber().compareTo(x1.getSerialNumber())).collect(Collectors.toList());
        return rdy;
    }
}
