package T09_customListIterator;

import java.util.List;

public class Sorter<T> {

    public static <T extends Comparable<T>> List<T> sort(CustomList<T> customList){
        customList.getList().sort((x1,x2)->x1.compareTo(x2));
        return customList.getList();
    }
}
