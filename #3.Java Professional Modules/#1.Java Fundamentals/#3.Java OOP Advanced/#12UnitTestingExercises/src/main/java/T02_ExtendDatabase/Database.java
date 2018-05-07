package T02_ExtendDatabase;

import java.util.Stack;

public class Database {
    private boolean containsId;
    private boolean containsPerson;
    private Stack<People> people;
    private People returnPeople;

    public Database(){
        this.people=new Stack<>();
    }
    public void add(People people){
        containsId=false;
        this.people.stream().forEach(x->{
            if(x.getId()==people.getId()){
                containsId=true;
            }
        });
        if(people.getId()<=-1 || this.people.size()==16 || containsId) {
            throw new UnsupportedOperationException();
        }
        this.people.add(people);
    }
    public void remove(){
         if(this.people.size()==0){
             throw new UnsupportedOperationException();
         }
         this.people.pop();
    }
    public People findByUsername(String username){
        containsPerson=false;
        this.people.stream().forEach(x->{
            if(x.getUsername().equals(username)){
                containsPerson=true;
                returnPeople=x;
            }
        });
        if(containsPerson){
            return this.returnPeople;
        }else{
            throw new UnsupportedOperationException();
        }
    }
    public People findById(int id){
        containsId=false;
        this.people.stream().forEach(x->{
            if(x.getId()==id){
                containsId=true;
                this.returnPeople=x;
            }
        });
        if(this.containsId){
            return this.returnPeople;
        }else{
            throw new UnsupportedOperationException();
        }
    }
}
