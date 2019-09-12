package ru.maximumdance.passcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.maximumdance.passcontrol.config.Config;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.CourseService;
import ru.maximumdance.passcontrol.service.PersonService;
import ru.maximumdance.passcontrol.util.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws Exception {
        ApplicationContext context = SpringApplication.run(Config.class, args);

/*
        PersonService service =context.getBean(PersonService.class);

        CourseService courseService =context.getBean(CourseService.class);


        Person person = new Person();
        person.setLastName("Сталь");
        person.setCardNumber(123);
        person.setFirstName("Александр");
        person = service.insert(person);



        Integer id = service.findByNameLike("Сталь").get(0).getId();

        Course course = courseService.getAll().get(0);
        Pass pass = new Pass();
        pass.setCourse(course);
        pass.setPerson(person);
        pass.setItemCount(8);
        pass.setTerminateDate(new SimpleDateFormat("dd/MM/yyyy").parse("20/10/2010"));

        person = service.addPass(person.getId(), pass);

        pass = person.getPasses().get(0);


        Lesson lesson = new Lesson();
        lesson.setCourselevel(course.getCourseLevels().get(0));
        lesson.setDate(DateUtil.withoutTime(new Date()));
        service.addLesson(pass.getId(), lesson);

        List<Lesson> lessons= courseService.getLessons(new Date());

        lessons.forEach(x->System.out.println(x.getPass().getPerson().getFirstName()));

        System.out.println(service.findActivePass().size());



        Pass pass = new Pass();
        Course course = new Course();
        course.setName("Латина");

        Long courceId = service.insertCource(course);
        course.setId(courceId);

        pass.setItemCount(8);
        pass.setCourse(course);
*/



    }
}
