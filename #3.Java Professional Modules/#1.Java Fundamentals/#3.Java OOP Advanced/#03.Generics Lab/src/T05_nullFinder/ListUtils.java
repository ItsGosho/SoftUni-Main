package T05_nullFinder;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nulls=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i)==null){
                nulls.add(i);
            }
        }
        return nulls;
    }
}
