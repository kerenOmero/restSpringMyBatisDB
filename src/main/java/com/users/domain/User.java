package com.users.domain;

public class User {

    public int id;
    public String firstName;
    public String lastName;
    public Character role;

    public User() {

    }

    public User(int id, String firstName, String lastName, Character role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role=role;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName){this.firstName = newFirstName;}

    public String getLastName() {
        return lastName;
    }

    public Character getRole() {
        return role;
    }
}