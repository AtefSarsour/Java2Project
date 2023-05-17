package Questions;

import Questions.Question;
import java.util.Scanner;

public class TrueFalseQuestion extends Question {

    private String answer = "true";

    public TrueFalseQuestion(String question, String answer, int mark) {
        if (setAnswer(answer)) {
            super.setQuestionText(question);
            super.setMark(mark);
            id = ++baseCounter;
        }
    }

    @Override
    public String getAnswer() {
        return answer;
    }

    public boolean setAnswer(String answer) {
        answer = answer.toLowerCase();
        if (answer.toLowerCase().equals("yes") || answer.toLowerCase().equals("no")) {
            this.answer = answer;
            return true;
        } else {
            System.out.println(notValid());
            return false;
        }
    }

    @Override
    public String notValid() {
        return "can't add this question because the answer not valid!";
    }

    @Override
    public String toString() {
        String s = "Q" + id + ": " + super.getQuestionText() + "     (" + super.getMark() + " Marks)\n1-Yes\n2-No\n";
        return s;
    }

}
