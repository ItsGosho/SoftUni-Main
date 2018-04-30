package T01_Weekdays;

import java.util.ArrayList;
import java.util.List;

public class WeeklyCalendar {

    private List<WeeklyEntry> entrys;
    public WeeklyCalendar(){
        this.entrys=new ArrayList<>();
    }
    public void addEntry(String weekday, String notes){
          this.entrys.add(new WeeklyEntry(weekday,notes));
    }

    public Iterable<WeeklyEntry> getWeeklySchedule(){
        this.entrys.sort((x1,x2)->Integer.compare(x1.getNumberDay(),x2.getNumberDay()));
        return this.entrys;
    }
}
