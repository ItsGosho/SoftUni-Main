package itsgosho.domain.services;

import itsgosho.domain.dtos.virus.VirusCreateDto;
import itsgosho.domain.dtos.virus.VirusEditDto;
import itsgosho.domain.entities.Virus;

import java.util.List;
import java.util.Map;

public interface VirusServices {

    boolean addVirus(VirusCreateDto virusCreateDto);

    List<Virus> getAllViruses();

    boolean deleteById(String id);

    Virus getVirusById(String id);

    boolean editVirus(String id,VirusEditDto virusEditDto);

    Map<String,Object> getAllFieldsAndValues(Virus virus);
}
