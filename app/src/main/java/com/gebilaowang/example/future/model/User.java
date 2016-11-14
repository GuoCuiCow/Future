package com.gebilaowang.example.future.model;

/**
 * Created by cuiguo on 2016/11/14.
 */

public class User {
    private String name;
    private int age;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User(String name, String url, int age) {
        this.name = name;
        this.url = url;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
