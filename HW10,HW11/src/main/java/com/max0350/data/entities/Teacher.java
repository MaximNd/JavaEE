package com.max0350.data.entities;

import com.max0350.data.entities.embeddables.FullName;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Embedded
    private FullName fullName;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Column(name = "cell_phone")
    private String cellPhone;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private List<Lecture> lectures;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", birthDate=" + birthDate +
                ", cellPhone='" + cellPhone + '\'' +
                ", lectures=" + lectures +
                '}';
    }
}
