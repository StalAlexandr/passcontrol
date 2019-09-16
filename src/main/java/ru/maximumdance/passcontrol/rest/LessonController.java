package ru.maximumdance.passcontrol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.PersonService;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private PersonService personService;

    @DeleteMapping("/{id}/")
    public Person removeLesson(@PathVariable Long id){
        return personService.removeLesson(id);
    }


}
