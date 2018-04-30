package T01_ListyIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListyIterator implements iListyIterator{
    private List<String>  list;
    private int count;


    public ListyIterator(String... items){
        this.list=new ArrayList<>();
        this.count=0;
        this.list.addAll(Arrays.asList(items));
    }
    @Override
    public boolean hasNext(){
          try{
              int check=this.count+1;
              String test=this.list.get(check);
          }catch (IndexOutOfBoundsException ex){
              return false;
          }
          return true;
    }
    @Override
    public boolean move() {
        if(this.hasNext()){
            count++;
            return true;
        }
        return false;
    }
    @Override
    public void print(){
        if(this.list.size()!=1 && !this.list.get(0).equals("")) {
            System.out.println(list.get(count));
        }else{
            System.out.println("Invalid Operation!");
        }
    }
}
