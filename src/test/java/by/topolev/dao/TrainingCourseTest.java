package by.topolev.dao;

import by.topolev.entity.Student;
import by.topolev.entity.Teacher;
import by.topolev.entity.TrainingCourse;
import org.junit.Test;

import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class TrainingCourseTest {
    private TrainingCourseDao trainingCourseDao = new TrainingCourseDaoJPA();

    @Test
    public void getAll(){
        List<TrainingCourse> trainingCourses = trainingCourseDao.findAll();
        for (TrainingCourse trainingCourse : trainingCourses ){
            System.out.println(trainingCourse);
            System.out.println("        " + trainingCourse.getTeacher());
        }
    }

    @Test
    public void getAllWithDetails(){
        List<TrainingCourse> trainingCourses = trainingCourseDao.findAll();
        for (TrainingCourse trainingCourse : trainingCourses ){
            System.out.println(trainingCourse);

            System.out.println("Teacher: ");
            System.out.println("        " + trainingCourse.getTeacher());

            System.out.println("Students: ");
            List<Student> students = trainingCourse.getStudents();
            for (Student student : students){
                System.out.println("        " + student);
            }
        }
    }

    @Test
    public void saveTrainingCourse(){
        Teacher teacher = new Teacher();
        teacher.setFirstname("Test teacher");
        teacher.setLastname("Test teacher");

        TrainingCourse trainingCourse = new TrainingCourse();
        trainingCourse.setName("Test training course");
        trainingCourse.setTeacher(teacher);
        trainingCourseDao.create(trainingCourse);
        System.out.println("Save training course. Training course id = " + trainingCourse.getId());
        System.out.println("Id teacher = " + teacher.getId());
    }
}
