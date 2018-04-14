package com.max0350.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
@Entity
@Table(name="lectures")
public class Lecture {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    private String name;
    private double credits;
    @OneToMany
    @JoinColumn(name = "lecture_id")
    private List<Test> tests;
    @ManyToMany(mappedBy = "lectures")
    private List<Student> students;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;

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

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Lecture: { ID: " + this.getId() + ", name: " + this.getName() + ", credits: " + this.getCredits() + " }";
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
