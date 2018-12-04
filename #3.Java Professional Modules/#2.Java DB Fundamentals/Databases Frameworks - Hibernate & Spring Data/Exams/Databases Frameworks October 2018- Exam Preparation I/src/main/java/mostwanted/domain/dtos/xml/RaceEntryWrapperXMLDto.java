package mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "race-entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceEntryWrapperXMLDto {

    @XmlElement(name = "race-entry")
    private List<RaceEntryImportXMLDto> raceEntryImportXMLDtos;

    public List<RaceEntryImportXMLDto> getRaceEntryImportXMLDtos() {
        return raceEntryImportXMLDtos;
    }

    public void setRaceEntryImportXMLDtos(List<RaceEntryImportXMLDto> raceEntryImportXMLDtos) {
        this.raceEntryImportXMLDtos = raceEntryImportXMLDtos;
    }
}
