package panzer.models.entities.vehicles;

import panzer.contracts.Assembler;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public abstract class VehicleImpl implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler vehicleAssembler;
    private List<Part> parts;

    public VehicleImpl(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.vehicleAssembler=new VehicleAssembler();
        this.parts=new LinkedList<>();
    }

    @Override
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public int getHitPoints() {
        return hitPoints;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    @Override
    public double getTotalWeight() {
        return this.vehicleAssembler.getTotalWeight()+weight;
    }
    @Override
    public BigDecimal getTotalPrice() {
        return price=price.add(this.vehicleAssembler.getTotalPrice());
    }
    @Override
    public long getTotalAttack() {
        return this.vehicleAssembler.getTotalAttackModification()+attack;
    }
    @Override
    public long getTotalDefense() {
        return this.vehicleAssembler.getTotalDefenseModification()+defense;
    }
    @Override
    public long getTotalHitPoints() {
        return this.vehicleAssembler.getTotalHitPointModification()+hitPoints;
    }
    @Override
    public void addArsenalPart(Part arsenalPart) {
          this.vehicleAssembler.addArsenalPart(arsenalPart);
          this.parts.add(arsenalPart);
    }
    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);
        this.parts.add(shellPart);
    }
    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
        this.parts.add(endurancePart);
    }
    @Override
    public Iterable<Part> getParts() {
        return this.parts;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Total Weight: %.3f%nTotal Price: %.3f%nAttack: %d%nDefense: %d%nHitPoints: %d%n",
                getTotalWeight(),
                getTotalPrice(),
                getTotalAttack(),
                getTotalDefense(),
                getTotalHitPoints()));
        return str.toString();
    }
}
