package T06_birthdayCelebrations;

public class Pet implements Indentify{
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getBirthDay() {
        return this.birthday;
    }

}
