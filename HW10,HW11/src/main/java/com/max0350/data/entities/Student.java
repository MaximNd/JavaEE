package com.max0350.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.max0350.data.entities.embeddables.FullName;
import org.hibernate.annotations.IndexColumn;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Entity
@Table(name="students")
@NamedQueries({
    @NamedQuery(name = Student.GET_ALL_STUDENTS, query = "SELECT s FROM Student s"),
    @NamedQuery(name = Student.GET_STUDENTS_BY_COUNT_LECTURES, query = "SELECT s FROM Student s WHERE s.lectures.size = :countLectures")
})
public class Student {
    public static final String GET_ALL_STUDENTS = "Student.getAllStudents";
    public static final String GET_STUDENTS_BY_COUNT_LECTURES = "Student.getStudentsByCountLectures";
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Embedded
    private FullName fullName;
    private String course;
    @OneToOne
    @JoinColumn(name = "student_data_FK")
    private StudentData studentData;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "student_id")
    private List<Gradebook> gradebooks;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "student_lecture", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "lecture_id"))
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

    public StudentData getStudentData() {
        return studentData;
    }

    public void setStudentData(StudentData studentData) {
        this.studentData = studentData;
    }

    public List<Gradebook> getGradebooks() {
        return gradebooks;
    }

    public void setGradebooks(List<Gradebook> gradebooks) {
        this.gradebooks = gradebooks;
    }

    public List<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(List<Lecture> lectures) {
        this.lectures = lectures;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fullName=" + fullName +
                ", course='" + course + '\'' +
                ", studentData=" + studentData +
                ", gradebooks=" + gradebooks +
                ", lectures=" + lectures +
                '}';
    }
}
