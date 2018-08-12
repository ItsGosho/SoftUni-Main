package callofduty.domain.missions;

public class SurveillanceMission extends MissionImp {


    public SurveillanceMission(String id, double rating, double bounty) {
        super(id, rating-(rating*0.75), bounty*1.50);
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Surveillance Mission – %s%n",
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
