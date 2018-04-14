package com.max0350.data.entities.embeddables;

import javax.persistence.Embeddable;

/**
 * Created by Макс on 04.03.2018.
 */
@Embeddable
public class FullName {
    private String firstname;
    private String lastname;
    private String midname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMidname() {
        return midname;
    }

    public void setMidname(String midname) {
        this.midname = midname;
    }

    @Override
    public String toString() {
        return "FullName{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", midname='" + midname + '\'' +
                '}';
    }
}
