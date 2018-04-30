package T10_T11_T12_T14_InfernoInfinity.Weapons;

import T10_T11_T12_T14_InfernoInfinity.Weapon;

public class Axe extends Weapon {

    public Axe(String name, String weaponType) {
        super(name, weaponType);
        super.setMinDamage(5);
        super.setMaxDamage(10);
        super.setNumberOfSockets(4);
    }
}
