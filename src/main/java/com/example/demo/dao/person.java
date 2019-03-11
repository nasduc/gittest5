package com.example.demo.dao;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class person {
    private int age;
    private int high;
    private String name;
    private Date birth;

    public person() {
    }

    public person(int age, int high, String name) {
        this.age = age;
        this.high = high;
        this.name = name;
    }
    @JSONField(name = "aaa")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JSONField(serialize = false)
    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(format = "yy-MM-dd HH:mm:ss")
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public person(int age, int high, String name, Date birth) {
        this.age = age;
        this.high = high;
        this.name = name;
        this.birth = birth;
    }

}
