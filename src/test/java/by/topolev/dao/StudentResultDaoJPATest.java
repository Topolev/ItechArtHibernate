package by.topolev.dao;

import by.topolev.entity.StudentResult;
import by.topolev.entity.Teacher;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class StudentResultDaoJPATest {

    private StudentResultDao studentResultDao = new StudentResultDaoJPA();

    @Test
    public void getAll(){
        List<StudentResult> studentResults = studentResultDao.findAll();

        for (StudentResult studentResult : studentResults ){
            System.out.println(studentResult);
        }
    }

    @Test
    public void insertNewRow(){
        StudentResult studentResult = new StudentResult();
        studentResult.setDate(new Date());
        /*studentResult.setStudentId(Long.valueOf(14));
        studentResult.setTrainingCourseId(Long.valueOf(5));*/
        studentResult.setNote("Test");
        studentResult.setResult(Integer.valueOf(5));

        studentResultDao.create(studentResult);
    }

}
