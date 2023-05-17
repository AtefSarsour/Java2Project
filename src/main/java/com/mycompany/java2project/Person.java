package com.mycompany.java2project;

import java.util.ArrayList;

public class Person {

    static ArrayList<Teacher> teachers = new ArrayList();
    static ArrayList<Student> students = new ArrayList();

    private String userName;
    private String password;
    private String name;
    private String birthDate;
    private boolean isMale;
    String birthYear = birthDate.substring(birthDate.lastIndexOf("/") + 1, birthDate.length());

    public Person(String userName, String password, String birthDate, boolean isMale, String name) {
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.isMale = isMale;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

}
