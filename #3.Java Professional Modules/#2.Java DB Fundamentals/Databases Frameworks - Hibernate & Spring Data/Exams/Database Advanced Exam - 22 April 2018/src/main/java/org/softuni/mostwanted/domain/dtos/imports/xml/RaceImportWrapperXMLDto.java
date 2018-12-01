package org.softuni.mostwanted.domain.dtos.imports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "races")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportWrapperXMLDto {

    @XmlElement(name = "race")
    private List<RaceImportXMLDto> raceImportXMLDtos;

    public List<RaceImportXMLDto> getRaceImportXMLDtos() {
        return raceImportXMLDtos;
    }

    public void setRaceImportXMLDtos(List<RaceImportXMLDto> raceImportXMLDtos) {
        this.raceImportXMLDtos = raceImportXMLDtos;
    }
}
