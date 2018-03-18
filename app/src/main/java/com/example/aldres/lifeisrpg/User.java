package com.example.aldres.lifeisrpg;

/**
 * Created by Aldres on 14.02.18.
 */

public class User {

    private String email;
    private String username;
    private String gender;
    private int exp;
    private int level;

    public User(String email, String username, String gender, int exp, int level) {
        this.email = email;
        this.username = username;
        this.gender = gender;
        this.exp = exp;
        this.level = level;
    }

    public User() {
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExp() {
        return exp;
    }

    public void addLevel(){
        level += 1;
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
