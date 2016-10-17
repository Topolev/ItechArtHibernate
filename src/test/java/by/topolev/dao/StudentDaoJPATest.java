package by.topolev.dao;

import by.topolev.entity.*;
import org.junit.Test;

import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class StudentDaoJPATest  {

    StudentDao studentDao = new StudentDaoJPA();

    @Test
    public void getAllStudentsLazyLoad(){
        List<Student> students = studentDao.findAll();
        for (Student student : students ){
            System.out.println(student);
        }
    }

    @Test
    public void getAllStudentsEagger(){
        List<Student> students = studentDao.findAll();
        for (Student student : students ){
            System.out.println(student);

            List<TrainingCourse> trainingCourses = student.getTrainingCourses();
            System.out.println("TrainingCourses: ");
            for (TrainingCourse trainingCourse : trainingCourses){
                System.out.println("       " + trainingCourse);
            }


            List<ExamResult> examResults = student.getExamResults();
            System.out.println("Exam result: ");
            for(ExamResult examResult : examResults){
                System.out.println("       " + examResult);
            }



            System.out.println("Student result: ");
            List<StudentResult> studentResults = student.getStudentResults();
            for(StudentResult studentResult : studentResults){
                System.out.println("       " + studentResult);
            }


            System.out.println("-----------------------------");

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
        teacher.setFirstname("teacher" + String.valueOf(Math.random()).substring(1,10));
        teacher.setLastname("teacher" + String.valueOf(Math.random()).substring(1,10));

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
        student.setBirthday(new Date());
        student.setFirstname("Topolev");
        student.setLastname("Vladimir");

        studentDao.create(student);

        System.out.println("We are deleting student with id = " + student.getId());
        System.out.println(String.format("Amount students before deleting student: %d", studentDao.findAll().size()));
        studentDao.delete(student);
        System.out.println(String.format("Count students after deleting student: %d", studentDao.findAll().size()));

    }




}
