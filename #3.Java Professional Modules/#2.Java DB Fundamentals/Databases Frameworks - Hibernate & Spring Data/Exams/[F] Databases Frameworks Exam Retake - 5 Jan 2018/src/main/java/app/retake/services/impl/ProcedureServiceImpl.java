package app.retake.services.impl;

import app.retake.domain.dto.*;
import app.retake.domain.models.AnimalAid;
import app.retake.domain.models.Procedure;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.*;
import app.retake.services.api.ProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    @Autowired
    private ModelParser modelParser;
    @Autowired
    private VetRepository vetRepository;
    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private PassportRepository passportRepository;
    @Autowired
    private AnimalAidRepository animalAidRepository;
    @Autowired
    private ProcedureRepository procedureRepository;

    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public void create(ProcedureXMLImportDTO dto) throws ParseException {
        Procedure procedure = new Procedure();
        procedure.setVet(this.vetRepository.getVetByName(dto.getVet()));
        procedure.setAnimal(this.animalRepository.getAnimalByPassport(this.passportRepository.getPassportBySerialNumber(dto.getAnimal())));
        String res=dto.getDate();
        String to=res.replace("-","/");
        procedure.setDate(sdf.parse(to));
        procedure.setServices(new LinkedList<>());
        BigDecimal totalCost=new BigDecimal("0");
        for (ProcedureAnimalAidXMLImportDTO procedureAnimalAidXMLImportDTO : dto.getAnimalProcedures()) {
            AnimalAid animalAid=this.animalAidRepository.getAnimalAidByName(this.modelParser.convert(procedureAnimalAidXMLImportDTO,AnimalAid.class).getName());
            procedure.getServices().add(animalAid);
            totalCost=totalCost.add(animalAid.getPrice());
        }
        procedure.setCost(totalCost);
        this.procedureRepository.save(procedure);
    }

    @Override
    public ProcedureWrapperXMLExportDTO exportProcedures() {
        List<Procedure> procedures=this.procedureRepository.findAll();

        ProcedureWrapperXMLExportDTO procedureWrapperXMLExportDTO=new ProcedureWrapperXMLExportDTO();
        procedureWrapperXMLExportDTO.setProcedures(new LinkedList<>());

        for (Procedure procedure : procedures) {
            ProcedureXMLExportDTO procedureXMLExportDTO=new ProcedureXMLExportDTO();
            procedureXMLExportDTO.setOwnerPhoneNumber(procedure.getAnimal().getPassport().getSerialNumber());
            procedureXMLExportDTO.setAnimalProcedures(new LinkedList<>());

            for (AnimalAid animalAid : procedure.getServices()) {
                ProcedureAnimalAidXMLExportDTO procedureAnimalAidXMLExportDTO=new ProcedureAnimalAidXMLExportDTO();
                procedureAnimalAidXMLExportDTO.setName(animalAid.getName());
                procedureAnimalAidXMLExportDTO.setPrice(animalAid.getPrice());
                procedureXMLExportDTO.getAnimalProcedures().add(procedureAnimalAidXMLExportDTO);
            }

            procedureWrapperXMLExportDTO.getProcedures().add(procedureXMLExportDTO);

        }
        return procedureWrapperXMLExportDTO;
    }
}

