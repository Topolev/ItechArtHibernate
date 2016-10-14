package by.topolev.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Vladimir on 13.10.2016.
 */

@Entity

@Table(name = "student_result")
public class StudentResult implements Serializable{
    @Id
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Id
    @Column (name = "training_course_id", nullable = false)
    private Long trainingCourseId;


    @OneToOne
    @JoinColumn( name = "exam_id")
    private Exam exam;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "note", length = 50)
    private String note;

    @Column (name = "result", nullable = false)
    private Integer result;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public String toString(){
        return String.format("sId: %d; tId: %d; date: %s, note: %s ", studentId, trainingCourseId, date, note);
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTrainingCourseId() {
        return trainingCourseId;
    }

    public void setTrainingCourseId(Long trainingCourseId) {
        this.trainingCourseId = trainingCourseId;
    }


    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
