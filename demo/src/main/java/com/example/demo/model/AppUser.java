package com.example.demo.model;

public class AppUser {

    private String email;
    private String password;
    public AppUser() {
        super();
    }
    public AppUser( String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public String getId() {
        return email;
    }
    public void setId(String id) {
        this.email = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public String getContent() {
        return password;
    }
    public void setContent(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return this.email + "/" + this.password;
    }

}