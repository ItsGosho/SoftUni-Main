package tests;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;
import cresla.interfaces.Module;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.math.BigInteger;
import java.util.List;

public class ModuleContainerTests {

    @Mock
    private Container container;

    @Before
    public void initialize(){
       this.container=new ModuleContainer(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEnergyModule_WithNull(){
        EnergyModule energyModule=null;
        this.container.addEnergyModule(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddEbsorbingModule_WithNull(){
        EnergyModule energyModule=null;
        this.container.addAbsorbingModule(null);
    }

    @Test
    public void testGetTotalEnergyOutput(){
        EnergyModule energyModule=Mockito.mock(EnergyModule.class);
        Mockito.when(energyModule.getEnergyOutput()).thenReturn(11);
        this.container.addEnergyModule(energyModule);
        Assert.assertEquals(11,this.container.getTotalEnergyOutput());
    }
    @Test
    public void testGetTotalHeatAbsorbing(){
        AbsorbingModule absorbingModule=Mockito.mock(AbsorbingModule.class);
        Mockito.when(absorbingModule.getHeatAbsorbing()).thenReturn(53);
        this.container.addAbsorbingModule(absorbingModule);
        Assert.assertEquals(53,this.container.getTotalHeatAbsorbing());
    }

    @Test
    public void testAddAbsorbingModule_RemoveOld(){

    }
}
