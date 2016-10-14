package by.topolev.dao;

import by.topolev.entity.Teacher;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class TeacherDaoJPA extends GenericDaoImpl<Teacher> implements TeacherDao {
    TeacherDaoJPA(){
        this(Teacher.class);
    }
    TeacherDaoJPA(Class<Teacher> type) {
        super(type);
    }
}
