package itsgosho.domain.dtos.imports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeesWrapperImportXMLDto {

    @XmlElement(name = "employee")
    List<EmployeeImportXMLDto> employeeImportXMLDtos;

    public List<EmployeeImportXMLDto> getEmployeeImportXMLDtos() {
        return employeeImportXMLDtos;
    }

    public void setEmployeeImportXMLDtos(List<EmployeeImportXMLDto> employeeImportXMLDtos) {
        this.employeeImportXMLDtos = employeeImportXMLDtos;
    }
}
