package org.softuni.mostwanted.domain.dtos.imports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "entries")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryImportWrapperXMLDto {

    @XmlElement(name = "entry")
    private List<EntryImportXMLDto> entryImportXMLDtos;

    public List<EntryImportXMLDto> getEntryImportXMLDtos() {
        return entryImportXMLDtos;
    }

    public void setEntryImportXMLDtos(List<EntryImportXMLDto> entryImportXMLDtos) {
        this.entryImportXMLDtos = entryImportXMLDtos;
    }
}
