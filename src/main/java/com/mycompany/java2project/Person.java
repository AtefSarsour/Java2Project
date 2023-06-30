package com.mycompany.java2project;

import java.util.ArrayList;

public class Person {

    public static ArrayList<Teacher> teachers = new ArrayList();
    public static ArrayList<Student> students = new ArrayList();

    private String userName;
    private String password;
    private String name;
    private String birthDate;
    private boolean isMale;
    String birthYear;

    public Person(String userName, String password, String birthDate, boolean isMale, String name) {

        if (isValidUserName(userName)) {
            this.userName = userName;
        } else {
            throw new IllegalArgumentException("Invalid userName");
        }
        if (isValidPassword(password)) {
            this.password = password;
        } else {
            throw new IllegalArgumentException("Invalid password");
        }
        if (isValidBirthDate(birthDate)) {
            this.birthDate = birthDate;
            this.birthYear = birthDate.substring(birthDate.lastIndexOf("/") + 1);
        } else {
            throw new IllegalArgumentException("Invalid birthDate");
        }

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

    public void setIsMale(String gender) {
        this.isMale = isMale;
    }

    //_____________________________________________________________________________
    private boolean isValidUserName(String userName) {
        boolean isValidPassword = false;
        if (!userName.isEmpty()){
            isValidPassword = true;
        }
        return isValidPassword;
    }

    private boolean isValidPassword(String password) {
        boolean isValidPassword = false;
        if (password.length() >= 6) {
            isValidPassword = true;
        }
        return isValidPassword;
    }

    private boolean isValidBirthDate(String birthDate) {
        boolean isValidBirthDate = false;
        String dateFormat = "\\d{2}/\\d{2}/\\d{4}";
        if (birthDate.matches(dateFormat)) {
            isValidBirthDate = true;
        }
        return isValidBirthDate;
    }

}
