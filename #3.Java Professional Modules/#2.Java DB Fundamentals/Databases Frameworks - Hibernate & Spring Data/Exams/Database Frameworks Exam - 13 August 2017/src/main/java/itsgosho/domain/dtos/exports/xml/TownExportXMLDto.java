package itsgosho.domain.dtos.exports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "town")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownExportXMLDto {

    @XmlAttribute(name = "name")
    private String name;
    @XmlAttribute(name = "population")
    private long population;
    @XmlAttribute(name = "town_clients")
    private long clients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getClients() {
        return clients;
    }

    public void setClients(long clients) {
        this.clients = clients;
    }
}
