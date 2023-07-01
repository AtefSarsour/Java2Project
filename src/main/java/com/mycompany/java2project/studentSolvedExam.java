
package com.mycompany.java2project;


import java.util.ArrayList;

public class studentSolvedExam {
    
   
public class StudentExamResult {
    private Student student;
    private Exam exam;
    private ArrayList<String> studentAnswers;
    private ArrayList<Integer> questionMarks;

    public StudentExamResult(Student student, Exam exam) {
        this.student = student;
        this.exam = exam;
        this.studentAnswers = new ArrayList<>();
        this.questionMarks = new ArrayList<>();
    }

    public void setAnswer(int questionIndex, String answer) {
        studentAnswers.set(questionIndex, answer);
    }public void setMark(int questionIndex, int mark) {
        questionMarks.set(questionIndex, mark);
    }

    public String getAnswer(int questionIndex) {
        return studentAnswers.get(questionIndex);
    }

    public int getMark(int questionIndex) {
        return questionMarks.get(questionIndex);
    }

    public int getTotalMark() {
        int totalMark = 0;
        for (int mark : questionMarks) {
            totalMark += mark;
        }
        return totalMark;
    }

    public Student getStudent() {
        return student;
    }

    public Exam getExam() {
        return exam;
    }
}
    
}
