package T01_Weekdays;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        WeeklyCalendar wc=new WeeklyCalendar();
        wc.addEntry("Friday","SHE QM");
        wc.addEntry("Saturday","SHE QM");
        wc.addEntry("Monday","SHE QM");
        wc.addEntry("Sunday","SHE QM");
        for (WeeklyEntry weeklyEntry : wc.getWeeklySchedule()) {
            System.out.println(weeklyEntry);
        }
    }
}
