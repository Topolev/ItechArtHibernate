package by.topolev.dao;

import by.topolev.entity.*;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class StudentDaoJPATest  {

    StudentDao studentDao = new StudentDaoJPA();
    TeacherDao teacherDao = new TeacherDaoJPA();
    TrainingCourseDao trainingCourseDao = new TrainingCourseDaoJPA();
    ExamDao examDao = new ExamDaoJPA();
    ExamResultDao examResultDao = new ExamResultDaoJPA();

    @Test
    public void getAllStudents(){
        List<Student> students = studentDao.findAll();
        for (Student student : students ){
            System.out.println(student);
        }
    }

    @Test
    public void getAllStudentsEgger(){
        List<Student> students = studentDao.findAll();
        for (Student student : students ){
            System.out.println(student);

            /*List<StudentResult> results = student.getStudentResults();
            System.out.println("StudentResult: ");
            for (StudentResult result : results){
                System.out.println("       " + result);
            }*/

            List<TrainingCourse> trainingCourses = student.getTrainingCourses();
            System.out.println("TrainingCourses: ");
            for (TrainingCourse trainingCourse : trainingCourses){
                System.out.println("       " + trainingCourse);
            }
        }
    }

    @Test
    public void createNewStudent(){
        Student student = new Student();
        student.setFirstname("Topolev");
        student.setLastname("Vladimir");
        student.setBirthday(new Date());
        student.setSex(true);

        Teacher teacher = new Teacher();
        teacher.setFirstname("Test teacher gttr");
        teacher.setLastname("Test teacher trhrth");

        TrainingCourse trainingCourse = new TrainingCourse();
        trainingCourse.setName("Test training course");
        trainingCourse.setTeacher(teacher);
        student.addTrainingCourse(trainingCourse);

        studentDao.create(student);

        System.out.println(String.format("After insert new student has id = %d", student.getId()));


    }

    @Test
    public void deleteStudent(){
        Student student = new Student();
        student.setId(Long.valueOf(19));

        System.out.println(String.format("Count students before deleting student: %d", studentDao.findAll().size()));
        studentDao.delete(student);
        System.out.println(String.format("Count students after deleting student: %d", studentDao.findAll().size()));

    }




}
