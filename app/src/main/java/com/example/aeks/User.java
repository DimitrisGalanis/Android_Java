package com.example.aeks;

// User class with getters & setters
public class User {
    private int _id;
    private String username;
    private String password;

    public User() {
        this.username ="";
        this.password="";
    }

    public User(int id, String username, String password) {
        this._id = id;
        this.username = username;
        this.password = password;
    }

    public void setID(int id) {
        this._id = id;
    }
    public int getID() {
        return this._id;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return this.password;
    }
}
