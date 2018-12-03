package itsgosho.domain.dtos.exports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "branches")
@XmlAccessorType(XmlAccessType.FIELD)
public class BranchesExportWrapperXMLDto {

    @XmlElement(name = "branch")
    private List<BranchExportXMLDto> branchExportXMLDtoList;

    public List<BranchExportXMLDto> getBranchExportXMLDtoList() {
        return branchExportXMLDtoList;
    }

    public void setBranchExportXMLDtoList(List<BranchExportXMLDto> branchExportXMLDtoList) {
        this.branchExportXMLDtoList = branchExportXMLDtoList;
    }
}
