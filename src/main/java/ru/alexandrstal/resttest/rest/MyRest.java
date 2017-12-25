package ru.alexandrstal.resttest.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.alexandrstal.resttest.service.MyService;

@RestController
public class MyRest {
    @Autowired
    private MyService service;

    @RequestMapping("/")
    public String root() {
        return service.getService();
    }
}
