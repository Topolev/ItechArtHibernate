package by.topolev.dao;

import by.topolev.entity.Student;

import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public interface StudentDao extends GenericDao<Student>{
    List<Student> findAll();
    List<Student> findStudentsWithDetails();
}
