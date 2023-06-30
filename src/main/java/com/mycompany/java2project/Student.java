package com.mycompany.java2project;

import static com.mycompany.java2project.Question.viewQuestions;
import java.util.Date;
import java.util.Scanner;
import com.mycompany.java2project.Exam;
import java.util.ArrayList;
import java.util.Collections;

public class Student extends Person {

    private String date = String.valueOf(new Date());
    private static int baseCounter;
    private String universityId;
    private String currentYear = date.substring(date.length() - 4, date.length());
    private int examMark;

    //this contractor get the info of the new student and sends it to the super class and it cheaks 
    //if the student is male or female and it also creats the student's id (with some differentness Based on the gender )  
    
    public Student(String userName, String password, String name, String birthDate, boolean isMale) {
        super(userName, password, birthDate, isMale, name);
        if (isMale) {
            this.universityId = '1' + (Integer.parseInt(birthYear) + 18) + "000" + ++baseCounter;
        } else {
            this.universityId = '2' + (Integer.parseInt(birthYear) + 18) + "000" + ++baseCounter;
        }

    }

    public Student(String userName, String password, String name, String universityId, String birthDate, boolean isMale) {
        super(userName, password, birthDate, isMale, name);
        this.universityId = universityId;
    }

    public void solveExam(Exam exam) {
        for (int i = 0; i < exam.numOfQuestions; i++) {
            System.out.println(exam.examQuestions.get(i));
            System.out.println("Enter answer");
            String answer = new Scanner(System.in).nextLine();
            if (answer.equals(exam.examQuestions.get(i).getAnswer())) {
                examMark += exam.examQuestions.get(i).getMark();
            }
        }
    }

    public String getDate() {
        return date;
    }

    public static int getBaseCounter() {
        return baseCounter;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(String currentYear) {
        this.currentYear = currentYear;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    @Override
    public String toString() {
        return "{" + "Username= " + super.getUserName() + " name= " + super.getName() + " university Id= " + getUniversityId() + "}\n";
    }
//--------------------------------------------------------------------------------------

    ArrayList<String> studentAnswers = new ArrayList<>();
    ArrayList<Integer> examesmark = new ArrayList<>();

    public void solveExam() {
        Exam.viewExams();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Select an exam by entering its index: ");
        int selectedExamIndex = scanner.nextInt();
        scanner.nextLine();

        if (selectedExamIndex >= 0 && selectedExamIndex < Exam.exams.size()) {
            Exam selectedExam = Exam.exams.get(selectedExamIndex);
            System.out.println("Starting Exam: " + selectedExam.getExamName());
            System.out.println("Number of Questions: " + selectedExam.getNumOfQuestions());
            System.out.println("Passing Grade: " + selectedExam.getPassGrade());

            int totalQuestions = selectedExam.getNumOfQuestions();
            int correctAnswers = 0;
            int totalMArk = 0;

            //   for (int i = 0; i < totalQuestions; i++) {
            for (int i = 0; i < selectedExam.numOfQuestions; i++) {

                Question question = selectedExam.getExamQuestions().get(i);

                if (Exam.examQuestions.get(i) instanceof TrueFalseQuestion) {
                    System.out.println((Exam.examQuestions.get(i)));

                    System.out.print("Enter your answer: ");
                    String userAnswer = scanner.nextLine();
                    studentAnswers.add(userAnswer);
                    if (userAnswer.equals(question.getAnswer())) {
                        correctAnswers++;

                        totalMArk += question.getMark();

                    }

                } else if (Exam.examQuestions.get(i) instanceof MCQuestion) {
                    System.out.println(Exam.examQuestions.get(i));

                    System.out.print("Enter your answer: ");
                    String userAnswer = scanner.nextLine();
                    studentAnswers.add(userAnswer);
                    if (userAnswer.equals(question.getAnswer())) {
                        correctAnswers++;

                        totalMArk += question.getMark();

                    }

                } else if (Exam.examQuestions.get(i) instanceof FillTheBlankQuestion) {
                    System.out.println((Exam.examQuestions.get(i)));
                    System.out.print("Enter your answer: ");
                    String userAnswer = scanner.nextLine();
                    studentAnswers.add(userAnswer);
                    if (userAnswer.equals(question.getAnswer())) {
                        correctAnswers++;

                        totalMArk += question.getMark();

                    }
                }

            }

            System.out.println("Exam Finished!");
            System.out.println("Total Questions: " + totalQuestions);
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.println("mark : " + totalMArk);
            System.out.println("Incorrect Answers: " + (totalQuestions - correctAnswers));
            examesmark.add(totalMArk);
        } else {
            System.out.println("Invalid exam selection!");
        }
    }

    public int viewExamResult(int examIndex) {

        return examesmark.get(examIndex);
    }

    public void viewExamDetails(int examIndex) {

        Exam selectedExam = Exam.exams.get(examIndex);
        Scanner scanner = new Scanner(System.in);
        if (examIndex >= 0 && examIndex < Exam.exams.size()) {

            for (int i = 0; i < selectedExam.numOfQuestions; i++) {

                Question question = selectedExam.getExamQuestions().get(i);

                if (Exam.examQuestions.get(i) instanceof TrueFalseQuestion) {
                    System.out.println(Exam.examQuestions.get(i) + "       " + question.getRealMark());

                    boolean answerCondition;

                    if (studentAnswers.get(i).equals(question.getAnswer())) {
                        answerCondition = true;
                    } else {
                        answerCondition = false;
                        System.out.println(question.getAnswer());
                    }

                } else if (Exam.examQuestions.get(i) instanceof MCQuestion) {
                    System.out.println(Exam.examQuestions.get(i) + "       " + question.getRealMark());

                    boolean answerCondition;

                    if (studentAnswers.get(i).equals(question.getAnswer())) {
                        answerCondition = true;
                    } else {
                        answerCondition = false;
                        System.out.println(question.getAnswer());
                    }

                } else if (Exam.examQuestions.get(i) instanceof FillTheBlankQuestion) {
                    System.out.println(Exam.examQuestions.get(i) + "       " + question.getRealMark());

                    boolean answerCondition;

                    if (studentAnswers.get(i).equals(question.getAnswer())) {
                        answerCondition = true;
                    } else {
                        answerCondition = false;
                        System.out.println(question.getAnswer());
                    }
                }
            }
        } else {
            System.out.println("Invalid exam selection!");
        }
    }

    public void editInfo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Edit Student Information");
        System.out.println("1. Password");
        System.out.println("2. Name");
        System.out.println("3. Birthdate");
        System.out.println("4. Cancel");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.print("Enter new password: ");
                String newPassword = scanner.nextLine();
                setPassword(newPassword);
                System.out.println("Password updated successfully!");
                break;
            case 2:
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                setName(newName);
                System.out.println("Name updated successfully!");
                break;
            case 3:
                System.out.print("Enter new birthdate: ");
                String newBirthdate = scanner.nextLine();
                setBirthDate(newBirthdate);
                System.out.println("Birthdate updated successfully!");
                break;
            case 4:
                System.out.println("Edit cancelled");
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
public int rankingStudents(String studentId, Question question) {
    int rank = 1;
    int studentMark = 0;

    for (Student student : students) {
        if (student.getUniversityId().equals(studentId)) {
            studentMark = question.getRealMark();
            break;
        }
    }

    for (Student student : students) {
        if (!student.getUniversityId().equals(studentId) && question.getRealMark() > studentMark) {
            rank++;
        }
    }

    return rank;
}

}
