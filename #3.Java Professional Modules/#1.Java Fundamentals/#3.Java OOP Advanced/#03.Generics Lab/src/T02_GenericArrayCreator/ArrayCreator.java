package T02_GenericArrayCreator;

import java.lang.reflect.Array;

public class  ArrayCreator {

   public static <T> T[] create(int length, T item){
        T[] elements= (T[]) new Object[length];
       for (int i = 0; i <length ; i++) {
           elements[i]=item;
       }
       return elements;
   }

   public static <T> T[] create(Class<T> asd, int length, T item){
       T[] elements= (T[]) Array.newInstance(asd,length);
       for (int i = 0; i <length ; i++) {
           elements[i]=item;
       }
       return elements;
   }
}
