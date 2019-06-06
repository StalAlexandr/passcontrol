package ru.maximumdance.passcontrol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.PersonService;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostConstruct
    public void init(){
   System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
    }


    @GetMapping("/")
    public List<Person> root() {
        return personService.getAll();
    }

    @PutMapping("/")
    public void update(@RequestBody Person person){
         personService.update(person);
    }


    @PostMapping("/")
    public void insert(@RequestBody Person person){
        personService.insert(person);
    }


    @GetMapping("/{id}")
    public  Person findById(@PathVariable Integer id){
        return personService.findById(id);
    }


    @GetMapping("/select")
    public  Person find(@RequestParam Map<String,String> params){

        return personService.find(params);
    }

    @GetMapping("/selectByName/{name}")
    public  List<Person> findByName(@PathVariable String name){
        return personService.findByNameLike(name);
    }

}
