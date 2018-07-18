package app.exam.domain.dto.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemXMLImportDTO  implements Serializable {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "quantity")
    private int quantity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
