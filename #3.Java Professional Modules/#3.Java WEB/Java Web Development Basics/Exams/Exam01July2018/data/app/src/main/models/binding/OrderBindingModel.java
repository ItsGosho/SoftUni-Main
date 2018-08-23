package main.models.binding;

public class OrderBindingModel {

    private String name;
    private double price;
    private String description;
    private String inlineRadioOptions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInlineRadioOptions() {
        return inlineRadioOptions;
    }

    public void setInlineRadioOptions(String inlineRadioOptions) {
        this.inlineRadioOptions = inlineRadioOptions;
    }
}
