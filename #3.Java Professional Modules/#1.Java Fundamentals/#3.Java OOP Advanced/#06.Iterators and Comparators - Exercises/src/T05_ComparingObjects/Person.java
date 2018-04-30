package T05_ComparingObjects;

import java.util.Comparator;
import java.util.List;

public class Person <T> implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getTown() {
        return town;
    }


    @Override
    public int compareTo(Person person) {
        int a=this.getName().compareTo(person.getName());
        if(a>0){

        }
        return 0;
    }
}
