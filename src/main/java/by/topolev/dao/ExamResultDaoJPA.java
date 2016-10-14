package by.topolev.dao;

import by.topolev.entity.ExamResult;

/**
 * Created by Vladimir on 14.10.2016.
 */
public class ExamResultDaoJPA extends GenericDaoImpl<ExamResult> implements ExamResultDao {
    ExamResultDaoJPA(){
        this(ExamResult.class);
    }
    ExamResultDaoJPA(Class<ExamResult> type) {
        super(type);
    }
}
