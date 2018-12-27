package itsgosho.config.validators.dateBefore.tools;

import java.time.LocalDate;

public class DateBeforeUtils {

    public static boolean isValid(String values){
        String[] fieldDateSplitted = values.split("-");
        if(fieldDateSplitted.length!=3){
            return false;
        }else{
            try{
                for (int i = 0; i < fieldDateSplitted.length; i++) {
                    int value =  Integer.parseInt(fieldDateSplitted[i]);
                }
            }catch (Exception ex){
                 return false;
            }
        }
        return true;
    }

    public static LocalDate parseDate(String date){
        String[] fieldDateSplitted = date.split("-");
        LocalDate dateParsed =  LocalDate.of(Integer.parseInt(fieldDateSplitted[0]),Integer.parseInt(fieldDateSplitted[1]),Integer.parseInt(fieldDateSplitted[2]));
        return dateParsed;
    }
}
