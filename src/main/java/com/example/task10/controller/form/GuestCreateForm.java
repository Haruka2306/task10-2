package com.example.task10.controller.form;

public class GuestCreateForm {
    private int id;
    private String name;
    private int age;
    private String address;

    public GuestCreateForm(int id, String name, int age, String address) {
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
