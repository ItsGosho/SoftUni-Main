package org.softuni.mostwanted.domain.dtos.exports.xml;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "racer")
@XmlAccessorType(XmlAccessType.FIELD)
public class MostWantedRacerExportXMLDto {

    @XmlAttribute(name = "name")
    private String name;

    @XmlElement(name = "entries")
    private MostWantedEntryWrapperExportXMLDto mostWantedEntryWrapperExportXMLDto;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MostWantedEntryWrapperExportXMLDto getMostWantedEntryWrapperExportXMLDto() {
        return mostWantedEntryWrapperExportXMLDto;
    }

    public void setMostWantedEntryWrapperExportXMLDto(MostWantedEntryWrapperExportXMLDto mostWantedEntryWrapperExportXMLDto) {
        this.mostWantedEntryWrapperExportXMLDto = mostWantedEntryWrapperExportXMLDto;
    }
}
