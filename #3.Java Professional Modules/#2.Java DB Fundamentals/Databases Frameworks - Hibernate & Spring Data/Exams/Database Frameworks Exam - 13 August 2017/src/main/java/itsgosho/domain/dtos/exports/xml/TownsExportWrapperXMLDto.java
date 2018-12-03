package itsgosho.domain.dtos.exports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsExportWrapperXMLDto {

    @XmlElement(name = "town")
    private List<TownExportXMLDto> townExportXMLDtos;

    public List<TownExportXMLDto> getTownExportXMLDtos() {
        return townExportXMLDtos;
    }

    public void setTownExportXMLDtos(List<TownExportXMLDto> townExportXMLDtos) {
        this.townExportXMLDtos = townExportXMLDtos;
    }
}
