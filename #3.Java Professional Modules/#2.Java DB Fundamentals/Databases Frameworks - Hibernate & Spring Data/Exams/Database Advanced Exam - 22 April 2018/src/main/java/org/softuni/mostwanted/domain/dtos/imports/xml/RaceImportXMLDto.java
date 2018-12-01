package org.softuni.mostwanted.domain.dtos.imports.xml;


import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RaceImportXMLDto {

    @XmlElement(name = "laps")
    private int laps;
    @NotNull
    @XmlElement(name = "district-name")
    private String districtName;
    @XmlElement(name = "entries")
    private EntryImportWrapperXMLDto entryImportWrapperXMLDto;

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public EntryImportWrapperXMLDto getEntryImportWrapperXMLDto() {
        return entryImportWrapperXMLDto;
    }

    public void setEntryImportWrapperXMLDto(EntryImportWrapperXMLDto entryImportWrapperXMLDto) {
        this.entryImportWrapperXMLDto = entryImportWrapperXMLDto;
    }
}
