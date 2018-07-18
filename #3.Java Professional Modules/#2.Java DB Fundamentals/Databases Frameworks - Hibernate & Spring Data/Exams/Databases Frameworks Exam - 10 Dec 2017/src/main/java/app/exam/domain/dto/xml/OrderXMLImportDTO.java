package app.exam.domain.dto.xml;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Enumerated;
import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;


@XmlRootElement(name = "order")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderXMLImportDTO  implements Serializable {

    @XmlElement(name = "customer")
    private String customer;
    @XmlElement(name = "employee")
    private String employee;
    @XmlElement(name = "date")
    private String date;
    @XmlElement(name = "type")
    private String type;
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<OrderItemXMLImportDTO> items;

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<OrderItemXMLImportDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemXMLImportDTO> items) {
        this.items = items;
    }
}
