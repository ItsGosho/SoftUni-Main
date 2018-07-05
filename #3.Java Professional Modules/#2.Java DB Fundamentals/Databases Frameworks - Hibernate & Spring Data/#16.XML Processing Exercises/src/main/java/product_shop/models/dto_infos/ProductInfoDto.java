package product_shop.models.dto_infos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class ProductInfoDto implements Serializable {

    @Expose
    private String name;
    @Expose
    private Integer productsCount;
    @Expose
    private Double averagePrice;
    @Expose
    private Double totalRevenue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
