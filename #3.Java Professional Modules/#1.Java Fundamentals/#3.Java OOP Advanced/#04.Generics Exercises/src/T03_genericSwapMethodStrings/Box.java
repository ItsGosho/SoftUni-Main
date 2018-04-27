package T03_genericSwapMethodStrings;

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

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < this.elements.size(); i++) {
            str.append(this.elements.get(i).getClass().getName()+": "+this.elements.get(i)+"\n");
        }
        return str.toString();
    }

    public void swap(Integer index1,Integer index2) {
        T element2=this.elements.get(index2);
        this.elements.set(index2,this.elements.get(index1));
        this.elements.set(index1,element2);
    }
}
