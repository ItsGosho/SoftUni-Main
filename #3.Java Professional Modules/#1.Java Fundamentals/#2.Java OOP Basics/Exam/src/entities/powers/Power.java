package entities.powers;


import entities.powers.interfaces.SuperPower;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Power implements SuperPower {

    private String name;
    private double powerPoints;

    public Power(String name, double powerPoints) {
        this.setName(name);
        this.setPowerPoints(powerPoints);
    }

    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        Matcher matcher=Pattern.compile("(\\@[A-Za-z\\_]+\\@)").matcher(name);
        if(name.length()>=5 && matcher.find()){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Super power name not in the correct format!");
        }
    }
    @Override
    public double getPowerPoints() {
        return powerPoints+(name.length()/2);
    }
    public void setPowerPoints(double powerPoints) {
        if(powerPoints>=0){
            this.powerPoints = powerPoints;
        }else{
            throw new IllegalArgumentException("Power points should be a possitive number!");
        }
    }
    
    
}
