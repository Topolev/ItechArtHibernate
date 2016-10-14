package by.topolev.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Vladimir on 13.10.2016.
 */
@Embeddable
public class StudentResultPK implements Serializable {
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "training_course_id", nullable = false)
    private Long trainingCourseId;
}
