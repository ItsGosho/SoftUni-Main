import org.junit.Assert;
import org.junit.Test;

public class AxeTests {
    private static final int DUMMY_INITIAL_ATTACK=5;
    private static final int DUMMY_INITIAL_DURABILITY=2;
    private static final int DUMMY_INITIAL_HEALTH=30;
    private static final int DUMMY_INITIAL_EXPERIENCE=0;
    private Axe axe=new Axe(DUMMY_INITIAL_ATTACK,DUMMY_INITIAL_DURABILITY);
    private Dummy dummy=new Dummy(DUMMY_INITIAL_HEALTH,DUMMY_INITIAL_EXPERIENCE);

    @Test
    public void axeLoseDurabilityAfterAttacks(){
         this.axe.attack( this.dummy);
        Assert.assertEquals("Axe loses durability",1, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeAttackWithBrokenWeapon(){
        this.axe.attack( this.dummy);
        this.axe.attack( this.dummy);
        this.axe.attack( this.dummy);
    }
}
