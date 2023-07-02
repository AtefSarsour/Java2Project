package com.mycompany.java2project;

import com.mycompany.java2project.Exam;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.java2project.Utils;

public abstract class Question {

    int id;
    static int baseCounter;
    private String questionText = "";
    private int mark = 0;
    private int realMark;//the mark that student has goten answering the question 

    public static ArrayList<TrueFalseQuestion> trueFalseQuestions = new ArrayList();
    public static ArrayList<MCQuestion> mCQuestions = new ArrayList();
    public static ArrayList<FillTheBlankQuestion> fillTheBlankQuestions = new ArrayList();

    abstract String notValid();

    public static void sortQuestions() {
        
        for (int i = 0; i < Utils.questions.size(); i++) {
            if (Utils.questions.get(i) instanceof TrueFalseQuestion) {
                trueFalseQuestions.add((TrueFalseQuestion) Utils.questions.get(i));
            } else if (Utils.questions.get(i) instanceof MCQuestion) {
                mCQuestions.add((MCQuestion) Utils.questions.get(i));
            } else {
                fillTheBlankQuestions.add((FillTheBlankQuestion) Utils.questions.get(i));
            }
        }
    }

    public static void viewQuestions() {
        for (int i = 0; i < Utils.questions.size(); i++) {
            if (Utils.questions.get(i) instanceof TrueFalseQuestion) {
                System.out.println(((TrueFalseQuestion) Utils.questions.get(i)).toString());
            } else if (Utils.questions.get(i) instanceof MCQuestion) {
                System.out.println(((MCQuestion) Utils.questions.get(i)).toString());
            } else if (Utils.questions.get(i) instanceof FillTheBlankQuestion) {
                System.out.println(((FillTheBlankQuestion) Utils.questions.get(i)).toString());
            }
        }
    }

    public void editQuestion() {

        int idOfQuestion;
        Question q;
        viewQuestions();
        System.out.print("Please enter question ID: ");
        idOfQuestion = new Scanner(System.in).nextInt();
        q = Utils.questions.get(id - 1);
        String choice;
        int newMark;
        String newText;
        if (q instanceof TrueFalseQuestion) {
            System.out.print("Please enter what you want to edit? (Text/Answer/Mark)");
            choice = new Scanner(System.in).nextLine();
            switch (choice.toLowerCase()) {
                case "text":
                    System.out.print("Please enter text: ");
                    newText = new Scanner(System.in).nextLine();
                    q.setQuestionText(newText);
                    break;
                case "answer":
                    System.out.print("Please enter new answer (Yes/No): ");
                    newText = new Scanner(System.in).nextLine();
                    ((TrueFalseQuestion) q).setAnswer(newText);
                    break;
                case "mark":
                    System.out.print("Please enter new mark: ");
                    newMark = new Scanner(System.in).nextInt();
                    q.setMark(newMark);
                    break;
                    
                    
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    return;
            }
        }

        if (q instanceof MCQuestion) {
            System.out.print("Please enter what you want to edit? (Text/Choices/Answer/Mark)");
            choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "text":
                    System.out.print("Please enter new text: ");
                    newText = new Scanner(System.in).nextLine();
                    q.setQuestionText(newText);
                    break;
                case "choices":
                    System.out.println("Enter the number of choices (2-6):");
                    int numChoices = new Scanner(System.in).nextInt();
                    String[] choices = new String[numChoices];
                    for (int i = 1; i <= numChoices; i++) {
                        System.out.println("Enter choice " + i + ":");
                        choices[i] = new Scanner(System.in).nextLine();
                        ((MCQuestion) q).setChoices(choices);
                    }
                    break;
                    
                case "mark":
                    System.out.print("Please enter new mark: ");
                    newMark = new Scanner(System.in).nextInt();
                    q.setMark(newMark);
                    break;
                case "answer":
                    System.out.print("Please enter new answer number (1-" + ((MCQuestion) q).getChoices().length + "): ");
                    newText = new Scanner(System.in).nextLine();

                    ((MCQuestion) q).setAnswer(newText);

                    break;
               default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    return;

            }
        }
        if (q instanceof FillTheBlankQuestion) {
            System.out.print("Please enter what you want to edit? (Text/Answer/Mark)");
            choice = new Scanner(System.in).nextLine();
            switch (choice.toLowerCase()) {
                case "text":
                    System.out.println("Please enter you new text: ");
                    newText = new Scanner(System.in).nextLine();
                    q.setQuestionText(newText);
                    break;
                case "answer":
                    System.out.println("Please enter you new answer: ");
                    newText = new Scanner(System.in).nextLine();
                    ((FillTheBlankQuestion) q).setAnswer(newText);

                    break;
                case "mark":
                    System.out.println("Please enter new mark: ");
                    newMark = new Scanner(System.in).nextInt();
                    q.setMark(newMark);
                    break;
                 default:
                    System.out.println("Invalid choice. Please choose a valid option.");
                    return;
            }
        } else {
            System.out.println("Wrong id");
        }
    }

    public abstract String getAnswer();

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public int getRealMark() {
        return realMark;
    }

    public void setRealMark(int realMark) {
        this.realMark = realMark;
    }

    public void viewExamDetails() {

    }
//  مش فاهم الفائدة متها دقق فيها

    public String getText() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //___________________________________________________
}
