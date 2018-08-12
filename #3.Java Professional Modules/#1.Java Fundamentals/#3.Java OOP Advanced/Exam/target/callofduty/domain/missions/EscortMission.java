package callofduty.domain.missions;

public class EscortMission extends MissionImp {

    public EscortMission(String id, double rating, double bounty) {
        super(id, rating-(rating*0.25), bounty*1.25);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Escort Mission – %s%n",
                this.getId()));
        if(!super.isCompleted()){
            str.append(String.format("Status: Open%n"));
        }else{
            str.append(String.format("Status: Completed%n"));
        }
        str.append(String.format("Rating: %.2f%n",this.getRating()));
        str.append(String.format("Bounty: %.2f",this.getBounty()));
        return str.toString();
    }
}
