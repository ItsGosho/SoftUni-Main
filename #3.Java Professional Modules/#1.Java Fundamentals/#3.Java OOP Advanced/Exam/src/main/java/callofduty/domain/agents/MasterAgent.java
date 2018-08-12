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
}
