package itsgosho.domain.dtos.imports.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsWrapperImportXMLDto {

    @XmlElement(name = "product")
    private List<ProductImportXMLDto> productImportXMLDtoList;

    public List<ProductImportXMLDto> getProductImportXMLDtoList() {
        return productImportXMLDtoList;
    }

    public void setProductImportXMLDtoList(List<ProductImportXMLDto> productImportXMLDtoList) {
        this.productImportXMLDtoList = productImportXMLDtoList;
    }
}
