package by.topolev.dao;

import by.topolev.entity.Teacher;
import by.topolev.entity.TrainingCourse;
import org.junit.Test;

import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class TeacherDaoJPATest {

    private TeacherDao teacherDao = new TeacherDaoJPA();
    @Test
    public void getAll(){
        List<Teacher> teachers = teacherDao.findAll();

        for (Teacher teacher : teachers ){
            System.out.println(teacher);
        }
    }

    @Test
    public void saveTeacher(){
        Teacher teacher = new Teacher();
        teacher.setLastname("Topolev");
        teacher.setFirstname("Vl");

        TrainingCourse trainingCourse = new TrainingCourse();
        trainingCourse.setName("Test training course");
        trainingCourse.setTeacher(teacher);
        teacher.addTrainingCourse(trainingCourse);

        teacherDao.create(teacher);

        System.out.println("Save teacher course. Teacher id = " + teacher.getId());
        List<TrainingCourse> trainingCourses = teacher.getTrainingCourses();
        for (TrainingCourse trainingCourse1 : trainingCourses){
            System.out.println("       training course id = "  + trainingCourse1.getId());
        }

    }

}
