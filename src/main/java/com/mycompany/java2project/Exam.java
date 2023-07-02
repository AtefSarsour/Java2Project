package com.mycompany.java2project;

import static com.mycompany.java2project.Question.sortQuestions;
import java.util.ArrayList;
import com.mycompany.java2project.Java2Project.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

import java.io.FileWriter;
import java.io.IOException;

public class Exam {

    int id;
    static int baseCounter;
    String examName;
    int numOfQuestions;
    int passGrade;
    private int[] questionTypes;
    ArrayList<Question> questionsoOfQuestionType = new ArrayList();
    public static ArrayList<Exam> exams = new ArrayList();
    public static ArrayList<Question> examQuestions = new ArrayList();

    public Exam(String examName, int numOfQuestions, int passGrade, int... questionTypes) {
        if (!(numOfQuestions <= 0)) {
            this.numOfQuestions = numOfQuestions;
        } else {
            throw new IllegalArgumentException("numOfQuestions must be a positive integer.");
        }
        if (!(passGrade <= 0)) {
            this.passGrade = passGrade;
        } else {
            throw new IllegalArgumentException("passGrade must be a positive integer.");
        }
        this.examName = examName;
        this.id = ++baseCounter;

        validateQuestionTypes(questionTypes);
        this.questionTypes = questionTypes;
        addQuestions();

        exams.add(this);
        for (int i = 0; i < this.numOfQuestions; i++) {
            examQuestions.add((Question) questionsoOfQuestionType.get(i));
        }
    }

    public void addQuestions() {
        sortQuestions();
        for (int type : questionTypes) {
            switch (type) {
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

    public static void viewExams() {
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

    public int[] getQuestionTypes() {
        return questionTypes;
    }

    public void setQuestionTypes(int[] questionTypes) {
        this.questionTypes = questionTypes;
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
//_____________________________________________________________________________________________________________________________________________________________________

    public ArrayList<Question> getExamQuestions() {
        return examQuestions;
    }

    public void setExamQuestions(ArrayList<Question> examQuestions) {
        this.examQuestions = examQuestions;
    }

    private void validateQuestionTypes(int... questionTypes) {
        for (int type : questionTypes) {
            if (type < 1 || type > 3) {
                throw new IllegalArgumentException("Invalid question type: " + type);
            }
        }
    }

    @Override
    public String toString() {
        return "Exam{" + "id=" + id + ", examName=" + examName + ", numOfQuestions=" + numOfQuestions + ", passGrade=" + passGrade + ", questionTypes=" + questionTypes + ", questionsoOfQuestionType=" + questionsoOfQuestionType + '}';
    }


}
