import Interfaces.Target;
import Interfaces.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTests {

    @Test
    public void heroGettingsExperience(){
        Weapon weapon=Mockito.mock(Weapon.class);
        Target target=Mockito.mock(Target.class);
        Hero hero=new Hero("Gosho",weapon);
        Mockito.when(target.isDead()).thenReturn(true);
        Mockito.when(target.giveExperience()).thenReturn(1);
        hero.attack(target);
        Assert.assertEquals("Hero get experience",1,hero.getExperience());
    }
}
