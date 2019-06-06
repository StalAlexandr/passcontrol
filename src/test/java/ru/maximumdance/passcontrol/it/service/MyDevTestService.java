package ru.maximumdance.passcontrol.it.service;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.maximumdance.passcontrol.service.MyService;

@Service
@Profile("dev")
public class MyDevTestService implements MyService {
    public String getService() {
        return "MyServiceDev";
    }
}
