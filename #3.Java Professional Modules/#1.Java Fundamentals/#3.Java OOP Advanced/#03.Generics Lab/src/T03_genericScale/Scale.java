package T03_genericScale;

public class Scale<T extends Comparable<T>>{
    private T element1;
    private T element2;

    public Scale(T element1,T element2){
        this.element1=element1;
        this.element2=element2;
    }
    public T getHeavier(){
         if(this.element1.compareTo(this.element2)>0){
             return this.element1;
         }else if(this.element1.compareTo(this.element2)<0){
             return this.element2;
         }else{
             return null;
         }
    }
}
