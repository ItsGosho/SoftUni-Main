package com.masdefect.domain.dto.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "anomalies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AnomaliesXMLDto {

    @XmlElement(name = "anomaly")
    private List<AnomalyXMLDto> anomalies;

    public List<AnomalyXMLDto> getAnomalies() {
        return anomalies;
    }

    public void setAnomalies(List<AnomalyXMLDto> anomalies) {
        this.anomalies = anomalies;
    }
}
