package T04_CompanyRoaster;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    //Gosho------------------------------>
    public static class Employee {
        private String name;
        private double salary;
        private String position;
        private String department;
        private String email;
        private int age;
        private static HashMap<String, List<Workers>> departments = new HashMap<>();

        public Employee() {
        }

        ;

        public Employee(String[] line) {
            this.name = line[0];
            this.salary = Double.parseDouble(line[1]);
            this.position = line[2];
            this.department = line[3];
            boolean foundAge = false;
            boolean foundEmail = false;
            try {
                if (line[4].contains("@")) {
                    this.email = line[4];
                    foundEmail = true;
                } else {
                    this.age = Integer.parseInt(line[4]);
                    foundAge = true;
                }
            } catch (IndexOutOfBoundsException e) {
                this.email = "n/a";
            }
            try {
                if (!foundAge) {
                    this.age = Integer.parseInt(line[5]);
                } else if (!foundEmail) {
                    this.email = "n/a";
                }
            } catch (IndexOutOfBoundsException e) {
                this.age = -1;
            }
            if (!Employee.departments.containsKey(this.department)) {
                Employee.departments.put(department, new ArrayList<>());
                Workers worker = new Workers(this.name, this.salary, this.position, this.email, this.age);
                Employee.departments.get(department).add(worker);
            } else {
                Workers worker = new Workers(this.name, this.salary, this.position, this.email, this.age);
                Employee.departments.get(department).add(worker);
            }
        }
    }

    private static class Workers {
        private String name;
        private double salary;
        private String position;
        private String email;
        private int age;

        public Workers(String name, Double salary, String position, String email, int age) {
            this.name = name;
            this.salary = salary;
            this.position = position;
            this.email = email;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, List<Workers>> dict = new HashMap<>();
        int n = Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line = skener.nextLine().split(" ");
            Employee employee = new Employee(line);
        }
        dict = Employee.departments;
        HashMap<String, List<Workers>> finalDict = dict;
        dict.entrySet().stream()
                .sorted((x1, x2) -> {
                    double sum1 = 0;
                    double sum2 = 0;
                    for (int i = 0; i < x1.getValue().size(); i++) {
                        sum1 += x1.getValue().get(i).salary;
                    }
                    for (int i = 0; i < x2.getValue().size(); i++) {
                        sum2 += x2.getValue().get(i).salary;
                    }
                    return Double.compare(sum2, sum1);
                })
                .limit(1)
                .forEach(x -> {
                    System.out.println("Highest Average Salary: " + x.getKey());
                    finalDict.get(x.getKey()).stream()
                            .sorted((x1, x2) -> Double.compare(x2.salary, x1.salary))
                            .forEach(a -> {
                                System.out.printf("%s %.2f %s %d", a.name, a.salary, a.email, a.age);
                                System.out.println();
                            });
                });
    }
}
