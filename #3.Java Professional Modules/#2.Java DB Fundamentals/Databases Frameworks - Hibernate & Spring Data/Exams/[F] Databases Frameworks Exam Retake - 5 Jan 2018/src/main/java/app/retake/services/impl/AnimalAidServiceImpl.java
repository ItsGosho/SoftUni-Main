package app.retake.services.impl;


import app.retake.domain.dto.AnimalAidJSONImportDTO;
import app.retake.domain.models.AnimalAid;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.AnimalAidRepository;
import app.retake.services.api.AnimalAidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AnimalAidServiceImpl implements AnimalAidService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private AnimalAidRepository animalAidRepository;

    @Override
    public void create(AnimalAidJSONImportDTO dto) {
        AnimalAid animalAid=this.modelParser.convert(dto,AnimalAid.class);
        AnimalAid toCheck=this.animalAidRepository.getAnimalAidByName(dto.getName());

        if(toCheck==null){
            this.animalAidRepository.save(animalAid);
        }else if(animalAid.getName().equals(toCheck.getName()) && !animalAid.getPrice().equals(toCheck.getPrice())){
            toCheck.setPrice(animalAid.getPrice());
            this.animalAidRepository.save(toCheck);
        }else if(animalAid.getName().equals(toCheck.getName()) && animalAid.getPrice().equals(toCheck.getPrice())){

        }
    }
}
