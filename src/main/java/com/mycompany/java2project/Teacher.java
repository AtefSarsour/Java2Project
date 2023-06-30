package com.mycompany.java2project;

import static com.mycompany.java2project.Person.students;

public class Teacher extends Person implements Common {

    private int id;
    private int salary;
    private static int baseCounter;
    private String Specialty;

    public Teacher(int salary, String Specialty, String userName, String password, String birthDate, boolean isMale, String name) {
        super(userName, password, birthDate, isMale, name);
        this.salary = salary;
        this.Specialty = Specialty;
        this.id = ++baseCounter;
    }

    public static int getBaseCounter() {
        return baseCounter;
    }

    public static void setBaseCounter(int aBaseCounter) {
        baseCounter = aBaseCounter;
    }

    public String getSpecialty() {
        return Specialty;
    }

    public void setSpecialty(String Specialty) {
        this.Specialty = Specialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void addStudent(String userName, String password, String name, String universityId, String birthDate, boolean isMale) {
        students.add(new Student(userName, password, name, universityId, birthDate,  isMale ));
    }

    @Override
    public String viewStudents() {
        return students.toString();
    }

}
