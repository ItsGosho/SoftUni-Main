package T05_CodingTracker;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Tracker {

    @Author(name = "Gosho")
    public void test(){
        System.out.println("aaaa");
    };

    public static void printMethodsByAuthor(Class<?> cl){
        Class asd=cl.getClass();
        Method[] arr=asd.getDeclaredMethods();
        for (Method method : arr) {
            Author annotation=method.getAnnotation(Author.class);
                System.out.println(annotation.name());
        }

    }

}
