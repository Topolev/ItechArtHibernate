package by.topolev.dao;

import by.topolev.entity.Student;
import by.topolev.entity.StudentResult;
import by.topolev.entity.TrainingCourse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.PluralAttribute;
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

    public List<Student> findStudentsWithDetails() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(type);
        Root<Student> root = cq.from(Student.class);
        root.fetch("studentResults");
        CriteriaQuery<Student> select = cq.select(root);
        TypedQuery<Student> q = em.createQuery(cq);
        List<Student> allitems = q.getResultList();

        return allitems;
    }
}
