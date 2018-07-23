package app.retake.domain.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "vets")
public class Vet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Length(min = 3,max = 40)
    private String name;

    @Length(min = 3,max = 50)
    private String profession;

    @Min(value = 22)
    @Max(value = 65)
    private int age;

    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.substring(0,4).equals("+359")){
            if(phoneNumber.length()==13){
                this.phoneNumber=phoneNumber;
            }else{
                throw new IllegalArgumentException();
            }
        }else if(phoneNumber.substring(0,1).equals("0")){
            if(phoneNumber.length()==10){
                this.phoneNumber=phoneNumber;
            }else{
                throw new IllegalArgumentException();
            }
        }else{
            throw new IllegalArgumentException();
        }
    }
}
