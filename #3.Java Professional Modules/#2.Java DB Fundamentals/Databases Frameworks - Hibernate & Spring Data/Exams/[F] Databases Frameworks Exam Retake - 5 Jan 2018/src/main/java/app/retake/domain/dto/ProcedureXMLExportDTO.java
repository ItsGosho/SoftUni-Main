package app.retake.domain.dto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "procedure")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureXMLExportDTO {

    @XmlElement(name = "owner")
    private String ownerPhoneNumber;

    @XmlElementWrapper(name = "animal-aids")
    @XmlElement(name = "animal-aid")
    private List<ProcedureAnimalAidXMLExportDTO> animalProcedures;

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        this.ownerPhoneNumber = ownerPhoneNumber;
    }

    public List<ProcedureAnimalAidXMLExportDTO> getAnimalProcedures() {
        return animalProcedures;
    }

    public void setAnimalProcedures(List<ProcedureAnimalAidXMLExportDTO> animalProcedures) {
        this.animalProcedures = animalProcedures;
    }
}
