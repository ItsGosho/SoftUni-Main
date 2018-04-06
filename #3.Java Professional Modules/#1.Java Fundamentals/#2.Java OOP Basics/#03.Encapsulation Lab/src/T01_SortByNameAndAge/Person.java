package T01_SortByNameAndAge;

public class Person {
    private String firstName;
    private String secondName;
    private int age;

    public Person(String firstName,String secondName,int age){
        this.firstName=firstName;
        this.secondName=secondName;
        this.age=age;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is a %d years old.",getFirstName(),this.secondName,getAge());
    }
}
