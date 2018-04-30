package T10_T11_T12_T14_InfernoInfinity;

import T10_T11_T12_T14_InfernoInfinity.Weapons.Axe;
import T10_T11_T12_T14_InfernoInfinity.Weapons.Knife;
import T10_T11_T12_T14_InfernoInfinity.Weapons.Sword;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponController {

    private Map<String,Weapon> weapons;
    public WeaponController(){
        this.weapons=new LinkedHashMap<>();
    }
    public void Create(String type,String weaponName){
          switch (type){
              case "AXE":
                  Weapon axe=new Axe(weaponName,type);
                  this.weapons.put(weaponName,axe);
                  break;
              case "SWORD":
                  Weapon sword=new Sword(weaponName,type);
                  this.weapons.put(weaponName,sword);
                  break;
              case "KNIFE":
                  Weapon knife=new Knife(weaponName,type);
                  this.weapons.put(weaponName,knife);
                  break;
          }
    }
    public void Add(String weaponName,int index,String gemName){
        if(this.weapons.containsKey(weaponName)){
            Weapon weapon=this.weapons.get(weaponName);
            weapon.addGem(index,gemName);
            weapon.setStatisticsFromGems(gemName);
        }
    }
    public void Remove(String weaponName,int index){
        Weapon weapon=this.weapons.get(weaponName);
        weapon.removeGem(index);
    }

    public String Print(String weaponName) {
        Weapon weapon=this.weapons.get(weaponName);
        return weapon.toString();
    }

    public String Compare(String weaponName1,String weaponName2) {
        Weapon weapon1=this.weapons.get(weaponName1);
        Weapon weapon2=this.weapons.get(weaponName2);
        double weapon1DMG=weapon1.getItemLevel();
        double weapon2DMG=weapon2.getItemLevel();
        if(Double.compare(weapon1DMG,weapon2DMG)==1){
              return weapon1.toString();
        }else if(Double.compare(weapon1DMG,weapon2DMG)==-1){
            return weapon2.toString();
        }else{
            return weapon1.toString();
        }
    }
}
