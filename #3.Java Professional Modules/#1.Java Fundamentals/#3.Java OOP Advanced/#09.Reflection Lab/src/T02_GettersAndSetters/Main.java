package T02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Method[] methods=Reflection.class.getDeclaredMethods();
        Arrays.stream(methods).filter(x->x.getName().startsWith("get"))
                .sorted((x1,x2)->x1.getName().compareTo(x2.getName()))
                .forEach(x-> System.out.println(x.getName()+" will return "+x.getReturnType()));

        Arrays.stream(methods).filter(x->x.getName().startsWith("set"))
                .sorted((x1,x2)->x1.getName().compareTo(x2.getName()))
                .forEach(x-> System.out.println(x.getName()+" and will set field of "+x.getReturnType()));

    }
}
