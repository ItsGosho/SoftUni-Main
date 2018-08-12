package callofduty.domain.missions;

public class HuntMission extends MissionImp {

    public HuntMission(String id, double rating, double bounty) {
        super(id, rating*1.50, bounty*2);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Hunt Mission – %s%n",
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
