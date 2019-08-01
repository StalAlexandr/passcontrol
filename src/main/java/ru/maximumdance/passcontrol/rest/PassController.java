package ru.maximumdance.passcontrol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maximumdance.passcontrol.model.Lesson;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.PersonService;

@RestController
@RequestMapping("/pass/")
public class PassController {

    @Autowired
    PersonService personService;

    @PostMapping("/{id}/lesson")
    public Person addLesson(@PathVariable Integer id, @RequestBody Lesson lesson){
        return personService.addLesson(id, lesson);
    }
}
