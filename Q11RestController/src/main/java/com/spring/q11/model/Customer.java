package com.spring.q11.model;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private long dateOfBirth;

    // Constructor
    public Customer(int id, String firstName, String lastName, String email, String mobile, long dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMobile() { return mobile; }
    public void setMobile(String mobile) { this.mobile = mobile; }

    public long getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(long dateOfBirth) { this.dateOfBirth = dateOfBirth; }
}
