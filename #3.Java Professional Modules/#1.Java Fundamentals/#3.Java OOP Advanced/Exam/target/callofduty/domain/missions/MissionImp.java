package callofduty.domain.missions;

import callofduty.interfaces.Mission;

public abstract class MissionImp implements Mission {

    private String id;
    private double rating;
    private double bounty;
    private boolean isCompleted;

    MissionImp(String id, double rating, double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
        isCompleted=false;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted() {
        this.isCompleted = true;
    }
}
