package entities;

public class Student {

    private int id;
    private String name;
    private int age;
    private String town;

    public Student() {

    }

    public Student(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getTown() {
        return town;
    }
    public void setTown(String town) {
        this.town = town;
    }
}
