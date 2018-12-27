package itsgosho.domain.services;

import itsgosho.domain.entities.Part;
import itsgosho.domain.repositories.PartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServicesImp implements PartServices{

    private final PartRepository partRepository;

    @Autowired
    public PartServicesImp(PartRepository partRepository) {
        this.partRepository = partRepository;
    }

    @Override
    public List<Part> getAll() {
        return this.partRepository.findAll();
    }
}
