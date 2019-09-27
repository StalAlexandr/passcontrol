package ru.maximumdance.passcontrol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.maximumdance.passcontrol.model.Pass;
import ru.maximumdance.passcontrol.model.Person;
import ru.maximumdance.passcontrol.service.PersonService;


import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("/")
    public List<Person> root() {
        return personService.getAll();
    }

    @PutMapping("/")
    public Person update(@RequestBody Person person){
            return personService.update(person);
    }


    @PostMapping("/")
    public Person insert(@RequestBody Person person){
            return personService.insert(person);
    }


    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<Person> findById(@PathVariable Integer id){
        Person person = personService.findById(id);
        return Util.buildPersonResponseEntity(person);

    }

    @ResponseBody
    @GetMapping(value = "/select", produces = "application/json")
    public  ResponseEntity<Person>  find(@RequestParam Map<String,String> params){
        return Util.buildPersonResponseEntity(personService.find(params));
    }

    @GetMapping("/selectByName/{name}")
    public  ResponseEntity<List<Person>> findByName(@PathVariable String name){
        return Util.buildPersonResponseEntity(personService.findByNameLike(name));
    }

    @PostMapping("/{id}/pass")
    public Person addPass(@PathVariable Integer id, @RequestBody Pass pass){
        return personService.addPass(id, pass);
    }

    @PutMapping("/{id}/pass")
    public Person update(@PathVariable Integer id, @RequestBody Pass pass){
        return personService.updatePass(id, pass);
    }

}
