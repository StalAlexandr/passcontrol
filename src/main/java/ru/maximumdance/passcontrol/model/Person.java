package ru.maximumdance.passcontrol.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(unique = true)
    Integer cardNumber;

    @Column
    String firstName;

    @Column
    String lastName;

    @Column
    String midName;

    @Column
    String phoneNumber;

    @Column
    String comment;

    @Column
    Date birthDate;

    @Column
    Date regDate;


    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "person")
    @OrderColumn(name = "passOrder")
    List<Pass> passes = new ArrayList<>();

   // @Version
   // private Long version;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public List<Pass> getPasses() {
        return passes;
    }

    public void setPasses(List<Pass> passes) {
        this.passes = passes;
    }

    public void addPass(Pass pass){
        passes.add(pass);
        pass.setPerson(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", cardNumber=" + cardNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", midName='" + midName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", comment='" + comment + '\'' +
                ", birthDate=" + birthDate +
                ", regDate=" + regDate +
                ", passes=" + passes +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
