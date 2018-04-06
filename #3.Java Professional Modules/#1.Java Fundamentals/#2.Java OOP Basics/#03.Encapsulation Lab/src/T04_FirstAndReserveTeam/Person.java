package T04_FirstAndReserveTeam;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private double salary;

    public int getAge() {
        return this.age;
    }

    public Person(String firstName, String secondName, int age, double salary) {
        this.setFirstName(firstName);
        this.setSecondName(secondName);
        this.age=age;
        this.setSalary(salary);
    }
    public String getName(){
        return this.firstName+" "+this.secondName;
    }
    private String setFirstName(String firstName) {
        if(firstName.length()<3){
             throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }else{
            return this.firstName=firstName;
        }
    }
    private String setSecondName(String secondName){
        if(secondName.length()<3){
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }else{
            return this.secondName=secondName;
        }
    }
    private int setAge(int age) {
        if(age<1){
          throw new IllegalArgumentException("Age cannot be zero or negative integer");
        }else{
            return this.age;
        }
    }
    private double setSalary(double salary){
        if(salary<460.00){
           throw new IllegalArgumentException("Salary cannot be less than 460 leva");
        }else{
            return this.salary=salary;
        }
    }
    public void increaseSalary(int bonus) {
        if (this.age >= 30) {
            this.salary += this.salary * 0.20;
        } else {
            this.salary += this.salary * 0.10;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName, this.secondName, this.salary);
    }
}
