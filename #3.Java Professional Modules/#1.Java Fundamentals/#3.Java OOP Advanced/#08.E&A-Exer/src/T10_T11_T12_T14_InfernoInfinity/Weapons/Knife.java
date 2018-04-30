package T10_T11_T12_T14_InfernoInfinity.Weapons;

import T10_T11_T12_T14_InfernoInfinity.Weapon;

public class Knife extends Weapon {


    public Knife(String name, String weaponType) {
        super(name, weaponType);
        super.setMinDamage(3);
        super.setMaxDamage(4);
        super.setNumberOfSockets(2);
    }
}
