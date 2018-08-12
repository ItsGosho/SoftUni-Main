package callofduty.domain.agents;

import callofduty.domain.missions.MissionImp;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.LinkedList;
import java.util.List;

public abstract class AgentImp implements Agent {

    private String id;
    private String name;
    private double rating;
    private List<Mission> missions;

    AgentImp(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missions=new LinkedList<>();
    }


    @Override
    public void acceptMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public void completeMissions() {
//        int totalMissionsCount=missions.size();
//        if(this.getClass().getSimpleName().equals("NoviceAgent")){
//            int totalMissionsCompleted=0;
//            for (Mission mission : missions) {
//                MissionImp missionImp = (MissionImp) mission;
//                if(!missionImp.isCompleted()){
//                    ((MissionImp) mission).setCompleted();
//                    rating+=mission.getRating();
//                    totalMissionsCompleted++;
//                }else{
//                    totalMissionsCompleted++;
//                }
//            }
//            if(totalMissionsCompleted>3){
//               //TODO: PROMOTE
//            }
//        }else{
//            for (Mission mission : missions) {
//                MissionImp missionImp = (MissionImp) mission;
//                if(!missionImp.isCompleted()){
//                    ((MissionImp) mission).setCompleted();
//                    rating+=mission.getRating();
//
//                }
//            }
//        }
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    public List<Mission> getMissions() {
        return missions;
    }

}
