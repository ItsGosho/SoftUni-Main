package mostwanted.domain.dtos.xml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "entry")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntryImportXMLDto {

    @XmlAttribute(name = "id")
    @NotNull
    private Integer entryId;

    public Integer getEntryId() {
        return entryId;
    }

    public void setEntryId(Integer entryId) {
        this.entryId = entryId;
    }
}
