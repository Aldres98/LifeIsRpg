package com.example.aldres.lifeisrpg;

/**
 * Created by Aldres on 14.02.18.
 */

public class User {

    private String email;
    private String username;
    private String gender;
    private int exp;

    public User(String email, String username, String gender, int exp) {
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.exp = exp;
    }

    public User() {
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void addExp(int amount){
        exp += amount;
    }

    public void removeExp(int amount) {
        exp -= amount;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
