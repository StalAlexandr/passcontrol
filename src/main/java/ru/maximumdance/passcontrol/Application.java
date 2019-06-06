package ru.maximumdance.passcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.maximumdance.passcontrol.config.Config;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.PersonService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Config.class, args);


        PersonService service =context.getBean(PersonService.class);


        Person person = new Person();
        person.setLastName("Сталь");
        person.setCardNumber(123);
        person.setFirstName("Александр");
        service.insert(person);



        Integer id = service.findByNameLike("Сталь").get(0).getId();

        Pass pass = new Pass();
        Course course = new Course();
        course.setName("Латина");

        Long courceId = service.insertCource(course);
        course.setId(courceId);

        pass.setItemCount(8);
        pass.setCourse(course);

        person.addPass(pass);


        Integer passId = service.addPass(id, pass);

    }
}
