package T09_customListIterator;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T> {
    private List<T> list;

    public CustomList() {
        this.list = new ArrayList<>();
    }

    public void add(T element) {
        this.list.add(element);
    }
    public void remove(Integer index){
        this.list.remove(index);
    }

    public List<T> getList() {
        return this.list;
    }

    public boolean contains(T element){
        if(this.list.contains(element)){
            return true;
        }
        return false;
    }
    public void swap(Integer index1,Integer index2) {
        T element2=this.list.get(index2);
        this.list.set(index2,this.list.get(index1));
        this.list.set(index1,element2);
    }
    public <T extends Comparable<T>> Integer greater(T element){
        int count=0;
        for (int i = 0; i < this.list.size(); i++) {
            T currentElement= (T) this.list.get(i);
            if(element.compareTo(currentElement)<0){
                count++;
            }
        }
        return count;
    }
    public <T extends Comparable<T>> T min(){
        T element= (T) this.list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T currElement= (T) this.list.get(i);
            if(element.compareTo(currElement)>0){
                element=currElement;
            }
        }
        return element;
    }
    public <T extends Comparable<T>> T max(){
        T element= (T) this.list.get(0);
        for (int i = 1; i < list.size(); i++) {
            T currElement= (T) this.list.get(i);
            if(element.compareTo(currElement)<0){
                element=currElement;
            }
        }
        return element;
    }
}
