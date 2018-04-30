package T03_CoffeeMachine;

public class Coffee {
    private String size;
    private String name;

    public String getSize() {
        return size;
    }

    public String getName() {
        return name;
    }

    public Coffee(String size, String name) {
        this.size = size;
        this.name = name;
    }
    @Override
    public String toString(){
        return (this.size.charAt(0)+this.size.substring(1).toLowerCase())+" "+(this.name.charAt(0)+this.name.substring(1).toLowerCase());
    }
}
