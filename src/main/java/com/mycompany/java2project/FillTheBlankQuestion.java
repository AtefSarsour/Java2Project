package com.mycompany.java2project;

import java.util.Scanner;

public class FillTheBlankQuestion extends Question {

    private String answer;

    public FillTheBlankQuestion(String question, String answer, int mark) {
        if (!question.isEmpty() && !answer.isEmpty()) {
            super.setQuestionText(question);
            super.setMark(mark);
            this.answer = answer;
            id = ++baseCounter;

        } else {
            System.out.println(notValid());
        }
    }

    
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    String notValid() {
        return "try again after validate if the question and the answer not empty!";
    }

    @Override
    public String toString() {
        String s = "Q"+id+": " + super.getQuestionText() + "    (" + super.getMark() + " Marks)\n";
        return s;
    }
}
