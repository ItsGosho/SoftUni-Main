package itsgosho.domain.services;

import itsgosho.config.LoggingService;
import itsgosho.config.validators.ValidationUtil;
import itsgosho.config.validators.dateBefore.tools.DateBeforeUtils;
import itsgosho.domain.dtos.virus.VirusCreateDto;
import itsgosho.domain.dtos.virus.VirusEditDto;
import itsgosho.domain.entities.Capital;
import itsgosho.domain.entities.Virus;
import itsgosho.domain.repositories.CapitalRepository;
import itsgosho.domain.repositories.VirusRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class VirusServicesImp implements VirusServices {

    private final VirusRepository virusRepository;
    private final CapitalRepository capitalRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public VirusServicesImp(VirusRepository virusRepository, CapitalRepository capitalRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.virusRepository = virusRepository;
        this.capitalRepository = capitalRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    private boolean saveVirus(Virus virus) {
        try {
            this.virusRepository.save(virus);
            LoggingService.info("A virus has been successful created with name: " + virus.getName());
            return true;
        } catch (Exception ex) {
            LoggingService.error("The entity of type `Virus` wansn't saved: " + ex.getMessage());
        }
        return false;
    }

    private boolean deleteVirus(Virus virus) {
        if (virus != null) {
            this.virusRepository.delete(virus);
            LoggingService.info("A virus has been successful deleted with name: " + virus.getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean addVirus(VirusCreateDto virusCreateDto) {

        if (this.validationUtil.isValid(virusCreateDto)) {
            Virus virus = this.modelMapper.map(virusCreateDto, Virus.class);
            virus.setRealeseDate(DateBeforeUtils.parseDate(virusCreateDto.getRealeseDate()));
            for (String affectedCapital : virusCreateDto.getAffectedCapitals()) {
                Capital capital = this.capitalRepository.findCapitalByName(affectedCapital);
                if (capital != null) {
                    virus.getCapitals().add(capital);
                }
            }

            if (this.saveVirus(virus)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Virus> getAllViruses() {
        return this.virusRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        Virus virus = this.virusRepository.findById(id).orElse(null);
        if (this.deleteVirus(virus)) {
            return true;
        }
        return false;
    }

    @Override
    public Virus getVirusById(String id) {
        return this.virusRepository.findById(id).orElse(null);
    }

    @Override
    public boolean editVirus(String id,VirusEditDto virusEditDto) {
        Virus originalVirus = this.getVirusById(id);
        if(this.validationUtil.isValid(virusEditDto)){
            Virus virusCopy = this.modelMapper.map(virusEditDto,Virus.class);
            virusCopy.setId(originalVirus.getId());
            virusCopy.setRealeseDate(originalVirus.getRealeseDate());
            virusCopy.setCapitals(new LinkedList<>());
            for (String affectedCapital : virusEditDto.getAffectedCapitals()) {
                Capital capital = this.capitalRepository.findCapitalByName(affectedCapital);
                virusCopy.getCapitals().add(capital);
            }
            this.virusRepository.save(virusCopy);
            LoggingService.info("A virus has been successful updated with name: " + originalVirus.getName());
            return true;
        }
        return false;
    }

    @Override
    public Map<String, Object> getAllFieldsAndValues(Virus virus) {
        Map<String,Object> result = new LinkedHashMap<>();
        result.put("id",virus.getId());
        result.put("name",virus.getName());
        result.put("description",virus.getDescription());
        result.put("sideEffects",virus.getSideEffects());
        result.put("creator",virus.getCreator());
        result.put("deadly",virus.isDeadly());
        result.put("curable",virus.isCurable());
        result.put("mutation",virus.getMutation().name());
        result.put("turnoverRate",virus.getTurnoverRate());
        result.put("hoursUntilTurn",virus.getHoursUntilTurn());
        result.put("magnitude",virus.getMagnitude());
        result.put("realeseDate",virus.getRealeseDate());
        result.put("virusCapitals",virus.getCapitals());
        return result;
    }

}
