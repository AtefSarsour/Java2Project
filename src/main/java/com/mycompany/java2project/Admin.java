package com.mycompany.java2project;

import java.util.ArrayList;

public class Admin extends Person implements Common {

    private int id = 1;
    private int salary;

    private Admin(String userName, String password, String name, String birthDate, boolean isMale, int salary) {
        super(userName, password, birthDate, isMale, name);
        this.salary = salary;
    }

    private static Admin admin;

    public static Admin addAdmin(String userName, String password, String name, String birthDate, boolean isMale, int salary) {
        if (admin == null) {
            admin = new Admin(userName, password, name, birthDate, isMale, salary);
        }
        return admin;
    }

    public void addTeacher(int salary, String Specialty, String userName, String password, String birthDate, boolean isMale, String name) {
        teachers.add(new Teacher(salary, Specialty, userName, password, birthDate, isMale, name));
    }

    public String viewTeachers() {
        return teachers.toString();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addStudent(String userName, String password, String name, String universityId, String birthDate, boolean isMale) {
        students.add(new Student(userName, password, name, universityId, birthDate, isMale));
    }

    @Override
    public String viewStudents() {
        return students.toString();

    }
}
