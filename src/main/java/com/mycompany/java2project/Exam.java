package com.mycompany.java2project;

import Questions.Question;
import static Questions.Question.sortQuestions;
import Questions.TrueFalseQuestion;
import java.util.ArrayList;
import View.Java2Project.*;
import java.util.Collections;

public class Exam {

    int baseCounter;
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
        this.id = baseCounter++;
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
        return "Exam{Exam name: " + examName + ", numOfQuestions=" + numOfQuestions + ", passGrade=" + passGrade + ", questionType=" + questionType + '}';
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
}
