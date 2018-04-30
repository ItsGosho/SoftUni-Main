package T02_WarningLevels;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String rdInit=skener.nextLine();
        int initialAlert=Importance.valueOf(rdInit).getAlertHowHigh();
        Message message=new Message(initialAlert);
       while(true){
           String line=skener.nextLine();
           if(line.equals("END")){
                break;
           }
           try {
               message.addMessage(line);
           }catch (IllegalArgumentException ex){};
       }
       for(Logger item:message.getMessages()){
           System.out.println(item);
       }
    }
}
