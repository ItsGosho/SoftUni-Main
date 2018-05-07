package T03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.sql.Ref;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Field[] field =Reflection.class.getDeclaredFields();
        Arrays.stream(field)
                .filter(x->!Modifier.toString(x.getModifiers()).equals("private"))
                .forEach(x-> System.out.println(x.getName()+" must be private!"));
        Method[] method=Reflection.class.getDeclaredMethods();
        Arrays.stream(method)
                .filter(x->!x.getName().startsWith("set"))
                .filter(x->!Modifier.toString(x.getModifiers()).equals("public"))
                .forEach(x-> System.out.println(x.getName()+" have to be public!"));
        Arrays.stream(method)
                .filter(x->!x.getName().startsWith("get") && !x.getName().startsWith("toString"))
                .filter(x->!Modifier.toString(x.getModifiers()).equals("private"))
                .forEach(x-> System.out.println(x.getName()+" have to be private!"));
    }
}
