package tests;

import callofduty.core.MissionControlImpl;
import callofduty.domain.missions.HuntMission;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class MissionControlTests {

    private MissionControl missionControl;

    @Before
    public void initialize(){
          this.missionControl=new MissionControlImpl();
    }

    @Test
    public void generateMissionTestReformingMAX(){
        Mission mission = this.missionControl.
                generateMission("123456789",101.00,1000000.00);
        Assert.assertEquals("12345678",mission.getId());
        Assert.assertEquals(75.0,mission.getRating(),0);
        Assert.assertEquals(125000.0,mission.getBounty(),0);
    }

    @Test
    public void generateMissionTestReformingMIN(){
        Mission mission = this.missionControl.
                generateMission("",-105.00,-1000000.00);
        Assert.assertEquals("",mission.getId());
        Assert.assertEquals(0.00,mission.getRating(),0);
        Assert.assertEquals(0.00,mission.getBounty(),0);
    }

    @Test
    public void generateMissionTestCurrentMission_Next(){
        Mission escortMission = this.missionControl.
                generateMission("123",75.00,9551.00);
        Mission huntMission = this.missionControl.
                generateMission("123",75.00,9551.00);
        Assert.assertEquals("HuntMission",huntMission.getClass().getSimpleName());
    }
    @Test
    public void generateMissionTestCurrentMission_RunOut(){
        Mission escortMission = this.missionControl.
                generateMission("123",75.00,9551.00);
        Mission huntMission = this.missionControl.
                generateMission("123",75.00,9551.00);
        Mission surveillance = this.missionControl.
                generateMission("123",75.00,9551.00);
        Mission newEscort = this.missionControl.
                generateMission("123",75.00,9551.00);
        Mission testtt = this.missionControl.
                generateMission("123",75.00,9551.00);
        Assert.assertEquals("HuntMission",testtt.getClass().getSimpleName());
    }

    @Test
    public void testInitMissionClasses() throws NoSuchFieldException, IllegalAccessException {
        MissionControl missionControl=new MissionControlImpl();
        Field field= missionControl.getClass().getDeclaredField("missionIterator");
        field.setAccessible(true);
        Iterator<Map.Entry<String, Class>> iterator = (Iterator<Map.Entry<String, Class>>) field.get(missionControl);
        int sizeIterator=0;
        while (iterator.hasNext()){
            iterator.next();
            sizeIterator++;
        }
        Assert.assertEquals(sizeIterator,3);
    }

    @Test
    public void testOverFlow(){
        Mission escortMission = this.missionControl.
                generateMission("123", Double.MAX_VALUE, Double.MAX_VALUE);
    }
}
