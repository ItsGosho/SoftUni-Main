package T03_carShopExtend;

public class Seat implements Sellable {
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private double price;

    public Seat(String model, String color, int horsePower, String countryProduced,double price) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.price=price;
    }

    @Override
    public String getModel() {
        return String.format(this.model);
    }

    @Override
    public String getColor() {
        return String.format(this.color);
    }

    @Override
    public int getHorsePower() {
        return Integer.parseInt(String.format(String.valueOf(this.horsePower)));
    }

    @Override
    public String toString() {
        return String.format("This is "+this.getModel()+" produced in "+this.countryProduced+" and have "+Car.TIRES+" tires");
    }

    @Override
    public double getPrice() {
        return this.price;
    }
}
