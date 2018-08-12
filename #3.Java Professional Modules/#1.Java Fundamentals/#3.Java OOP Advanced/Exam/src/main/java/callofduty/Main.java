package callofduty;

import callofduty.interfaces.MissionManager;
import callofduty.manager.MissionManagerImp;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {

        Scanner skener = new Scanner(System.in);
        MissionManager missionManager = new MissionManagerImp();

        while (true){
            String line = skener.nextLine();
            List<String> splitted = Arrays.asList(line.split("\\s+"));
            if(splitted.get(0).equals("Over")){
                System.out.println(missionManager.over(splitted));
                break;
            }
            switch (splitted.get(0)){
                case "Agent":
                    System.out.println(missionManager.agent(splitted));
                    break;
                case "Request":
                    System.out.println(missionManager.request(splitted));
                    break;
                case "Complete":
                    System.out.println(missionManager.complete(splitted));
                    break;
                case "Status":
                    System.out.println(missionManager.status(splitted));
                    break;
            }
        }
    }
}




