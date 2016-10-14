package by.topolev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
@Entity
@Table(name = "techer")
@NamedQuery(name = "Teacher.getAll", query = "SELECT e from Teacher e")
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name", unique = true)
    private String lastname;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private List<TrainingCourse> trainingCourses = new ArrayList<TrainingCourse>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<TrainingCourse> getTrainingCourses() {
        return trainingCourses;
    }

    public void setTrainingCourses(List<TrainingCourse> trainingCourses) {
        this.trainingCourses = trainingCourses;
    }

    public void addTrainingCourse(TrainingCourse trainingCourse){
        trainingCourse.setTeacher(this);
        this.trainingCourses.add(trainingCourse);
    }

    public String toString(){
        return String.format("id = %d; firstname: %s; lastname: %s", id, firstname, lastname);
    }
}
