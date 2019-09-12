package ru.maximumdance.passcontrol.dao;

import org.springframework.stereotype.Repository;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

@Repository
public class CourseDAOImpl {

    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<Course> getAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> rootEntry = cq.from(Course.class);
        CriteriaQuery<Course> all = cq.select(rootEntry);
        TypedQuery<Course> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }


    public List<Lesson> getLessons(Date date){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Lesson> criteriaQuery = criteriaBuilder.createQuery(Lesson.class);
        Root<Lesson> root = criteriaQuery.from(Lesson.class);

        ParameterExpression<Date> parameter = criteriaBuilder.parameter(Date.class);

        Path<Date> checkDatePath = root.get("date");

        Predicate predicate = criteriaBuilder.equal(checkDatePath, parameter);

    //    Predicate p = cb.isTrue(root.get("date"),date);

//cb.equal()

        CriteriaQuery<Lesson> all =  criteriaQuery.where(criteriaBuilder.and(predicate));


       // CriteriaQuery<Lesson> all = criteriaQuery.select(root);
        TypedQuery<Lesson> allQuery = entityManager.createQuery(all);
        return allQuery.setParameter(parameter, date).getResultList();
    }

}
