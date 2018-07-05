package app.dto;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class AddressDto implements Serializable {

    @Expose
    private String country;
    @Expose
    private String city;
    @Expose
    private String street;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
