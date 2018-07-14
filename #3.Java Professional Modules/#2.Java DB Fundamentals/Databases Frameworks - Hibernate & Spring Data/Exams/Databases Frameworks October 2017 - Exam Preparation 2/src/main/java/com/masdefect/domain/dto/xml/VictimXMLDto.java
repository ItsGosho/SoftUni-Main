package com.masdefect.domain.dto.xml;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "victims")
@XmlAccessorType(XmlAccessType.FIELD)
public class VictimXMLDto {

    @XmlAttribute(name = "name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
