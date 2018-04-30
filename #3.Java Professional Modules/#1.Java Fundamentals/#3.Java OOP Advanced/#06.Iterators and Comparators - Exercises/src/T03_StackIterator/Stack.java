package T03_StackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;

public class Stack<String> implements Iterable<String> {
    private ArrayDeque<String> arrayDeque;

    public Stack(String... nums){
        this.arrayDeque=new ArrayDeque<>();
        this.arrayDeque.addAll(Arrays.asList(nums));
    }
    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super String> action) {

    }
    public void pop(){
        this.arrayDeque.pollLast();
    }

    public void push(String element) {
        this.arrayDeque.push(element);
    }

    public void print() {
        this.arrayDeque.forEach(x-> System.out.println(x));
    }
}
