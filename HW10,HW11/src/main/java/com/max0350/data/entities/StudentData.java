package com.max0350.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.max0350.data.entities.embeddables.Address;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Макс on 04.03.2018.
 */
@Entity
@Table(name="students_data")
public class StudentData {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Embedded
    private Address address;
    @OneToOne(mappedBy = "studentData")
    @JsonIgnore
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "StudentData{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", address=" + address +
                ", student=" + student +
                '}';
    }
}
