package T10_T11_T12_T14_InfernoInfinity.Weapons;

import T10_T11_T12_T14_InfernoInfinity.Weapon;

public class Sword extends Weapon {

    public Sword(String name, String weaponType) {
        super(name, weaponType);
        super.setMinDamage(4);
        super.setMaxDamage(6);
        super.setNumberOfSockets(3);
    }
}
