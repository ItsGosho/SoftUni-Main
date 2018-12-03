package itsgosho.domain.dtos.imports.xml;


import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.*;

@XmlRootElement(name = "product")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductImportXMLDto {

    @NotNull
    @XmlAttribute(name = "name")
    private String name;

    @NotNull
    @XmlAttribute(name = "clients")
    private Long clients;

    @NotNull
    @XmlElement(name = "branch")
    private String branch;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClients() {
        return clients;
    }

    public void setClients(Long clients) {
        this.clients = clients;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
