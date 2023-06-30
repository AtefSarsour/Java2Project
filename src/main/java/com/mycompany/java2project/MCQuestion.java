package com.mycompany.java2project;

import com.mycompany.java2project.Question;
import java.util.ArrayList;
import java.util.Scanner;

public class MCQuestion extends Question {

    private String[] choices;
    private int answer;

    public MCQuestion(int mark, String Question, String[] choices, int answer) {
        int choicesNumber = choices.length;
        if (choicesNumber >= 2 && choicesNumber <= 6) {
            setChoices(choices);
            this.setAnswer(answer);
            super.setQuestionText(Question);
            super.setMark(mark);
            id = ++baseCounter;
        } else {
            System.out.println(notValid());

        }
    }

    public String[] getChoices() {
        return choices;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
    @Override
    public String getAnswer() {
        return String.valueOf(answer);
    }
    @Override
    String notValid() {
        return "cann't add this question because the choices not valid (2 to 6 choices)!";
    }

    @Override
    public String toString() {
        String s = "Q" + id + ": " + super.getQuestionText() + "     (" + super.getMark() + " Marks)\n";
        int j = 0;
        for (int i = 0; i < choices.length; i++) {
            if (choices.length > 0) {
                s += ++j + "-" + choices[i] + "\n";
            } else {
                System.out.println("Lengh is zero!");
            }
        }
        return s;
    }

    void setAnswer(String newText) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
