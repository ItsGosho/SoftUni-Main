package T02_SalaryIncrease;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private double salary;

    public Person(String firstName, String secondName, int age,double salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.salary=salary;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getAge() {
        return this.age;
    }
    public void increaseSalary(int bonus) {
      if(this.age>=30){
           this.salary+=this.salary*0.20;
      }else{
          this.salary+=this.salary*0.10;
      }
    }
    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", getFirstName(), this.secondName, this.salary);
    }
}
