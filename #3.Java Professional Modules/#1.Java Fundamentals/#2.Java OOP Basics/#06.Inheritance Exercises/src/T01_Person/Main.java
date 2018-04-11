package T01_Person;

import java.util.Scanner;

public class Main {
    public static class Person {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public Person(String name, int age){
            this.setName(name);
            this.setAge(age);
        }
        protected void setName(String name){
            if(name.length()<=2){
                throw new IllegalArgumentException("Name's length should not be less than 3 symbols!");
            }else{
                this.name=name;
            }
        }
        protected void setAge(int age){
            if(age<0){
                throw new IllegalArgumentException("Age must be positive!");
            }else{
                this.age=age;
            }
        }
        @Override
        public String toString(){
            return String.format("Name: %s, Age: %d",this.getName(),this.getAge());
        }
    }
    public static class Child extends Person {
        public Child(String name, int age) {
            super(name,age);
            //testvam si 23:35 08-Apr-18
        }
        @Override
        protected void setAge(int age) throws  IllegalArgumentException{
            if(age>=16){
                throw new IllegalArgumentException("Child's age must be lesser than 15!");
            }else{
                super.setAge(age);
            }
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int age = Integer.valueOf(scanner.nextLine());

        try {
            Child child = new Child(name, age);
            System.out.println(child.toString());
            String personClassName = Person.class.getSimpleName();
            String childClassName = Child.class.getSimpleName();
        } catch (IllegalArgumentException error) {
            System.out.println(error.getMessage());
        }

    }
}

