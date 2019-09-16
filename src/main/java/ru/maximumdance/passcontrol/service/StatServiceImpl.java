package ru.maximumdance.passcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.util.DateUtil;

import java.util.Date;
import java.util.List;


@Service
public class StatServiceImpl implements StatService {

    @Autowired
    PersonService personService;

    @Autowired
    CourseService courseService;

    @Override
    public byte[] allActivePass() {

        List<Pass> passList = personService.findActivePass();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Курс")
                .append("|")
                .append("Клиент")
                .append("|")
                .append("Дата")
                .append("|")
                .append("Сколько занятий было")
                .append("|")
                .append("Сколько занятий осталось")
                .append("\n");


        passList.stream().filter(x->x.getCurrentItemCount()>0).forEach(pass->stringBuilder
                .append(pass.getCourse().getName())
                .append("|")
                .append(pass.getPerson().getFirstName()).append(" ").append(pass.getPerson().getLastName())
                .append("|")
                .append(DateUtil.format(pass.getTerminateDate()))
                .append("|")
                .append(pass.getItemCount())
                .append("|")
                .append(pass.getCurrentItemCount())
                .append("\n")
        );

        return stringBuilder.toString().getBytes();

    }

    @Override
    public byte[] allLessons(Date date) {
        List<Lesson> lessons = courseService.getLessons(date);

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Курс")
                .append("|")
                .append("Клиент")
                .append("|")
                .append("Дата")
                .append("\n");


        lessons.forEach(lesson->stringBuilder
                .append(lesson.getCourselevel().getName())
                .append("|")
                .append(lesson.getPass().getPerson().getFirstName()).append(" ").append(lesson.getPass().getPerson().getLastName())
                .append("|")
                .append(DateUtil.format(lesson.getDate()))
                .append("\n")
        );

        return stringBuilder.toString().getBytes();
    }
}
