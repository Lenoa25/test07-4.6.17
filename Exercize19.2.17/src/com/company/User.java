package com.company;

/**
 * Created by hackeru on 2/19/2017.
 */
public class User {
    String name;
    String password;
    boolean isLogIn;

    public User() {
        isLogIn=false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLogIn() {
        return isLogIn;
    }

    public void setLogIn(boolean logIn) {
        isLogIn = logIn;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

}
