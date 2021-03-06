package ru.maximumdance.passcontrol.service;




import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {

    Person insert(Person person);

    Person update(Person person);

    List<Person> getAll();

    Person findById(Integer id);

    Person addPass(Integer id, Pass pass);

    Person addLesson(Integer id, Lesson lesson);

    Person removeLesson(Long id);

    Person find(Map<String,String> params);

    List<Person>findByNameLike(String firstName);

    Long insertCource(Course course);

    List<Pass> findActivePass();

    Person updatePass(Integer id, Pass pass);

    Person removePass(Integer idPerson, Integer idPass);
}
