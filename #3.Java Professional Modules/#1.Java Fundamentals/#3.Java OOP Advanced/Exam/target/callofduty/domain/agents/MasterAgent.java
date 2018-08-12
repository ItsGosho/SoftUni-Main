package callofduty.domain.agents;

import callofduty.domain.missions.MissionImp;
import callofduty.interfaces.BountyAgent;
import callofduty.interfaces.Mission;

public class MasterAgent extends AgentImp implements BountyAgent {

    private double bounty;


    public MasterAgent(String id, String name, double rating) {
        super(id, name, rating);
        this.bounty=0;
    }

    @Override
    public void completeMissions() {
        super.completeMissions();
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    public void setBounty(double bounty) {
        this.bounty = bounty;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Master Agent - %s%n",getName()));
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
        str.append(String.format("Rating: %.2f%n",getRating()));
        str.append(String.format("Bounty Earned: $%.2f",getBounty()));
        return str.toString();
    }
}
