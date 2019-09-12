package ru.maximumdance.passcontrol.service;

import java.util.Date;

public interface StatService {

    byte[] allActivePass();

    byte[] allLessons(Date date);
}
