package T06_birthdayCelebrations;

public class Robot implements Indentify {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getBirthDay() {
        return "a";
    }
}
