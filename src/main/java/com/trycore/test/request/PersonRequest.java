package com.trycore.test.request;



import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Validated
public class PersonRequest {
    @JsonProperty(value = "age")
    @NotNull(message = "age Client cannot be null")
    private int age;
    @JsonProperty(value = "fullName")
    @NotNull(message = "fullName Client cannot be null")
    private String fullName;
    @JsonProperty(value = "idNumber")
    @NotNull(message = "idNumber Client cannot be null")
    private int idNumber;
    @JsonProperty(value = "height")
    @NotNull(message = "height Client cannot be null")
    private double height;
    @JsonProperty(value = "weight")
    @NotNull(message = "weight Client cannot be null")
    private double weight;
    @JsonProperty(value = "gender")
    @NotNull(message = "gender Client cannot be null")
    private int gender;
    @JsonProperty(value = "birthDate")
    @NotNull(message = "birthDate Client cannot be null")
    private Date birthDate;

    public PersonRequest() {
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

    public void setIdNumber(int idNumber) {
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
}
