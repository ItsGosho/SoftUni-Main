package T09_TrafficLights;

public enum Light {
    RED(0), GREEN(1), YELLOW(2);
    int ordinal;
    Light(int ordinal){
        this.ordinal=ordinal;
    }
    public int getOrdinal(){
        return this.ordinal;
    }
}
