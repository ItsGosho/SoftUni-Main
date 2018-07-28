package panzer.models.entities.parts;

import panzer.contracts.Part;

import java.math.BigDecimal;

public abstract class PartImpl implements Part {

    private String model;
    private double weight;
    private BigDecimal price;

    public PartImpl(String model, double weight, BigDecimal price) {
        this.model = model;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
