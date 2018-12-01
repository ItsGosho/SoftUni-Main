package org.softuni.mostwanted.domain.dtos.exports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class MostWantedEntryWrapperExportXMLDto {

    @XmlElement(name = "entry")
    private List<MostWantedEntryExportXMLDto> mostWantedEntryExportXMLDtos;

    public List<MostWantedEntryExportXMLDto> getMostWantedEntryExportXMLDtos() {
        return mostWantedEntryExportXMLDtos;
    }

    public void setMostWantedEntryExportXMLDtos(List<MostWantedEntryExportXMLDto> mostWantedEntryExportXMLDtos) {
        this.mostWantedEntryExportXMLDtos = mostWantedEntryExportXMLDtos;
    }
}
