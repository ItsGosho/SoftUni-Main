package T03_Mankid;

import java.util.Scanner;

public class Main {
    public static class Human {
        private String firstName;
        private String lastName;

        protected String getFirstName() {
            return firstName;
        }
        protected String getLastName() {
            return lastName;
        }

        protected Human(String firstName, String lastName){
            this.setFirstName(firstName);
            this.setLastName(lastName);
        }
        private void setFirstName(String firstName){
            char[] word=firstName.toCharArray();
            if(Character.isUpperCase(word[0])){
            }else{
                throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
            }
            if(word.length>=4){
            }else{
                throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
            }
            this.firstName=firstName;
        }
        private void setLastName(String lastName){
            char[] word=lastName.toCharArray();
            if(Character.isUpperCase(word[0])){
            }else{
                throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
            }
            if(word.length>=3){
            }else{
                throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
            }
            this.lastName=lastName;
        }

    }
    public static class Worker extends Human {
        private double weekSalary;
        private double workHours;

        protected Worker(String firstName, String lastName,double weekSalary,double workHours) {
            super(firstName, lastName);
            this.setLastName(lastName);
            this.setWeekSalary(weekSalary);
            this.setWorkHours(workHours);
        }
        private void setLastName(String lastname){
            if(lastname.length()>3){
            }else{
                throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
            }
        }
        private void setWeekSalary(double weekSalary){
            if(weekSalary>10){
                this.weekSalary=weekSalary;
            }else{
                throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
            }

        }
        private void setWorkHours(double workHours){
            if(workHours>=1 && workHours<=12){
                this.workHours=workHours;
            }else{
                throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
            }
        }
        @Override
        public String toString(){
            return String.format("First Name: %s\nLast Name: %s\nWeek Salary: %.2f\nHours per day: %.2f\nSalary per hour: %.2f"
                    ,getFirstName(),getLastName(),this.weekSalary,this.workHours,this.weekSalary/7/this.workHours);
        }
    }
    public static class Student extends Human{
        private String facilityNumber;

        protected Student(String firstName, String lastName,String facilityNumber) {
            super(firstName, lastName);
            this.setFacilityNumber(facilityNumber);
        }
        private void setFacilityNumber(String facilityNumber){
            String toCheck=String.valueOf(facilityNumber);
            if(toCheck.length()>=5 && toCheck.length()<=10){
                this.facilityNumber=facilityNumber;
            }else{
                throw new  IllegalArgumentException("Invalid faculty number!");
            }
        }
        @Override
        public String toString(){
            return String.format("First Name: %s\nLast Name: %s\nFaculty number: %s\n",getFirstName(),getLastName(),this.facilityNumber);
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        try{
            Scanner skener = new Scanner(System.in);
            String[] studentInfo=skener.nextLine().split(" ");
            String firstNameStudent=studentInfo[0];
            String secondNameStudent=studentInfo[1];
            String facilityNumber=studentInfo[2];
            Student student = new Student(firstNameStudent, secondNameStudent, facilityNumber);
            System.out.println(student.toString());
            String[] workerInfo=skener.nextLine().split(" ");
            String firstNameWorker=workerInfo[0];
            String secondNameWorker=workerInfo[1];
            double weekSalary=Double.parseDouble(workerInfo[2]);
            double workingHours=Double.parseDouble(workerInfo[3]);
            Worker worker=new Worker(firstNameWorker,secondNameWorker,weekSalary,workingHours);
            System.out.println(worker.toString());
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
