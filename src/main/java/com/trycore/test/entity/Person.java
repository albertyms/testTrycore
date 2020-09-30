package com.trycore.test.entity;

import com.trycore.test.request.PersonRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "persons", schema="public")
public class Person {

    @GenericGenerator(
            name = "personGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "person_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            }
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "personGenerator")
    private Long id;
    @Column(name = "age")
    private int age;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "idNumber")
    private int idNumber;
    @Column(name = "height")
    private double height;
    @Column(name = "weight")
    private double weight;
    @Column(name = "gender")
    private int gender;
    @Column(name = "birth_date")
    private Date birthDate;
    @Column(name = "count_view")
    private int countView;

    public Person() {
    }

    public Person(PersonRequest request) {
        this.age = request.getAge();
        this.fullName = request.getFullName();
        this.idNumber = request.getIdNumber();
        this.height = request.getHeight();
        this.weight = request.getWeight();
        this.gender = request.getGender();
        this.birthDate = request.getBirthDate();
    }

    public Person(int age, String fullName, int idNumber, double height, double weight, int gender, Date birthDate, int countView) {
        this.age = age;
        this.fullName = fullName;
        this.idNumber = idNumber;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.birthDate = birthDate;
        this.countView = countView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setId_number(int id_number) {
        this.idNumber = idNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getCountView() {
        return countView;
    }

    public void setCountView(int countView) {
        this.countView = countView;
    }
}
