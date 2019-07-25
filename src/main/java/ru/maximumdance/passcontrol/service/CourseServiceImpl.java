package ru.maximumdance.passcontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.maximumdance.passcontrol.dao.CourseDAOImpl;
import ru.maximumdance.passcontrol.model.Course;

import java.util.List;

@Service
public class CourseServiceImpl implements  CourseService{

    @Autowired
    private CourseDAOImpl courseDAO;

    @Override
    public List<Course> getAll() {
        return courseDAO.getAll();
    }
}
