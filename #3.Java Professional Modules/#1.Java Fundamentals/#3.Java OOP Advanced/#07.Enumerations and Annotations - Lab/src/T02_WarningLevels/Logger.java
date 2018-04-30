package T02_WarningLevels;

public class Logger {

    private String message;

    public Logger(int msgLatency,String message){
        this.setMessage(msgLatency,message);
    }

    public void setMessage(int msgLatency,String message) {
        String[] splitted=message.split(":");
        String alert=splitted[0];
        if(Importance.valueOf(alert).getAlertHowHigh()>=msgLatency){
            this.message = message;
        }else{
            throw new IllegalArgumentException("message dont get the minimum requipments");
        }
    }
    public String getMessage(){
        return this.message;
    }
    @Override
    public String toString(){
        return this.message;
    }
}
