package app.exam.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderItemsWrapperDTO   implements Serializable {

    @XmlElement(name = "item")
    private List<OrderItemXMLImportDTO> orderItems;
}
