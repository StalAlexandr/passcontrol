package ru.maximumdance.passcontrol.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maximumdance.passcontrol.service.StatService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

@RestController
@RequestMapping("/stat")
public class StatController {

    @Autowired
    StatService service;

    @GetMapping("/passes")
    public ResponseEntity<InputStreamResource> excelCustomersReport() throws IOException {
         InputStream in =  new ByteArrayInputStream(service.allActivePass()); //GenerateExcelReport.usersToExcel(users);
        // return IO ByteArray(in);

        HttpHeaders headers = new HttpHeaders();
        // set filename in header
        headers.add("Content-Disposition", "attachment; filename=passes.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }

    @GetMapping("/lessons/{date}")
    public ResponseEntity<InputStreamResource> excelLessonsReport(@PathVariable @DateTimeFormat(pattern="yyyy-MM-dd") Date date) throws IOException {
        InputStream in =  new ByteArrayInputStream(service.allLessons(date)); //GenerateExcelReport.usersToExcel(users);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }


    @GetMapping("/lessons")
    public ResponseEntity<InputStreamResource> excelLessonsReport() throws IOException {

        Date date = new Date();
        InputStream in =  new ByteArrayInputStream(service.allLessons(date)); //GenerateExcelReport.usersToExcel(users);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=lessons.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(in));
    }

}
