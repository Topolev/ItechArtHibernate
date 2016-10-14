package by.topolev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vladimir on 13.10.2016.
 */

@Entity
@Table(name = "exam")
@NamedQuery(name = "Exam.getAll", query = "SELECT e from Exam e")
public class Exam implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @OneToOne
    @JoinColumn( name = "training_course_id")
    private TrainingCourse trainingCourse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public TrainingCourse getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(TrainingCourse trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @Override
    public String toString(){
        return String.format("Exam: id = %d; date: %s", id, date);
    }
}
