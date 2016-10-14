package by.topolev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
@Entity
@Table(name = "training_course")
@NamedQuery(name = "TrainingCourse.getAll", query = "SELECT e from TrainingCourse e")
public class TrainingCourse {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "student_result",
               joinColumns = @JoinColumn(name = "training_course_id"),
               inverseJoinColumns = @JoinColumn( name = "student_id"))
    private List<Student> students = new ArrayList<Student>();

    @Override
    public String toString(){
        return String.format("Training course: id=%s; name=%s", id, name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }
}
