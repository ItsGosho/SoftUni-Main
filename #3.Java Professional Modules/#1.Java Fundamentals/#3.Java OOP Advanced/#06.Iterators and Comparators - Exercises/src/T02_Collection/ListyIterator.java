package T02_Collection;

import java.util.*;
import java.util.function.Consumer;

public class ListyIterator <T>  implements Iterable<T> {
    private List<String>  list;
    private int count;


    public ListyIterator(String... items){
        this.list=new ArrayList<>();
        this.count=0;
        this.list.addAll(Arrays.asList(items));
    }
    public boolean hasNext(){
          try{
              int check=this.count+1;
              String test=this.list.get(check);
          }catch (IndexOutOfBoundsException ex){
              return false;
          }
          return true;
    }
    public boolean move() {
        if(this.hasNext()){
            count++;
            return true;
        }
        return false;
    }
    public void print(){
        if(this.list.size()!=1 && !this.list.get(0).equals("")) {
            System.out.println(list.get(count));
        }else{
            System.out.println("Invalid Operation!");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> action) {
    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    public void PrintAll(){
        for (String s : list) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
}
