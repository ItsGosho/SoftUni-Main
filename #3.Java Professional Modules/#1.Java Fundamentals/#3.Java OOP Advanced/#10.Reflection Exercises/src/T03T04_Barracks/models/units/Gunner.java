package T03T04_Barracks.models.units;

public class Gunner extends  AbstractUnit {
    private static final int GUNNER_HEALTH = 50;
    private static final int GUNNER_DAMAGE = 10;
    protected Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }
}
