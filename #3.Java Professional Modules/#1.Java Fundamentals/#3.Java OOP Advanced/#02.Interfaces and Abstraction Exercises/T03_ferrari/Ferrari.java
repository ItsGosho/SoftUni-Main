package T03_ferrari;

public class Ferrari implements Car{
    private final String model="488-Spider";
    private String driverName;

    public String getDriverName() {
        return driverName;
    }

    public Ferrari(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s/%s",this.model,this.pushBrakes(),this.pushPedal(),this.driverName);
    }

    @Override
    public String pushBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushPedal() {
        return "Zadu6avam sA!";
    }
}
