package by.topolev.dao;

import by.topolev.entity.TrainingCourse;

/**
 * Created by Vladimir on 13.10.2016.
 */
public class TrainingCourseDaoJPA extends GenericDaoImpl<TrainingCourse> implements TrainingCourseDao {
    TrainingCourseDaoJPA(){
        this(TrainingCourse.class);
    }
    TrainingCourseDaoJPA(Class<TrainingCourse> type) {
        super(type);
    }
}
