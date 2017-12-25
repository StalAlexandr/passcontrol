package ru.alexandrstal.resttest.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"ru.alexandrstal.resttest.service", "ru.alexandrstal.resttest.rest"})
public class Config {
}
