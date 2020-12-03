package com.la_cite.surfrider.models;

public class Authenticationrequest {


    private String password;
    private String username;

    public Authenticationrequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
