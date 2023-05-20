package Questions;

import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.java2project.Utils;

public abstract class Question {

    int id;
    static int baseCounter;
    private String questionText = "";
    private int mark = 0;
    private int realMark;
    public static ArrayList<TrueFalseQuestion> trueFalseQuestions = new ArrayList();
    public static ArrayList<MCQuestion> mCQuestions = new ArrayList();
    public static ArrayList<FillTheBlankQuestion> fillTheBlankQuestions = new ArrayList();

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

    abstract String notValid();

    public static void sortQuestions() {
        for (int i = 0; i < Utils.questions.size(); i++) {
            if (Utils.questions.get(i) instanceof TrueFalseQuestion trueFalseQuestion) {
                trueFalseQuestions.add(trueFalseQuestion);
            } else if (Utils.questions.get(i) instanceof MCQuestion mCQuestion) {
                mCQuestions.add(mCQuestion);
            } else {
                fillTheBlankQuestions.add((FillTheBlankQuestion) Utils.questions.get(i));
            }
        }
    }

    public static void viewQuestions() {
        for (int i = 0; i < Utils.questions.size(); i++) {
            if (Utils.questions.get(i) instanceof TrueFalseQuestion trueFalseQuestion) {
                System.out.println(trueFalseQuestion.toString());
            } else if (Utils.questions.get(i) instanceof MCQuestion mCQuestion) {
                System.out.println(mCQuestion.toString());
            } else if (Utils.questions.get(i) instanceof FillTheBlankQuestion fillTheBlankQuestion) {
                System.out.println(fillTheBlankQuestion.toString());
            }
        }
    }

//    public void editQuestion() {
//        int idOfQuestion;
//        Question questionToEdit;
//        viewQuestions();
//        System.out.print("Please enter question ID: ");
//        idOfQuestion = new Scanner(System.in).nextInt();
//        questionToEdit = Utils.questions.get(id - 1);
////        switch (questionToEdit) {
////            case TrueFalseQuestion q:
////                String choice;
////                int newMark;
////                String newText;
////                System.out.print("Please enter what you want to edit? (Text/Answer/Mark)");
////                choice = new Scanner(System.in).nextLine();
////                switch (choice.toLowerCase()) {
////                    case "text":
////
////                        System.out.print("Please enter text: ");
////                        newText = new Scanner(System.in).nextLine();
////                        q.setQuestionText(newText);
////                        break;
////                    case "answer":
////                        System.out.print("Please enter new answer (Yes/No): ");
////                        newText = new Scanner(System.in).nextLine();
////                        q.setAnswer(newText);
////                        break;
////                    case "mark":
////                        System.out.print("Please enter new mark: ");
////                        newMark = new Scanner(System.in).nextInt();
////                        q.setMark(newMark);
////                        break;
////                }
////                break;
//            case MCQuestion q:
//                System.out.print("Please enter what you want to edit? (Text/Choices/Answer/Mark)");
//                choice = new Scanner(System.in).nextLine();
//                switch (choice) {
//                    case "text":
//                        System.out.print("Please enter new text: ");
//                        newText = new Scanner(System.in).nextLine();
//                        q.setQuestionText(newText);
//                        break;
//                    case "choices":
//                        System.out.println("Enter the number of choices (2-6):");
//                        int numChoices = new Scanner(System.in).nextInt();
//                        String[] choices = new String[numChoices];
//                        for (int i = 1; i <= numChoices; i++) {
//                            System.out.println("Enter choice " + i + ":");
//                            choices[i] = new Scanner(System.in).nextLine();
//                            q.setChoices(choices);
//                        }
//                        break;
//
//                    case "mark":
//                        System.out.print("Please enter new mark: ");
//                        newMark = new Scanner(System.in).nextInt();
//                        q.setMark(newMark);
//                        break;
//                    case "answer":
//                        System.out.print("Please enter new answer number (1-" + q.getChoices().length + "): ");
//                        newText = new Scanner(System.in).nextLine();
//                        q.setAnswer(Integer.parseInt(newText));
//                        break;
//                    default:
//                        System.out.println("Please stick to the provided style");
//
//                }
//                break;
//            case FillTheBlankQuestion q:
//                System.out.print("Please enter what you want to edit? (Text/Answer/Mark)");
//                choice = new Scanner(System.in).nextLine();
//                switch (choice.toLowerCase()) {
//                    case "text":
//                        System.out.println("Please enter you new text: ");
//                        newText = new Scanner(System.in).nextLine();
//                        q.setQuestionText(newText);
//                        break;
//                    case "answer":
//                        System.out.println("Please enter you new answer: ");
//                        newText = new Scanner(System.in).nextLine();
//                        q.setAnswer(newText);
//                        break;
//                    case "mark":
//                        System.out.println("Please enter new mark: ");
//                        newMark = new Scanner(System.in).nextInt();
//                        q.setMark(newMark);
//                        break;
//                    default:
//                        System.out.println("Please stick to the provided style");
//                }
//                break;
//            default:
//                System.out.println("Wrong id");
//        }
//    }

    public abstract String getAnswer();
}
