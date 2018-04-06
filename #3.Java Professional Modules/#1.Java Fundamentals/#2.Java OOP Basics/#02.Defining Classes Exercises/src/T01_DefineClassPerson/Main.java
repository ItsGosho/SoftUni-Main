package T01_DefineClassPerson;

import java.lang.reflect.Field;
import java.util.Scanner;
public class Main {
    //Gosho------------------------------>
    class Person{
        private String name;
        private int age;
    }
    public static void main(String[] args) throws Exception {
        Class person = Person.class;
        Field[] fields = person.getDeclaredFields();
        System.out.println(fields.length-1);
    }

}