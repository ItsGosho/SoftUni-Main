package T02_carShop;

public class Seat implements Car{
    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;

    public Seat(String model, String color, int horsePower, String countryProduced) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
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
}
