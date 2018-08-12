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

    AgentImp(String id, String name, double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
    }

    @Override
    public void acceptMission(Mission mission) {
    }

    @Override
    public void completeMissions() {
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
