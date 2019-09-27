package ru.maximumdance.passcontrol.model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pass")
public class Pass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne( optional = false,  cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    Course course;

    @ManyToOne
  //  @JoinColumn(name = "person_id")

    @JsonBackReference
    private
    Person person;

    @Column
    private
    Integer itemCount;


    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private
    Date launchDate;

    @Column
    @JsonFormat(pattern="yyyy-MM-dd")
    private

    Date terminateDate;

    /*
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "pass_lessons",
            joinColumns = @JoinColumn(name = "pass_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "lesson_id", referencedColumnName = "id"))
   */

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "pass")
    private
    Set<Lesson> lessons  = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;

    }

    public Integer getCurrentItemCount() {
        return itemCount - lessons.size();
    }

    /*
    public void setCurrentItemCount(Integer currentItemCount) {
        this.currentItemCount = currentItemCount;
    }
    */


    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    public Date getTerminateDate() {
        return terminateDate;
    }

    public void setTerminateDate(Date terminateDate) {
        this.terminateDate = terminateDate;
    }

    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        lessons.add(lesson);
        lesson.setPass(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pass pass = (Pass) o;
        return Objects.equals(id, pass.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


    public boolean isActive() {
        Date current = new Date();
        return ( (getCurrentItemCount()>0) && current.after(getLaunchDate()) && getTerminateDate().after(current) );
    }

}
