package org.softuni.mostwanted.domain.dtos.exports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "most-wanted")
@XmlAccessorType(XmlAccessType.FIELD)
public class MostWantedWrapperExportXMLDto {

    @XmlElement(name = "racer")
    private List<MostWantedRacerExportXMLDto> mostWantedRacerExportXMLDtos;

    public List<MostWantedRacerExportXMLDto> getMostWantedRacerExportXMLDtos() {
        return mostWantedRacerExportXMLDtos;
    }

    public void setMostWantedRacerExportXMLDtos(List<MostWantedRacerExportXMLDto> mostWantedRacerExportXMLDtos) {
        this.mostWantedRacerExportXMLDtos = mostWantedRacerExportXMLDtos;
    }
}
