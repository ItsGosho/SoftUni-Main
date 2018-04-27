package T04_listUtilities;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T element=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(element.compareTo(list.get(i))>0){
                element=list.get(i);
            }
        }
        return element;
    }
    public static <T extends Comparable<T>> T getMax(List<T> list){
        if(list.isEmpty()){
            throw new IllegalArgumentException();
        }
        T element=list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(element.compareTo(list.get(i))<0){
                element=list.get(i);
            }
        }
        return element;
    }
}
