package com.example.ebookyoop.model;

public class User {
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String role;

    //    Default Constructor
    public User(){

    }

    //  Constructor without id
    public User(String fName,String lName,String email,String password,String role){
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //    Constructor with id
    public User(int id,String fName,String lName,String email,String password,String role){
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //    Getters & Setters
    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getFirstName() {
        return fName;
    }

    public void setName(String fName) {
        this.fName = fName;
    }

    public String getLastName() {
        return lName;
    }

    public void setLastName(String lastName) {
        this.lName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
