package View;

import Questions.FillTheBlankQuestion;
import Questions.MCQuestion;
import Questions.Question;
import Questions.TrueFalseQuestion;
import com.mycompany.java2project.Admin;
import com.mycompany.java2project.Exam;
import com.mycompany.java2project.Person;
import com.mycompany.java2project.Student;
import com.mycompany.java2project.Teacher;
import com.mycompany.java2project.Utils;
import java.util.Scanner;
import com.mycompany.java2project.Utils;

public class Java2Project {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Utils.addMembers();
        Utils.addQuestions();
        Utils.addExams();
        int choice = 0;
        System.out.println("Lets login! :):- ");
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = in.next();
        System.out.println(validateLogin(username, password));
        do {
            System.out.println("Enter Your choice, enter 4 to exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    Question.viewQuestions();
                    break;
                case 3:
                    Person.students.get(1).solveExam(Exam.exams.get(0));
                case 4:
                    System.exit(0);
                    break;

            }
        } while (choice != 4);

    }

    public static void addQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What type of question do you want to add?");
        System.out.println("1. Yes-No Question");
        System.out.println("2. Multiple Choice Question");
        System.out.println("3. Fill in the Blank Question");
        System.out.println("4. Order Question");
        System.out.println("5. Matching Question");
        int choice = scanner.nextInt();

        System.out.println("Enter the question text:");
        scanner.nextLine();
        String questionText = scanner.nextLine();

        System.out.println("Enter the marks weight:");
        int marksWeight = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the correct answer (true/false):");
                String correctAnswer = new Scanner(System.in).nextLine();
                Utils.questions.add(new TrueFalseQuestion(questionText, correctAnswer, marksWeight));
                break;

            case 2:
                System.out.println("Enter the number of choices (2-6):");
                int numChoices = scanner.nextInt();
                String[] choices = new String[numChoices];
                for (int i = 1; i <= numChoices; i++) {
                    System.out.println("Enter choice " + i + ":");
                    String aChoice = new Scanner(System.in).nextLine();
                    choices[i] = aChoice;
                }
                System.out.println("Enter the correct answer (1-" + numChoices + "):");
                int correctChoice = scanner.nextInt();
                Utils.questions.add(new MCQuestion(marksWeight, questionText, choices, correctChoice));
                break;

            case 3:
                System.out.println("Enter the correct answer:");
                scanner.nextLine();
                String correctAnswerText = scanner.nextLine();
                Utils.questions.add(new FillTheBlankQuestion(questionText, correctAnswerText, marksWeight));
                break;
        }
    }

    public static boolean validateLogin(String userName, String password) {
        String userType = null;
        for (Person p : Utils.persons) {
            if (userName.equals(p.getUserName())) {
                if (password.equals(p.getPassword())) {
                    if (p instanceof Admin a) {
                        userType = "Admin";
                    } else if (p instanceof Teacher t) {
                        userType = "Teacher";
                    } else if (p instanceof Student s) {
                        userType = "Student";
                    }
                    System.out.println(userType);
                    return true;
                } else {
                    System.out.println("Password is incorrect");
                    return false;
                }
            }
        }
        System.out.println("Username not found");
        return false;
    }
}
