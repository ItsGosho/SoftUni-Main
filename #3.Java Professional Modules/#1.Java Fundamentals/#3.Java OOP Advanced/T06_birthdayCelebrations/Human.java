package T06_birthdayCelebrations;

public class Human implements Indentify {
    private String name;
    private String age;
    private String id;
    private String birthday;

    public Human(String name, String age, String id,String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday=birthday;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDay() {
        return this.birthday;
    }
}
