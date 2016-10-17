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



}
