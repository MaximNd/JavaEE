package data.entities;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Макс on 25.02.2018.
 */
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @GeneratedValue
//    @Column(name = "id",nullable = false)
    private int teacherId;

    public  Teacher(Date birthDate, String cellphone, String firstname, String lastname, int teacherId) {
        this.birthDate = birthDate;
        this.cellphone = cellphone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.teacherId = teacherId;
    }

    @Column(name="firstname")
    private String firstname;

    @Column(name="lastname")
    private String lastname;

    @Column(name="birth_date")
    private Date birthDate;

    @Column(name="cell_phone")
    private String cellphone;

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "ID: " + this.getTeacherId() + ", PIB: " + this.getLastname() + " " + this.getFirstname() + ", birthdate: " + this.getBirthDate();
    }
}

