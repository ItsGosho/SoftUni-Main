package T02_WarningLevels;

import java.util.ArrayList;
import java.util.List;

public class Message{
    private List<Logger> message;
    private int initialLatency;
    public Message(int initialLatency){
        this.message=new ArrayList<>();
        this.initialLatency=initialLatency;
    }
    public void addMessage(String message){
        this.message.add(new Logger(this.initialLatency,message));
    }
    public Iterable<Logger> getMessages(){
        return this.message;
    }
}
