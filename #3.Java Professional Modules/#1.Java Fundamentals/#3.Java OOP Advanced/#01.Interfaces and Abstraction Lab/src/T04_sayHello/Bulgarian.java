package T04_sayHello;

public class Bulgarian implements Person{
    private String name;

    public Bulgarian(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return String.format("Здравей");
    }
}
