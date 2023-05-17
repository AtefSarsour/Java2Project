package com.mycompany.java2project;

import java.util.Date;
import java.util.Scanner;

public class Student extends Person {

    public static int getBaseCounter() {
        return baseCounter;
    }

    private String date = String.valueOf(new Date());
    private static int baseCounter;
    private String universityId;
    private String currentYear = date.substring(date.length() - 4, date.length());
    private int examMark;

    public Student(String userName, String password, String name, String birthDate, boolean isMale) {
        super(userName, password, birthDate, isMale, name);
        if (isMale) {
            this.universityId = '1' + (Integer.parseInt(birthYear) + 18) + "000" + ++baseCounter;
        } else {
            this.universityId = '2' + (Integer.parseInt(birthYear) + 18) + "000" + ++baseCounter;
        }

    }

    public Student(String userName, String password, String name, String universityId, String birthDate, boolean isMale) {
        super(userName, password, birthDate, isMale, name);
        this.universityId = universityId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "{" + "Username= " + super.getUserName() + " name= " + super.getName() + " university Id= " + getUniversityId() + "}\n";
    }

    public void solveExam(Exam exam) {
        for (int i = 0; i < exam.numOfQuestions; i++) {
            System.out.println(exam.examQuestions.get(i));
            System.out.println("Enter answer");
            String answer = new Scanner(System.in).nextLine();
            if (answer.equals(exam.examQuestions.get(i).getAnswer())) {
                examMark += exam.examQuestions.get(i).getMark();
            }
        }
    }
}
