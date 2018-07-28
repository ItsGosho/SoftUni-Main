package panzer;

import panzer.contracts.BattleOperator;
import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.models.entities.parts.Arsenal;
import panzer.models.entities.parts.Endurance;
import panzer.models.entities.parts.Shell;
import panzer.models.entities.vehicles.Revenger;
import panzer.models.entities.vehicles.Vanguard;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

public class ManagerImpl implements Manager {

    private HashMap<String,Vehicle> vehicles;
    private HashMap<String,Part> parts;
    private List<Vehicle> defeatedVehicles;

    public ManagerImpl(){
        this.vehicles=new LinkedHashMap<>();
        this.parts=new LinkedHashMap<>();
        this.defeatedVehicles=new LinkedList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) {
        String vehicleType=arguments.get(1);
        String model=arguments.get(2);
        double weight=Double.parseDouble(arguments.get(3));
        BigDecimal price=new BigDecimal(arguments.get(4));
        int attack=Integer.parseInt(arguments.get(5));
        int defense=Integer.parseInt(arguments.get(6));
        int hitPoints=Integer.parseInt(arguments.get(7));

        switch (vehicleType){
            case "Vanguard":
                Vehicle vanguard=new Vanguard(model,weight,price,attack,defense,hitPoints);
                this.vehicles.put(model,vanguard);
                break;
            case "Revenger":
                Vehicle revenger=new Revenger(model,weight,price,attack,defense,hitPoints);
                this.vehicles.put(model,revenger);
                break;
        }
        return String.format("Created %s Vehicle - %s",vehicleType,model);
    }

    @Override
    public String addPart(List<String> arguments) {
        String vehicleModel=arguments.get(1);
        String partType=arguments.get(2);
        String model=arguments.get(3);
        double weight=Double.parseDouble(arguments.get(4));
        BigDecimal price=new BigDecimal(arguments.get(5));
        int additionalParameter=Integer.parseInt(arguments.get(6));
        switch (partType){
            case "Arsenal":
                Part arsenal=new Arsenal(model,weight,price,additionalParameter);
                this.parts.put(model,arsenal);
                this.vehicles.get(vehicleModel).addArsenalPart(arsenal);
                break;
            case "Endurance":
                Part endurance=new Endurance(model,weight,price,additionalParameter);
                this.parts.put(model,endurance);
                this.vehicles.get(vehicleModel).addEndurancePart(endurance);
                break;
            case "Shell":
                Part shell=new Shell(model,weight,price,additionalParameter);
                this.parts.put(model,shell);
                this.vehicles.get(vehicleModel).addShellPart(shell);
                break;
        }
        return String.format("Added %s - %s to Vehicle - %s",partType,model,vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {
        if(this.vehicles.containsKey(arguments.get(1))){
           return this.vehicles.get(arguments.get(1)).toString();
        }else {
            return this.parts.get(arguments.get(1)).toString();
        }
    }

    @Override
    public String battle(List<String> arguments) {
        BattleOperator battleOperator=new PanzerBattleOperator();
        Vehicle attacker=this.vehicles.get(arguments.get(1));
        Vehicle target=this.vehicles.get(arguments.get(2));
        if(target.getModel().equals(battleOperator.battle(attacker,target))){
            String model=target.getModel();
            this.defeatedVehicles.add(attacker);
            this.vehicles.remove(attacker.getModel());
            return String.format("%s versus %s -> %s Wins! Flawless Victory!",attacker.getModel(),target.getModel(),model);
        }else{
            String model=attacker.getModel();
            this.defeatedVehicles.add(target);
            this.vehicles.remove(target.getModel());
            return String.format("%s versus %s -> %s Wins! Flawless Victory!",attacker.getModel(),target.getModel(),model);
        }
    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder str=new StringBuilder();
        int currUsedParts=0;
        List<String> modelsRemaining = new LinkedList<>();
        for (Vehicle value : this.vehicles.values()) {
            modelsRemaining.add(value.getModel());
            currUsedParts+=value.getParts().spliterator().estimateSize();
        }
        if(modelsRemaining.size()!=0){
            str.append(String.format("Remaining Vehicles: %s%n",String.join(", ",modelsRemaining)));
        }else{
            str.append(String.format("Remaining Vehicles: None%n"));
        }
        List<String> defeatedVehicles = new LinkedList<>();
        for (Vehicle value : this.defeatedVehicles) {
            defeatedVehicles.add(value.getModel());
        }
        if(defeatedVehicles.size()!=0){
            str.append(String.format("Defeated Vehicles: %s%n",String.join(", ",defeatedVehicles)));
        }else{
            str.append(String.format("Defeated Vehicles: None%n"));
        }
        str.append("Currently Used Parts: "+currUsedParts);
        return str.toString();
    }
}
