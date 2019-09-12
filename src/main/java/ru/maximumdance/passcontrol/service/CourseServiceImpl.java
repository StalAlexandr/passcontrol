package ru.maximumdance.passcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maximumdance.passcontrol.dao.CourseDAOImpl;
import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.util.DateUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseDAOImpl courseDAO;

    @Override
    public List<Course> getAll() {
        return courseDAO.getAll();
    }

    @Override
    public List<Lesson> getLessons(Date date) {
        return courseDAO.getLessons(DateUtil.withoutTime(date));
    }


}
