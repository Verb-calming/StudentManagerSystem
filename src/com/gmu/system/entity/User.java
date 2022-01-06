package com.gmu.system.entity;

public class User {
    private String username;
    private String password;
    private String lvl;

    public User() {
    }

    public User(String username, String password, String lvl) {
        this.username = username;
        this.password = password;
        this.lvl = lvl;
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

    public String getLevel() {
        return lvl;
    }

    public void setLevel(String lvl) {
        this.lvl = lvl;
    }
}
