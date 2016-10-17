package by.topolev.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladimir on 13.10.2016.
 */

@Entity
@Table(name = "student")
@NamedQuery(name = "Student.getAll", query = "SELECT s from Student s")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column( name = "first_name", length = 20)
    private String firstname;

    @Column( name = "last_name", length = 20)
    private String lastname;


    @Column( name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "sex")
    @Type( type = "java.lang.Boolean")
    private boolean sex;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable( name = "student_result",
                joinColumns = @JoinColumn (name = "student_id"),
                inverseJoinColumns = @JoinColumn( name = "training_course_id"))
    private List<TrainingCourse> trainingCourses = new ArrayList<TrainingCourse>();

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StudentResult> studentResults = new ArrayList<StudentResult>();


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ExamResult> examResults = new ArrayList<ExamResult>();

    public Student() {
    }


    public String toString(){
        return String.format("id: %d; firstName: %s; lastName: %s; date: %s, sex: %s", id, firstname, lastname, birthday, sex);
    }


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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isSex() {
        return sex;
    }



    public void setSex(boolean sex) {
        this.sex = sex;
    }


    public List<StudentResult> getStudentResults() {
        return studentResults;
    }

    public void setStudentResults(List<StudentResult> studentResults) {
        this.studentResults = studentResults;
    }

    public List<ExamResult> getExamResults() {
        return examResults;
    }

    public void setExamResults(List<ExamResult> examResults) {
        this.examResults = examResults;
    }

    public List<TrainingCourse> getTrainingCourses() {
        return trainingCourses;
    }

    public void setTrainingCourses(List<TrainingCourse> trainingCourses) {
        this.trainingCourses = trainingCourses;
    }

   /* public void addStudentResult(StudentResult studentResult){
        studentResult.setStudent(this);
        this.studentResults.add(studentResult);
    }*/

    public void addExamResult(ExamResult examResult){

    }


    public void addTrainingCourse(TrainingCourse trainingCourse){
        //trainingCourse.addStudent(this);
        this.trainingCourses.add(trainingCourse);
    }


}
