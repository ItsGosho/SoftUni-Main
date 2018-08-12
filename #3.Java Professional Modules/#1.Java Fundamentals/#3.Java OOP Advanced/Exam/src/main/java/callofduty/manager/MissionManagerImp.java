package callofduty.manager;

import callofduty.core.MissionControlImpl;
import callofduty.domain.agents.AgentImp;
import callofduty.domain.agents.MasterAgent;
import callofduty.domain.missions.MissionImp;
import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.domain.agents.NoviceAgent;

import java.lang.reflect.Field;
import java.util.*;

public class MissionManagerImp implements MissionManager {
    private HashMap<String, Agent> agents;
    private HashMap<String,List<Mission>> agentMissions;
    private MissionControl missionControl;

    public MissionManagerImp() {
        this.agents = new LinkedHashMap<>();
        this.missionControl = new MissionControlImpl();
        this.agentMissions=new LinkedHashMap<>();
    }

    @Override
    public String agent(List<String> arguments) {
        this.agents.put(arguments.get(1), new NoviceAgent(arguments.get(1), arguments.get(2)));
        this.agentMissions.put(arguments.get(1),new LinkedList<>());
        return String.format("Registered Agent - %s:%s", arguments.get(2), arguments.get(1));
    }

    @Override
    public String request(List<String> arguments) {
        Mission mission = this.missionControl
                .generateMission(arguments.get(2),
                        Double.parseDouble(arguments.get(3)),
                        Double.parseDouble(arguments.get(4)));
        this.agentMissions.get(arguments.get(1)).add(mission);
        if(mission.getClass().getSimpleName().equals("EscortMission")){
            return String.format("Assigned Escort Mission - %s to Agent - %s", mission.getId(), this.agents.get(arguments.get(1)).getName());
        }else if(mission.getClass().getSimpleName().equals("HuntMission")){
            return String.format("Assigned Hunt Mission - %s to Agent - %s", mission.getId(), this.agents.get(arguments.get(1)).getName());
        }else{
            return String.format("Assigned Surveillance Mission - %s to Agent - %s", mission.getId(), this.agents.get(arguments.get(1)).getName());
        }
    }

    @Override
    public String complete(List<String> arguments) {
        Agent agent = this.agents.get(arguments.get(1));
        if (agent.getClass().getSimpleName().equals("NoviceAgent")) {
            AgentImp agentImp = (AgentImp) agent;
            int totalMissionsCompleted = 0;
            for (Mission mission : this.agentMissions.get(arguments.get(1))) {
                MissionImp missionImp = (MissionImp) mission;
                if (!missionImp.isCompleted()) {
                    ((MissionImp) mission).setCompleted();
                        agentImp.setRating(agentImp.getRating()+ mission.getRating());
                    totalMissionsCompleted++;
                } else {
                    totalMissionsCompleted++;
                }
            }
            if (totalMissionsCompleted >= 3) {
                Agent masterAgent = new MasterAgent(agentImp.getId(), agentImp.getName(), agentImp.getRating());
                this.agentMissions.get(agentImp.getId()).clear();
                this.agents.remove(arguments.get(1));
                this.agents.put(masterAgent.getId(), masterAgent);
            }
        } else {
            MasterAgent agentImp = (MasterAgent) agent;
            for (Mission mission : this.agentMissions.get(agentImp.getId())) {
                MissionImp missionImp = (MissionImp) mission;
                if (!missionImp.isCompleted()) {
                    ((MissionImp) mission).setCompleted();

                    agentImp.setRating(agentImp.getRating() + mission.getRating());
                    agentImp.setBounty(agentImp.getBounty() + mission.getBounty());
                }
            }
        }
        return String.format("Agent - %s:%s has completed all assigned missions.", agent.getName(), agent.getId());
    }

    @Override
    public String status(List<String> arguments) {
        StringBuilder str=new StringBuilder();
        final Mission[] mission = {null};
        if (this.agents.containsKey(arguments.get(1))) {
            String className=this.agents.get(arguments.get(1)).getClass().getSimpleName();
            if(className.equals("NoviceAgent")){
                NoviceAgent noviceAgent = (NoviceAgent) this.agents.get(arguments.get(1));
                str.append(String.format("Novice Agent - %s%n",noviceAgent.getName()));
                str.append(String.format("Personal Code: %s%n",noviceAgent.getId()));
                int countCompleted=0;
                for (Mission mission1 : this.agentMissions.get(arguments.get(1))) {
                    MissionImp missionImp = (MissionImp) mission1;
                    if(missionImp.isCompleted()){
                        countCompleted++;
                    }
                }
                str.append(String.format("Assigned Missions: %d%n",this.agentMissions.get(arguments.get(1)).size()-countCompleted));
                str.append(String.format("Completed Missions: %d%n",countCompleted));
                str.append(String.format("Rating: %.2f",noviceAgent.getRating()));
            }else if(className.equals("MasterAgent")){
                MasterAgent masterAgent = (MasterAgent) this.agents.get(arguments.get(1));
                str.append(String.format("Master Agent - %s%n",masterAgent.getName()));
                str.append(String.format("Personal Code: %s%n",masterAgent.getId()));
                int countCompleted=0;
                for (Mission mission1 :  this.agentMissions.get(arguments.get(1))) {
                    MissionImp missionImp = (MissionImp) mission1;
                    if(missionImp.isCompleted()){
                        countCompleted++;
                    }
                }
                str.append(String.format("Assigned Missions: %d%n",this.agentMissions.get(arguments.get(1)).size()-countCompleted));
                str.append(String.format("Completed Missions: %d%n",countCompleted));
                str.append(String.format("Rating: %.2f%n",masterAgent.getRating()));
                str.append(String.format("Bounty Earned: $%.2f",masterAgent.getBounty()));
            }
        } else {

            this.agentMissions.entrySet()
                    .forEach(x->{
                        x.getValue().stream().forEach(a->{
                            if(a.getId().equals(arguments.get(1))){
                                str.append(a.toString());
                            }
                        });
                    });

        }
        return str.toString();
    }

    @Override
    public String over(List<String> arguments) {
        StringBuilder str = new StringBuilder();
        final int[] totalNoviceAgents = {0};
        final int[] totalMasterAgents = {0};
        final double[] totalRatingGiven = {0};
        final double[] totalBountyGiven = {0};
        this.agents.values().stream().forEach(x->{
            if(x.getClass().getSimpleName().equals("NoviceAgent")){
                 totalNoviceAgents[0]++;
                 totalRatingGiven[0] +=x.getRating();
            }else{
                totalRatingGiven[0] +=x.getRating();
                MasterAgent masterAgent= (MasterAgent) x;
                totalBountyGiven[0] +=masterAgent.getBounty();
                totalMasterAgents[0]++;
            }
        });
        final int[] totalAssignedMission = {0};
        final int[] totalCompletedMissions = {0};
        this.agents.values().stream().forEach(x->{
            AgentImp agentImp= (AgentImp) x;

            this.agentMissions.get(x.getId()).stream().forEach(a->{
                MissionImp missionImp= (MissionImp) a;
                if(missionImp.isCompleted()){
                    totalCompletedMissions[0]++;
                    totalAssignedMission[0]++;
                }else{
                    totalAssignedMission[0]++;
                }
            });

        });
        str.append(String.format("Novice Agents: %d%n",totalNoviceAgents[0]));
        str.append(String.format("Master Agents: %d%n",totalMasterAgents[0]));
        str.append(String.format("Assigned Missions: %d%n",totalAssignedMission[0]));
        str.append(String.format("Completed Missions: %d%n",totalCompletedMissions[0]));
        str.append(String.format("Total Rating Given: %.2f%n",totalRatingGiven[0]));
        str.append(String.format("Total Bounty Given: $%.2f",totalBountyGiven[0]));
        return str.toString();
    }
}
