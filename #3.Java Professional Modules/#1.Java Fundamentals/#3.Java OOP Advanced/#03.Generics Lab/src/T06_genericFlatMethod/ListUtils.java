package T06_genericFlatMethod;

import java.util.List;

public class ListUtils {

    public static <T> void flatten(List<? super T> destination, List<List<? extends T>> source){
        for (List<? extends T> obj : source) {
            for (T obj2 : obj) {
                destination.add(obj2);
            }
        }
    }
}
