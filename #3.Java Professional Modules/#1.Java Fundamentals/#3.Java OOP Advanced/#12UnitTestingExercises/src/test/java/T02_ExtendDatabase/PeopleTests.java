package T02_ExtendDatabase;

import T02_ExtendDatabase.Database;
import T02_ExtendDatabase.People;
import org.junit.Before;
import org.junit.Test;

public class PeopleTests {
    Database database;

    @Before
    public void setDatabase(){
        this.database=new Database();
    }
    @Test(expected = UnsupportedOperationException.class)
    public void addExistingUser(){
        People people1=new People(1,"Joro");
        People people2=new People(1,"Boro");
        database.add(people1);
        database.add(people2);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addWithNegativeId(){
        People people1=new People(-1,"Joro");
        database.add(people1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeFromEmptyPeopleDB(){
        database.remove();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void findNotExistingPeopleByUsername(){
        database.findByUsername("Joro");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void findNotExistingPeopleById(){
        database.findById(1);
    }
}
