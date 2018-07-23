package app.retake.domain.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Entity
@Table(name = "passports")
public class Passport implements Serializable {

    @Id
    @Length(min = 10,max = 10)
    private String serialNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    private Animal animal;

    @NotNull
    private String ownerPhoneNumber;

    @Length(min = 3,max = 30)
    private String ownerName;

    private Date registrationDate;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        char[] words=serialNumber.toCharArray();
        List<Character> charNums=new LinkedList<>();
        Collections.addAll(charNums,'1','2','3','4','5',
                '6','7','8','9','0');
        if(charNums.contains(words[words.length-1])){
            if(charNums.contains(words[words.length-2])){
                if(charNums.contains(words[words.length-3])){
                     this.serialNumber=serialNumber;
                }else{
                    throw new IllegalArgumentException();
                }
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getOwnerPhoneNumber() {
        return ownerPhoneNumber;
    }

    public void setOwnerPhoneNumber(String ownerPhoneNumber) {
        if(ownerPhoneNumber.substring(0,4).equals("+359")){
             if(ownerPhoneNumber.length()==13){
                 this.ownerPhoneNumber=ownerPhoneNumber;
             }else{
                 throw new IllegalArgumentException();
             }
        }else if(ownerPhoneNumber.substring(0,1).equals("0")){
            if(ownerPhoneNumber.length()==10){
                this.ownerPhoneNumber=ownerPhoneNumber;
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
}
