package ru.maximumdance.passcontrol.dao;

import org.springframework.stereotype.Repository;
import ru.maximumdance.passcontrol.model.*;
import ru.maximumdance.passcontrol.util.DateUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PersonDAOImpl {

    protected EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person insert(Person person){
        entityManager.persist(person);
        entityManager.flush();
        return person;
    }

    public Person update(Person person){
        entityManager.merge(person);
        entityManager.flush();
        return person;
    }

    public void delete(Person person){
        entityManager.remove(person);
    }


    public List<Person> getAll(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        Root<Person> rootEntry = cq.from(Person.class);
        CriteriaQuery<Person> all = cq.select(rootEntry);
        TypedQuery<Person> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    public Person findById(Integer id){

  //      return findByIdLike(id);


        return entityManager.find(Person.class, id);
    };

    public Pass findPassById(Integer id){
        return entityManager.find(Pass.class, id);
    };

    public Course findCourceById(Integer id){
        return entityManager.find(Course.class, id);
    };

    public Long insertCource(Course course){
        entityManager.persist(course);
        entityManager.flush();
        return course.getId();
    };



    public Person addPass(Integer id, Pass pass){
        Person person = findById(id);

        Course course = entityManager.find(Course.class, pass.getCourse().getId());
        pass.setCourse(course);

        // person.getPasses().size();
       // person.addPass(pass);
        person.addPass(pass);


        entityManager.persist(pass);
     //   entityManager.merge(person);
        entityManager.flush();
        person = findById(id);
        return person;
    }

    public Person find(Map<String,String> params) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        Root<Person> from = criteria.from(Person.class);
        criteria.select(from);
        params.forEach((key, value) -> criteria.where(builder.equal(from.get(key), value)));

        TypedQuery<Person> typed = entityManager.createQuery(criteria);
        try {
            return typed.getSingleResult();
        } catch (final NoResultException nre) {
            return null;
        }
    }

    public List<Person> findByNameLike(String name) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        Root<Person> from = criteria.from(Person.class);
        criteria.select(from);

        criteria.where(builder.like(from.get("lastName"), builder.parameter(String.class, "likeCondition")));

        TypedQuery<Person> typed = entityManager.createQuery(criteria);
        typed.setParameter("likeCondition", name+"%");
        return typed.getResultList();
    }


    public Person findByIdLike(Integer id) {

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        Root<Person> from = criteria.from(Person.class);
        criteria.select(from);

        criteria.where(builder.equal(from.get("id"), builder.parameter(Integer.class, "likeCondition")));

        TypedQuery<Person> typed = entityManager.createQuery(criteria);
        typed.setParameter("likeCondition", id);
        return typed.getSingleResult();
    }

    public Person addLesson(Integer id, Lesson lesson) {


        Pass pass = findPassById(id);

    //    Course course = entityManager.find(Course.class, pass.getCourse().getId());
    //    pass.setCourse(course);
        CourseLevel  level = entityManager.find(CourseLevel.class,lesson.getCourselevel().getId());
        lesson.setCourselevel(level);
        pass.addLesson(lesson);

        entityManager.persist(lesson);

      //
     //   entityManager.merge(pass);
        entityManager.flush();
        return pass.getPerson();
    }

    public Person removeLesson(Long id) {


        Lesson lesson = entityManager.find(Lesson.class, id);

        Pass pass = findPassById(lesson.getPass().getId());

        pass.getLessons().remove(lesson);

        entityManager.remove(lesson);
        entityManager.persist(pass);

        //
        //   entityManager.merge(pass);
        entityManager.flush();
        return pass.getPerson();
    }


    public List<Pass> findActivePass() {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pass> criteriaQuery = criteriaBuilder.createQuery(Pass.class);
        Root<Pass> root = criteriaQuery.from(Pass.class);

        ParameterExpression<Date> parameterTerminate = criteriaBuilder.parameter(Date.class);
        ParameterExpression<Integer> parameterItem = criteriaBuilder.parameter(Integer.class);



        Path<Date> terminateDatePath = root.get("terminateDate");

        Path<Integer> currentItemCountPath = root.get("currentItemCount");

        Predicate terminatePredicate = criteriaBuilder.lessThanOrEqualTo(parameterTerminate, terminateDatePath);

        Predicate currentItemPredicate = criteriaBuilder.lessThanOrEqualTo(parameterItem, currentItemCountPath);

        //    Predicate p = cb.isTrue(root.get("date"),date);

//cb.equal()

        CriteriaQuery<Pass> all =  criteriaQuery.where(criteriaBuilder.and(terminatePredicate, currentItemPredicate));




     //    CriteriaQuery<Pass> all = criteriaQuery.select(root);
        TypedQuery<Pass> allQuery = entityManager.createQuery(all);
        return allQuery
                .setParameter(parameterTerminate, DateUtil.withoutTime(new Date()))
                .setParameter(parameterItem, 0)
                .getResultList();
    }




}
