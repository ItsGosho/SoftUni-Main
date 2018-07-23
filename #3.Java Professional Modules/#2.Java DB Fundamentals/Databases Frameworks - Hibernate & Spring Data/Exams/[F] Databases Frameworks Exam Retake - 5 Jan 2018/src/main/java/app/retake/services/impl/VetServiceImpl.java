package app.retake.services.impl;

import app.retake.domain.dto.VetXMLImportDTO;
import app.retake.domain.models.Vet;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.VetRepository;
import app.retake.services.api.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VetServiceImpl implements VetService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private VetRepository vetRepository;

    @Override
    public void create(VetXMLImportDTO dto) {
        Vet vet=modelParser.convert(dto,Vet.class);
        vet.setPhoneNumber(dto.getPhoneNumber());
        this.vetRepository.save(vet);
    }
}
