package T01_Weekdays;

public class WeeklyEntry {
     private Weekday weekday;
     private String notes;

    public WeeklyEntry(String weekday, String notes){
         this.setWeekday(weekday.toUpperCase());
         this.notes=notes;
    }

    public void setWeekday(String weekday) {
        this.weekday=Weekday.valueOf(weekday);
    }
    public String getWeekday() {
        return weekday.toString();
    }
    public int getNumberDay(){
        return weekday.ordinal();
    }
    public String getNotes() {
        return notes;
    }

    @Override
    public String toString() {
        return this.weekday+" - "+this.notes;
    }
}
