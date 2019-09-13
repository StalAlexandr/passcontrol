package ru.maximumdance.passcontrol.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "lessons")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    @ManyToOne
    @JoinColumn(name = "courselevel_id", referencedColumnName = "id")
    CourseLevel courselevel;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    Date date;

    @Column
    String name="a";


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  //  @JoinColumn(name = "pass_id")
    @JsonBackReference
    private
    Pass pass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public CourseLevel getCourselevel() {
        return courselevel;
    }

    public void setCourselevel(CourseLevel courselevel) {
        this.courselevel = courselevel;
    }

    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }
}
