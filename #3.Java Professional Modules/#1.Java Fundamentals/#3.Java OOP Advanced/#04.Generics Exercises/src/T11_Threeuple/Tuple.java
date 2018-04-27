package T11_Threeuple;

public class Tuple<A,B,C> implements iTuple {
    private A item1;
    private B item2;
    private C item3;

    public Tuple(A item1, B item2,C item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = setItem3(item3);
    }

    public C setItem3(C item3) {
        if(this.item3=="drunk"){
            return this.item3= (C) "true";
        }else if(this.item3=="not"){
            return this.item3 = (C) "false";
        }
        return this.item3=item3;
    }

    @Override
    public A getItem1() {
        return this.item1;
    }

    @Override
    public B getItem2() {
        return this.item2;
    }

    @Override
    public C getItem3() {
        return this.item3;
    }
    @Override
    public String toString(){
        return String.format("%s -> %s -> %s",getItem1(),getItem2(),getItem3());
    }
}
