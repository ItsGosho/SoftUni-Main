package app.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class PhoneNumberDto implements Serializable {

    @Expose
    private String number;

    @Expose
    private PersonDto person;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
