package T10_Tuple;

public class Tuple<T> implements iTuple {
    private T item1;
    private T item2;

    public Tuple(T item1, T item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public T getItem1() {
        return this.item1;
    }

    @Override
    public T getItem2() {
        return this.item2;
    }
    @Override
    public String toString(){
        return String.format("%s -> %s",getItem1(),getItem2());
    }
}
