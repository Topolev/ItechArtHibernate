package by.topolev.dao;

import by.topolev.entity.Exam;
import by.topolev.entity.Student;
import org.junit.Test;

import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class ExamDaoJPATest {
    ExamDao examDao = new ExamDaoJPA();

    @Test
    public void findExamList(){
        examDao.findAll();
        List<Exam> exams = examDao.findAll();
        for (Exam exam : exams ){
            System.out.println(exam);
        }
    }
}
