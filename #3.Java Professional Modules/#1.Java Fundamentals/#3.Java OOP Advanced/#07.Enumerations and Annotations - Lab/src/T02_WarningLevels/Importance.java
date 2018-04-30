package T02_WarningLevels;

public enum Importance {
    LOW(1),NORMAL(2),MEDIUM(3),HIGH(4);
    private int alertHowHigh;
    Importance(int alertHowHigh){
        this.alertHowHigh=alertHowHigh;
    }
    public int getAlertHowHigh(){
        return this.alertHowHigh;
    }

}
