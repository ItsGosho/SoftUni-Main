package T07_foodShortage;

public class Human implements Buyer {
    private String name;
    private String age;
    private String id;
    private String birthday;
    private int food;

    public Human(String name, String age, String id,String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday=birthday;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public void buyFood() {
        this.food+=10;
    }
}
