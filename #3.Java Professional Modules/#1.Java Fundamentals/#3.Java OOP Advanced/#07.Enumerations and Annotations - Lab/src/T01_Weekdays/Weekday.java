package T01_Weekdays;

public enum Weekday {
    MONDAY(1),TUESDAY(2),WEDNESDAY(3),THURSDAY(4),FRIDAY(5),SATURDAY(6),SUNDAY(7);

     private int day;
     Weekday(int day){
         this.day=day;
     }
     public int getDay(){
         return this.day;
     }
    @Override
    public String toString() {
        return this.name().charAt(0)+this.name().substring(1).toLowerCase();
    }
}
