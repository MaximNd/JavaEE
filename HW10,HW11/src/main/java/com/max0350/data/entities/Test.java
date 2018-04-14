package com.max0350.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.max0350.data.entities.enums.TestType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Entity
@Table(name="tests")
public class Test {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    private TestType testType;
    private String testName;
    private String text;
    @OneToMany(mappedBy = "test", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Gradebook> gradebooks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TestType getTestType() {
        return testType;
    }

    public void setTestType(TestType testType) {
        this.testType = testType;
    }

    public List<Gradebook> getGradebooks() {
        return gradebooks;
    }

    public void setGradebooks(List<Gradebook> gradebooks) {
        this.gradebooks = gradebooks;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testType=" + testType +
                ", testName='" + testName + '\'' +
                ", text='" + text + '\'' +
                ", gradebooks=" + gradebooks +
                '}';
    }
}
