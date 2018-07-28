package panzer.models.entities.vehicles;

import panzer.contracts.Part;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

public class Revenger extends VehicleImpl {

    public Revenger(String model, double weight, BigDecimal price, int attack, int defense, int hitPoints) {
        super(model, weight, price.multiply(BigDecimal.valueOf(1.50)), (int) (attack*2.50), (int) (defense*0.50), (int) (hitPoints*0.50));
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(String.format("Revenger - %s%n",super.getModel()));
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
