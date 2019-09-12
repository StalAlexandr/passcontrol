package ru.maximumdance.passcontrol.service;

import ru.maximumdance.passcontrol.model.Course;
import ru.maximumdance.passcontrol.model.Lesson;

import java.util.Date;
import java.util.List;

public interface CourseService {

    List<Course> getAll();

    List<Lesson> getLessons(Date date);
}
