package ru.maximumdance.passcontrol.stat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maximumdance.passcontrol.service.CourseService;
import ru.maximumdance.passcontrol.service.PersonService;
import ru.maximumdance.passcontrol.service.StatService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@Controller
@RequestMapping("/stat")
public class StatController {


    @Autowired
    PersonService personService;


    @Autowired
    CourseService courseService;

    @GetMapping("/passes")
    public String passes(Model model) throws Exception {
        model.addAttribute("passes", personService.findActivePass());
        return "passes";
    }



    @GetMapping("/lessons/{date}")
    public String lessonsPerDate(Model model, @PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws IOException {
        return lessons(model, date);
    }


    @GetMapping("/lessons")
    public String lessons(Model model)  {
        return lessons(model, new Date());
    }

    @GetMapping("/persons")
    public String users(Model model)  {
        model.addAttribute("persons", personService.getAll());
        return "persons";
    }




    private  String lessons(Model model, Date date){
        model.addAttribute("lessons", courseService.getLessons(date));
        model.addAttribute("date", date);
        return "lessons";
    }

}
