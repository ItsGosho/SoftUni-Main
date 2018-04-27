package T05_genericCountMethodString;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box(){
        this.elements=new ArrayList<>();
    }
    public void add(T element){
        this.elements.add(element);
    }

    public <T extends Comparable<T>>Integer mostOccuries(T comparableItem){
        int occuries=0;
        for (int i = 0; i < this.elements.size(); i++) {
            T element= (T) this.elements.get(i);
             if(comparableItem.compareTo(element)<0){
               occuries++;
             }
        }
           return occuries;
    }
}
