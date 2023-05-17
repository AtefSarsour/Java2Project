package com.mycompany.java2project;

import Questions.Question;
import static Questions.Question.sortQuestions;
import Questions.TrueFalseQuestion;
import java.util.ArrayList;
import View.Java2Project.*;
import java.util.Collections;

public class Exam {

    String examName;
    int numOfQuestions;
    int passGrade;
    int questionType;
    ArrayList questionsoOfQuestionType = new ArrayList();
    ArrayList<Exam> exams = new ArrayList();
    ArrayList<Question> examQuestions = new ArrayList();

    private Exam(String examName, int numOfQuestions, int passGrade, int questionType) {
        this.examName = examName;
        this.numOfQuestions = numOfQuestions;
        this.passGrade = passGrade;
        this.questionType = questionType;
    }

    public void makeExam(String examName, int numOfQuestions, int passGrade, int questionType) {
        exams.add(new Exam(examName, numOfQuestions, passGrade, questionType));
        addQuestions();
        for (int i = 0; i <= numOfQuestions; i++) {
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

    @Override
    public String toString() {
        return "Exam{Exam name: " + examName + ", numOfQuestions=" + numOfQuestions + ", passGrade=" + passGrade + ", questionType=" + questionType + ", questionsoOfQuestionType=" + questionsoOfQuestionType + '}';
    }

    public void addQuestions() {
        sortQuestions();
        switch (questionType) {
            case 1:
                questionsoOfQuestionType.add(Question.trueFalseQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
            case 2:
                questionsoOfQuestionType.add(Question.mCQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
            case 3:
                questionsoOfQuestionType.add(Question.fillTheBlankQuestions);
                Collections.shuffle(questionsoOfQuestionType);
                break;
        }
    }
}
