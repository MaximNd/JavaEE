package com.max0350.data.entities.embeddables;

import javax.persistence.Embeddable;

/**
 * Created by Макс on 04.03.2018.
 */
@Embeddable
public class Address {
    private String sity;
    private String country;
    private String street;

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "sity='" + sity + '\'' +
                ", country='" + country + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
