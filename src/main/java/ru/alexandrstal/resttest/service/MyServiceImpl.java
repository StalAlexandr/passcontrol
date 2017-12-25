package ru.alexandrstal.resttest.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class MyServiceImpl implements MyService {
    public String getService() {
        return "MyServiceImpl";
    }
}
