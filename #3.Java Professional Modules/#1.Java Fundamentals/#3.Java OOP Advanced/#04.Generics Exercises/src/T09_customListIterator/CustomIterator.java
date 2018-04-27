package T09_customListIterator;

import java.util.Iterator;
import java.util.List;

public class CustomIterator<T> {

    public static <T> void print(CustomList<T> list){
        for (Object t : list.getList()) {
            System.out.println(t);
        }
    }
}
