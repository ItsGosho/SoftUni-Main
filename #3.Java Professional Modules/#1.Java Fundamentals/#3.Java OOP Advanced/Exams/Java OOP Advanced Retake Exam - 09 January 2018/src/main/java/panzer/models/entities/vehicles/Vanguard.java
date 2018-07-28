package panzer.models.entities.vehicles;

import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Vanguard extends VehicleImpl{

    public Vanguard(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight*2, price, (int) (attack*0.75), (int) (defense*1.50), (int) (hitPoints*1.75));
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Vanguard - %s%n",super.getModel()));
        str.append(super.toString());
        if(super.getParts().iterator().hasNext()){
            List<String> toReturn=new LinkedList<>();
            for (Part part : super.getParts()) {
                toReturn.add(part.getModel());
            }
            str.append(String.format("Parts: %s",String.join(", ",toReturn)));
        }else{
            str.append(String.format("Parts: None"));
        }
        return str.toString();
    }
}
