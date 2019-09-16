package ru.maximumdance.passcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maximumdance.passcontrol.dao.PersonDAOImpl;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAOImpl personDAO;


    @Override
    public Person insert(Person person) {
        return personDAO.insert(person);
    }

    @Override
    public Person update(Person person) {
        return personDAO.update(person);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }


    @Override
    public Person findById(Integer id) {
        return personDAO.findById(id);
    }

    @Override
    public Person addPass(Integer id, Pass pass) {
        return personDAO.addPass(id,pass);
    }


    @Override
    public Person  addLesson(Integer id, Lesson lesson) {
        return personDAO.addLesson(id,lesson);
    }

    @Override
    public Person removeLesson(Long id) {
        return personDAO.removeLesson(id);
    }

    @Override
    public Person find(Map<String, String> params) {
        return personDAO.find(params);
    }

    @Override
    public List<Person>findByNameLike(String firstName) {
        return personDAO.findByNameLike(firstName);
    }

    @Override
    public Long insertCource(Course course) {
        return personDAO.insertCource(course);
    }

    @Override
    public List<Pass> findActivePass(){
        return personDAO.findActivePass();
    }
}
