package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import panzer.contracts.*;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.List;

public class VehicleAssemblerTests {

    private VehicleAssembler vehicleAssembler;

   @Before
    public void setup(){
         this.vehicleAssembler=new VehicleAssembler();
   }

    @Test
    public void testGetTotalAttackModification_Result(){
       AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
       Mockito.when(attackModifyingPart.getAttackModifier()).thenReturn(8);
       this.vehicleAssembler.addArsenalPart(attackModifyingPart);
       Assert.assertEquals(8,this.vehicleAssembler.getTotalAttackModification());
    }

    @Test
    public void testGetTotalDefenseModification_Result(){
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        Mockito.when(defenseModifyingPart.getDefenseModifier()).thenReturn(10);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);
        Assert.assertEquals(10,this.vehicleAssembler.getTotalDefenseModification());
    }

    @Test
    public void testGetTotalHitPointModification_Result(){
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        Mockito.when(hitPointsModifyingPart.getHitPointsModifier()).thenReturn(12);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
        Assert.assertEquals(12,this.vehicleAssembler.getTotalHitPointModification());
    }

    @Test
    public void testGetTotal_Price(){
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);
        this.vehicleAssembler.addArsenalPart(attackModifyingPart);
        Mockito.when(attackModifyingPart.getPrice()).thenReturn(new BigDecimal("10"));
        Mockito.when(defenseModifyingPart.getPrice()).thenReturn(new BigDecimal("5"));
        Mockito.when(hitPointsModifyingPart.getPrice()).thenReturn(new BigDecimal("3"));
        Assert.assertEquals(new BigDecimal(18),this.vehicleAssembler.getTotalPrice());
    }

    @Test
    public void testGetTotalWeight_Price(){
        AttackModifyingPart attackModifyingPart = Mockito.mock(AttackModifyingPart.class);
        DefenseModifyingPart defenseModifyingPart = Mockito.mock(DefenseModifyingPart.class);
        HitPointsModifyingPart hitPointsModifyingPart = Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);
        this.vehicleAssembler.addArsenalPart(attackModifyingPart);
        Mockito.when(attackModifyingPart.getWeight()).thenReturn(5.00);
        Mockito.when(defenseModifyingPart.getWeight()).thenReturn(6.00);
        Mockito.when(hitPointsModifyingPart.getWeight()).thenReturn(4.00);
        Assert.assertEquals(15.00,this.vehicleAssembler.getTotalWeight(),0);
    }

    @Test
    public void testAddArsenalPart() throws NoSuchFieldException, IllegalAccessException {
       AttackModifyingPart attackModifyingPart=Mockito.mock(AttackModifyingPart.class);
       this.vehicleAssembler.addArsenalPart(attackModifyingPart);
        Field field = VehicleAssembler.class.getDeclaredField("arsenalParts");
        field.setAccessible(true);
        List<AttackModifyingPart> collectionsGotten = (List<AttackModifyingPart>) field.get(this.vehicleAssembler);
        Assert.assertEquals(attackModifyingPart,collectionsGotten.get(0));
    }

    @Test
    public void testAddShellPart() throws NoSuchFieldException, IllegalAccessException {
        DefenseModifyingPart defenseModifyingPart=Mockito.mock(DefenseModifyingPart.class);
        this.vehicleAssembler.addShellPart(defenseModifyingPart);
        Field field = VehicleAssembler.class.getDeclaredField("shellParts");
        field.setAccessible(true);
        List<DefenseModifyingPart> collectionsGotten = (List<DefenseModifyingPart>) field.get(this.vehicleAssembler);
        Assert.assertEquals(defenseModifyingPart,collectionsGotten.get(0));
    }

    @Test
    public void testAddEndurancePart() throws NoSuchFieldException, IllegalAccessException {
        HitPointsModifyingPart hitPointsModifyingPart=Mockito.mock(HitPointsModifyingPart.class);
        this.vehicleAssembler.addEndurancePart(hitPointsModifyingPart);
        Field field = VehicleAssembler.class.getDeclaredField("enduranceParts");
        field.setAccessible(true);
        List<HitPointsModifyingPart> collectionsGotten = (List<HitPointsModifyingPart>) field.get(this.vehicleAssembler);
        Assert.assertEquals(hitPointsModifyingPart,collectionsGotten.get(0));
    }
}
