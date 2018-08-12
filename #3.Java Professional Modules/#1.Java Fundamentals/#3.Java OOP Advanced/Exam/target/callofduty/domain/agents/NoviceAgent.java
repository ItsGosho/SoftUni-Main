package callofduty.domain.agents;

import callofduty.domain.missions.MissionImp;
import callofduty.interfaces.Mission;

public class NoviceAgent extends AgentImp {

    public NoviceAgent(String id, String name) {
        super(id, name, 0);
    }


    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Novice Agent - %s%n",getName()));
        str.append(String.format("Personal Code: %s%n",getId()));
        int countCompleted=0;
        for (Mission mission : super.getMissions()) {
            MissionImp missionImp = (MissionImp) mission;
            if(missionImp.isCompleted()){
                countCompleted++;
            }
        }
        str.append(String.format("Assigned Missions: %d%n",super.getMissions().size()-countCompleted));
        str.append(String.format("Completed Missions: %d%n",countCompleted));
        str.append(String.format("Rating: %.2f",getRating()));
        return str.toString();
    }
}
