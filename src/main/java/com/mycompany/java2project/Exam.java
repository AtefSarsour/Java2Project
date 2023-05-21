package com.mycompany.java2project;

import Questions.Question;
import static Questions.Question.sortQuestions;
import Questions.TrueFalseQuestion;
import java.util.ArrayList;
import View.Java2Project.*;
import java.util.Collections;

public class Exam {

    static int baseCounter;
    int id;
    String examName;
    int numOfQuestions;
    int passGrade;
    int questionType;
    ArrayList<Question> questionsoOfQuestionType = new ArrayList();
    public static ArrayList<Exam> exams = new ArrayList();
    ArrayList<Question> examQuestions = new ArrayList();

    public Exam(String examName, int numOfQuestions, int passGrade, int questionType) {
        this.examName = examName;
        this.id = ++baseCounter;
        this.numOfQuestions = numOfQuestions;
        this.passGrade = passGrade;
        this.questionType = questionType;
        addQuestions();
        exams.add(this);
        for (int i = 0; i < this.numOfQuestions; i++) {
            examQuestions.add((Question) questionsoOfQuestionType.get(i));
        }
    }

    public void viewExams() {
        for (int i = 0; i < exams.size(); i++) {
            System.out.println(exams.get(i).toString() + "\n");
        }
    }

    public void viewExam(Exam exam) {
        exam.toString();
    }

    public void viewExamQuestions() {
        for (int i = 0; i < numOfQuestions; i++) {
            System.out.println(examQuestions.get(i));
        }
    }

    @Override
    public String toString() {
        return "*- Exam (" + this.getId() + ")\nExam name: " + examName + "\nnumOfQuestions: " + numOfQuestions + "\npassGrade: " + passGrade + "\nquestionType: " + questionType + " -*\n";
    }

    public void addQuestions() {
        sortQuestions();
        switch (questionType) {
            case 1:
                questionsoOfQuestionType.addAll(Question.trueFalseQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
            case 2:
                questionsoOfQuestionType.addAll(Question.mCQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
            case 3:
                questionsoOfQuestionType.addAll(Question.fillTheBlankQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
        }
    }

    public int getBaseCounter() {
        return baseCounter;
    }

    public void setBaseCounter(int baseCounter) {
        this.baseCounter = baseCounter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public int getNumOfQuestions() {
        return numOfQuestions;
    }

    public void setNumOfQuestions(int numOfQuestions) {
        this.numOfQuestions = numOfQuestions;
    }

    public int getPassGrade() {
        return passGrade;
    }

    public void setPassGrade(int passGrade) {
        this.passGrade = passGrade;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public ArrayList<Question> getQuestionsoOfQuestionType() {
        return questionsoOfQuestionType;
    }

    public void setQuestionsoOfQuestionType(ArrayList<Question> questionsoOfQuestionType) {
        this.questionsoOfQuestionType = questionsoOfQuestionType;
    }

    public static ArrayList<Exam> getExams() {
        return exams;
    }

    public static void setExams(ArrayList<Exam> exams) {
        Exam.exams = exams;
    }

    public ArrayList<Question> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(ArrayList<Question> examQuestions) {
        this.examQuestions = examQuestions;
    }
}
