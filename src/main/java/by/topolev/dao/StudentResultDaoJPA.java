package by.topolev.dao;

import by.topolev.entity.StudentResult;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class StudentResultDaoJPA extends GenericDaoImpl<StudentResult> implements StudentResultDao {
    StudentResultDaoJPA(){
        this(StudentResult.class);
    }
    StudentResultDaoJPA(Class<StudentResult> type) {
        super(type);
    }
}
