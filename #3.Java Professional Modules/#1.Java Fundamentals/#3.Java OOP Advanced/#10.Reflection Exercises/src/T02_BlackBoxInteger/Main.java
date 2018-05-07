package T02_BlackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner skener = new Scanner(System.in);

        Constructor<BlackBoxInt> constructor;
        constructor = BlackBoxInt.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();
        Method[] methods=blackBoxInt.getClass().getDeclaredMethods();
        while(true){
            String[] line=skener.nextLine().split("_");
            if(line[0].equals("END")){
                 break;
            }
            if(line[0].equals("add")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("add"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }else if(line[0].equals("subtract")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("subtract"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }else if(line[0].equals("divide")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("divide"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }else if(line[0].equals("multiply")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("multiply"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }else if(line[0].equals("rightShift")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("rightShift"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }else if(line[0].equals("leftShift")){
                Arrays.stream(methods)
                        .filter(x->x.getName().equals("leftShift"))
                        .forEach(x->{
                            x.setAccessible(true);
                            try {
                                x.invoke(blackBoxInt,Integer.parseInt(line[1]));
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            } catch (InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        });
            }
            Field field=blackBoxInt.getClass().getDeclaredField("innerValue");
            field.setAccessible(true);
            System.out.println(field.get(blackBoxInt));
        }
     }
}
