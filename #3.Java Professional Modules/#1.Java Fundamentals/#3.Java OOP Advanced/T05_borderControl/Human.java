package T05_borderControl;

public class Human implements Indentify{
    private String name;
    private String age;
    private String id;

    public Human(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
