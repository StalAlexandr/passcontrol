package ru.alexandrstal.resttest.it.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.alexandrstal.resttest.service.MyService;

@Service
@Profile("dev")
public class MyDevTestService implements MyService {
    public String getService() {
        return "MyServiceDev";
    }
}
