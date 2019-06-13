package ru.maximumdance.passcontrol.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String name;

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "course")
    List<CourseLevel> courseLevels = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CourseLevel> getCourseLevels() {
        return courseLevels;
    }

    public void setCourseLevels(List<CourseLevel> courseLevels) {
        this.courseLevels = courseLevels;
    }
}
