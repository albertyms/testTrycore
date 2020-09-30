package com.trycore.test.response;

import javax.persistence.Column;
import java.util.Date;

public class PersonResponse {
    private Long id;
    private int age;
    private String fullName;
    private int id_number;
    private int height;
    private int weight;
    private int gender;
    private Date birthDate;
    private int countView;

    public PersonResponse() {
    }

    public PersonResponse(int age, String fullName, int id_number, int height, int weight, int gender, Date birthDate, int countView) {
        this.age = age;
        this.fullName = fullName;
        this.id_number = id_number;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.birthDate = birthDate;
        this.countView = countView;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId_number() {
        return id_number;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public int getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getCountView() {
        return countView;
    }
}
