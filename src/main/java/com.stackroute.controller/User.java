package com.stackroute.controller;

import com.stackroute.DB.Crudoperation;

public class User {
    Crudoperation connection;
    private  String username;
    private String password;

    public User(String username,String password){
        connection = new Crudoperation();
        this.username = username;
        this.password = password;
        connection.insertCustomer(this.username,this.password);
    }

    public User() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}


