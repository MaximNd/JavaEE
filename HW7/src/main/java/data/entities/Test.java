package data.entities;

import data.entities.enums.TestType;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Макс on 04.03.2018.
 */
@Entity
@NamedQueries({
    @NamedQuery(name = Test.GET_ALL_TESTS, query = "SELECT t FROM Test t"),
    @NamedQuery(name = Test.COUNT_OF_SELECTED_TYPE_TEST, query = "SELECT COUNT (t) FROM Test t WHERE t.testType = :testType")
})
@Table(name="tests")
public class Test {
    public static final String GET_ALL_TESTS = "Test.getAllTests";
    public static final String COUNT_OF_SELECTED_TYPE_TEST = "Test.countOfSelectedTypeTest";
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Enumerated(EnumType.STRING)
    private TestType testType;
    private String testName;
    private String text;
    @OneToMany(mappedBy = "test")
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
                '}';
    }
}
