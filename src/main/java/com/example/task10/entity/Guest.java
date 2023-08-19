package com.example.task10.entity;

public class Guest {
    private int id;
    private String name;
    private int age;
    //addressはユーザーには見せない
    private String address;

    public Guest(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}

