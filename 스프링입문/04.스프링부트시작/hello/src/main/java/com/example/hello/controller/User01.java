package com.example.hello.controller;

public class User01 {
    private String name;
    private int age;


    public  User01(){
        this.name = null;
        this.age = 0;
    }
    public User01(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User01{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
