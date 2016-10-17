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



}
