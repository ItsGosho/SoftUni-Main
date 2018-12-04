package mostwanted.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RacesWrapperXMLDto {

    @XmlElement(name = "race")
    private List<RacesImportXMLDto> racesImportXMLDtos;

    public List<RacesImportXMLDto> getRacesImportXMLDtos() {
        return racesImportXMLDtos;
    }

    public void setRacesImportXMLDtos(List<RacesImportXMLDto> racesImportXMLDtos) {
        this.racesImportXMLDtos = racesImportXMLDtos;
    }
}
