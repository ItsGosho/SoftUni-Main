import org.junit.Assert;
import org.junit.Test;

public class DummyTest {
     private static final int DUMMY_INITIAL_ATTACK=5;
     private static final int DUMMY_INITIAL_DURABILITY=1;
     private static final int DUMMY_INITIAL_HEALTH=10;
     private static final int DUMMY_INITIAL_EXPERIENCE=0;
     private Axe axe=new Axe(DUMMY_INITIAL_ATTACK,DUMMY_INITIAL_DURABILITY);
     private Dummy dummy=new Dummy(DUMMY_INITIAL_HEALTH,DUMMY_INITIAL_EXPERIENCE);

    @Test
    public void dummyLosesHealthAfterAttack(){
        this.axe.attack( this.dummy);
        Assert.assertEquals("Dummy got fucked up",5, this.dummy.getHealth());
    }
    @Test(expected = IllegalStateException.class)
    public void dummyThrowsExceptionAfterAttack(){
        this.axe.attack( this.dummy);
        this.axe.attack( this.dummy);
        this.axe.attack( this.dummy);
    }

}
