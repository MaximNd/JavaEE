package data.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Макс on 26.02.2018.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Lecture.GET_ALL_LECTURES, query = "SELECT l FROM Lecture l"),
    @NamedQuery(name = Lecture.GET_ALL_LECTURES_BY_CREDITS, query = "SELECT l FROM Lecture l WHERE l.credits = :credits"),
    @NamedQuery(name = Lecture.GET_ALL_LECTURES_SORTED_BY_CREDITS_ASC, query = "SELECT l FROM Lecture l ORDER BY l.credits ASC"),
    @NamedQuery(name = Lecture.GET_ALL_LECTURES_SORTED_BY_CREDITS_DESC, query = "SELECT l FROM Lecture l ORDER BY l.credits DESC")
})
@Table(name="lectures")
public class Lecture {
    public static final String GET_ALL_LECTURES = "Lecture.getAllLectures";
    public static final String GET_ALL_LECTURES_BY_CREDITS = "Lecture.getAllLecturesByCredits";
    public static final String GET_ALL_LECTURES_SORTED_BY_CREDITS_ASC = "Lecture.getAllLecturesSortesByCreditsAsc";
    public static final String GET_ALL_LECTURES_SORTED_BY_CREDITS_DESC = "Lecture.getAllLecturesSortesByCreditsDesc";
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
    @ManyToOne
    @JoinColumn(name = "teacher_id")
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
