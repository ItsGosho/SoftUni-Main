package T01_Reflection;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Scanner skener = new Scanner(System.in);

        Class classType=Reflection.class;
        Class classSuperClass=Reflection.class.getSuperclass();
        Class<?>[] reflectionInterfaces=Reflection.class.getInterfaces();
        Object reflectionInstantiateObjects=Reflection.class.newInstance();
        System.out.println(classType);
        System.out.println(classSuperClass);
        for (Class<?> reflectionInterface : reflectionInterfaces) {
            System.out.println(reflectionInterface);
        }
        System.out.println(reflectionInstantiateObjects);
    }
}
