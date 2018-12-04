package mostwanted.domain.dtos.xml;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "race")
@XmlAccessorType(XmlAccessType.FIELD)
public class RacesImportXMLDto {

    @XmlElement(name = "laps")
    @NotNull
    private Integer laps;

    @XmlElement(name = "district-name")
    @NotNull
    private String districtName;

    @XmlElement(name = "entries")
    private EntriesWrapperXMLDto entriesWrapperXMLDto;

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public EntriesWrapperXMLDto getEntriesWrapperXMLDto() {
        return entriesWrapperXMLDto;
    }

    public void setEntriesWrapperXMLDto(EntriesWrapperXMLDto entriesWrapperXMLDto) {
        this.entriesWrapperXMLDto = entriesWrapperXMLDto;
    }
}
