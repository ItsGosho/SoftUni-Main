package T04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private static List<Person> firstTeam=new ArrayList<>();
    private static List<Person> reserveTeam=new ArrayList<>();

    public void addPlayer(Person person){
        this.name=person.getName();
        this.setPlayerTeam(person);
    }
    private void setPlayerTeam(Person person){
           if(person.getAge()>40){
               Team.firstTeam.add(person);
           }else{
               Team.reserveTeam.add(person);
           }
    }
    public List<Person> getFirstTeam(){
        return Collections.unmodifiableList(Team.firstTeam);
    }
    public List<Person> getSecondTeam(){
        return Collections.unmodifiableList(Team.reserveTeam);
    }
}
