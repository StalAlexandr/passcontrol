package ru.maximumdance.passcontrol.service;

import org.springframework.stereotype.Service;

@Service
//@Profile("prod")
public class MyServiceImpl implements MyService {
    public String getService() {
        return "MyServiceImpl";
    }
}
