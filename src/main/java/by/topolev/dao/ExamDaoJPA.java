package by.topolev.dao;

import by.topolev.entity.Exam;

import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class ExamDaoJPA extends GenericDaoImpl<Exam> implements ExamDao {

    ExamDaoJPA(){
        this(Exam.class);
    }
    ExamDaoJPA(Class<Exam> type) {
        super(type);
    }

    public static void main(String[] arg){

        ExamDao examDao = new ExamDaoJPA();

        examDao.findAll();
        List<Exam> exams = examDao.findAll();
        for (Exam exam : exams ){
            System.out.println(exam);
        }
    }
}
