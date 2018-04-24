package T03_carShopExtend;

public class Audi implements Rentable{

    private String model;
    private String color;
    private int horsePower;
    private String countryProduced;
    private int minRentDay;
    private double pricePerDay;

    public Audi(String model, String color, int horsePower, String countryProduced, int minRentDay, double pricePerDay) {
        this.model = model;
        this.color = color;
        this.horsePower = horsePower;
        this.countryProduced = countryProduced;
        this.minRentDay = minRentDay;
        this.pricePerDay = pricePerDay;
    }

    @Override
    public int getMinRentDay() {
        return this.minRentDay;
    }

    @Override
    public double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getHorsePower() {
        return this.horsePower;
    }
    @Override
    public String toString() {
        return String.format("This is "+this.getModel()+" produced in "+this.countryProduced+" and have "+Car.TIRES+" tires");
    }
}
