package com.hxd.test1.entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String pwd;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(String pwd, String name) {
        this.pwd = pwd;
        this.name = name;
    }
}

