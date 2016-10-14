package by.topolev.dao;

import by.topolev.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class StudentDaoJPA extends GenericDaoImpl<Student> implements StudentDao {


    StudentDaoJPA(){
        this(Student.class);
    }
    StudentDaoJPA(Class<Student> type) {
        super(type);
    }

    public  static void main(String[] srgs){
        StudentDao studentDao = new StudentDaoJPA();
        List<Student> students = studentDao.findAll();
        for (Student student : students ){
            System.out.println(student);
        }
    }

}
