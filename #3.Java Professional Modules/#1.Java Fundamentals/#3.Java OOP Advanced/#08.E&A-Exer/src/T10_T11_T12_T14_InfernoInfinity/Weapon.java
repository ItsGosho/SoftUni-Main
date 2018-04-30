package T10_T11_T12_T14_InfernoInfinity;

import T10_T11_T12_T14_InfernoInfinity.Enumerations.Gems;

import java.util.ArrayList;
import java.util.List;

public abstract class Weapon <T> implements Comparable<T>{
    private String name;
    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;
    private List<String> sockets;

    public Weapon(String name,String weaponType) {
        this.name = name;
        this.setInitCapacity(weaponType);
    }
    private void setInitCapacity(String weaponType){
        switch (weaponType){
            case "AXE":
                this.sockets=new ArrayList<>();
                for (int i = 0; i <4 ; i++) {
                    this.sockets.add("");
                }
                break;
            case "SWORD":
                this.sockets=new ArrayList<>();
                for (int i = 0; i <3 ; i++) {
                    this.sockets.add("");
                }
                break;
            case "KNIFE":
                this.sockets=new ArrayList<>();
                for (int i = 0; i <2; i++) {
                    this.sockets.add("");
                }
                break;
        }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getMinDamage() {
        return minDamage;
    }
    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
    public int getMaxDamage() {
        return maxDamage;
    }
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
    public int getNumberOfSockets() {
        return numberOfSockets;
    }
    public void setNumberOfSockets(int numberOfSockets) {
        this.numberOfSockets = numberOfSockets;
    }
    public void addGem(int index,String gemName){
        if(index<=this.numberOfSockets-1){
            this.sockets.set(index,"");
            this.sockets.set(index,gemName);
        }
    }
    public void removeGem(int index){
        if(!this.sockets.get(index).equals("")){
            this.clearOldGem(this.sockets.get(index));
            this.sockets.set(index,"");
        }
    }
    public void setStatisticsFromGems(String gemName){
        int gemInitialStrength=Gems.valueOf(gemName).getStrength();
        int gemInitialAgility=Gems.valueOf(gemName).getAgility();
        this.minDamage+=(gemInitialStrength*2)+(gemInitialAgility);
        this.maxDamage+=(gemInitialStrength*3)+(gemInitialAgility*4);
    }
    private void clearOldGem(String gemName){
        int gemInitialStrength=Gems.valueOf(gemName).getStrength();
        int gemInitialAgility=Gems.valueOf(gemName).getAgility();
        this.minDamage-=((gemInitialStrength*2)+(gemInitialAgility));
        this.maxDamage-=((gemInitialStrength*3)+(gemInitialStrength*4));
        this.maxDamage=Math.abs(this.maxDamage);
    }
    public double getItemLevel(){
        int strength=0;
        int agility=0;
        int vitality=0;
        for (int i = 0; i < this.sockets.size(); i++) {
            if(this.sockets.get(i).equals("RUBY")){
                strength+=7;
                agility+=2;
                vitality+=5;
            }else if(this.sockets.get(i).equals("EMERALD")){
                strength+=1;
                agility+=4;
                vitality+=9;
            }else if(this.sockets.get(i).equals("AMETHYST")){
                strength+=2;
                agility+=8;
                vitality+=4;
            }
        }
        double sum=((this.getMinDamage()+this.getMaxDamage())/2)+strength+agility+vitality;
        return sum;
    }
    @Override
    public String toString(){
        int strength=0;
        int agility=0;
        int vitality=0;
        for (int i = 0; i < this.sockets.size(); i++) {
            if(this.sockets.get(i).equals("RUBY")){
                strength+=7;
                agility+=2;
                vitality+=5;
            }else if(this.sockets.get(i).equals("EMERALD")){
                strength+=1;
                agility+=4;
                vitality+=9;
            }else if(this.sockets.get(i).equals("AMETHYST")){
                strength+=2;
                agility+=8;
                vitality+=4;
            }
        }
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality (Item Level: %.1f)",this.getName(),this.getMinDamage(),this.getMaxDamage(),strength,agility,vitality,this.getItemLevel());
    }

    @Override
    public int compareTo(T weapon2) {
           return 0;
    }
}
