package itsgosho.domain.services;

import itsgosho.domain.entities.Capital;
import itsgosho.domain.repositories.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Service
public class CapitalServicesImp implements CapitalServices {

    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapitalServicesImp(CapitalRepository capitalRepository, ModelMapper modelMapper) {
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void transformIDsToUUIDs() {
        List<Capital> capitals = this.capitalRepository.findAll();
        List<Capital> newCapitals = new LinkedList<>();
        for (int i = 0; i < capitals.size(); i++) {
            String newID = String.valueOf(UUID.randomUUID());
            Capital capital = this.modelMapper.map(capitals.get(i),Capital.class);
            capital.setId(newID);
            newCapitals.add(capital);
            this.capitalRepository.delete(capitals.get(i));
        }
        for (Capital newCapital : newCapitals) {
            this.capitalRepository.save(newCapital);
        }
    }

    @Override
    public List<Capital> getAllCapitals() {
        return this.capitalRepository.findAll();
    }
}
