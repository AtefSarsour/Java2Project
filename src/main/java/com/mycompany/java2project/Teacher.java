package com.mycompany.java2project;

import static com.mycompany.java2project.Person.students;

public class Teacher extends Person implements Common {

    private int id;
    private int salary;
    private static int baseCounter;
    private String specialty;

    public Teacher(int salary, String specialty, String userName, String password, String birthDate, boolean isMale, String name) {
        super(userName, password, birthDate, isMale, name);
        
     if (salary >= 0) {
        this.salary = salary;
    } else {
        throw new IllegalArgumentException("Invalid salary");
    }
   
        this.specialty = specialty;
  
  
        this.id = ++baseCounter;
    }

    public static int getBaseCounter() {
        return baseCounter;
    }

    public static void setBaseCounter(int aBaseCounter) {
        baseCounter = aBaseCounter;
    }

   public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
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
