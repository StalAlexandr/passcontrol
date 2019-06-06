package ru.maximumdance.passcontrol.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ru.maximumdance.passcontrol.service", "ru.maximumdance.passcontrol.rest",
        "ru.maximumdance.passcontrol.service", "ru.maximumdance.passcontrol.dao"})
@EntityScan( basePackages = {"ru.maximumdance.passcontrol.model"} )
public class Config {
}
