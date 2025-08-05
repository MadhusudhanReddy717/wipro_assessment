package com.spring.q7.model;

import jakarta.validation.constraints.*;
import java.util.List;

public class Student {

    @NotBlank(message = "{firstName.required}")
    @Size(min = 3, max = 30, message = "{firstName.size}")
    private String firstName;

    @NotBlank(message = "{lastName.required}")
    @Size(min = 3, max = 30, message = "{lastName.size}")
    private String lastName;

    @NotBlank(message = "{gender.required}")
    private String gender;

    @NotBlank(message = "{dob.required}")
    private String dob;

    @Email(message = "{email.invalid}")
    @NotBlank(message = "{email.required}")
    private String email;

    @NotBlank(message = "{section.required}")
    private String section;

    @NotBlank(message = "{country.required}")
    private String country;

    private boolean firstAttempt;

    @NotEmpty(message = "{subjects.required}")
    private List<String> subjects;

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
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSection() {
        return section;
    }
    public void setSection(String section) {
        this.section = section;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public boolean isFirstAttempt() {
        return firstAttempt;
    }
    public void setFirstAttempt(boolean firstAttempt) {
        this.firstAttempt = firstAttempt;
    }
    public List<String> getSubjects() {
        return subjects;
    }
    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }
}
