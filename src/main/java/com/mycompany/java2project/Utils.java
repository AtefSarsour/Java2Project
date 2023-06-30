package com.mycompany.java2project;


import java.util.ArrayList;

public class Utils {

    public static ArrayList<Person> persons = new ArrayList();

    public static ArrayList<com.mycompany.java2project.Question> questions = new ArrayList();

// this line is to inform you that Github is working! :)
// no i want to make sure that github is working
// no i want to make sure that github is working 
    public static void addMembers() {

        Person.teachers.add(new Teacher(2000, "Eng", "JafarAgha", "112233", "1/1/1997", true, "Jafar Al-Agha"));
        Person.teachers.add(new Teacher(1000, "Eng", "MohDalo", "112233", "1/1/1998", true, "Mohammed Al-Dalo"));
        Person.teachers.add(new Teacher(3000, "Eng", "EtafHadda", "112233", "1/1/1999", false, "Etaf Abu Hadda"));
        Person.teachers.add(new Teacher(1500, "IT", "HashemSaqqa", "112233", "1/1/2000", true, "Hashem Al-Saqqa"));

        Person.students.add(new Student("s1", "123456", "Ahmed Ali", "120180001", "1/1/2000", true));
        Person.students.add(new Student("s2", "123456", "Heba Ahmed", "120190001", "1/1/2001", false));
        Person.students.add(new Student("s3", "123456", "Dalia Mohammed ", "120200001", "1/1/2002", false));
        persons.add(Admin.addAdmin("admin", "admin", "Admin", "1/1/2000", true, 9999));
        persons.addAll(Person.teachers);
        persons.addAll(Person.students);
    }

    public static void addQuestions() {
        questions.add(new TrueFalseQuestion("Does Java can build GUI?", "Yes", 2));
        questions.add(new TrueFalseQuestion("Java doesn't support OOP?", "No", 2));

        questions.add(new MCQuestion(2, "Which Type is not primitive", new String[]{"String", "int", "double", "char"}, 0));
        questions.add(new MCQuestion(2, "Which class is super class for all classes", new String[]{"String", "Object", "Number", "Exception"}, 1));

        questions.add(new FillTheBlankQuestion("What is the keywords that used to call super class constructor?", "super", 2));
        questions.add(new FillTheBlankQuestion("What is the keywords that used to inherit from a class?", "extends", 2));
    }

    public static void addExams() {
        Exam exam = new Exam("Biology", 2, 2, 2);
        Exam exam2 = new Exam("Chemistry", 2, 2, 1);
        Exam exam3 = new Exam("Arabic", 2, 2, 3);
    }
//____________________________________________________________________________________________________________________________________

    public static boolean validateLogin(String userName, String password) {
        String userType = null;
        for (Person p : Utils.persons) {
            if (userName.equals(p.getUserName())) {
                if (password.equals(p.getPassword())) {
                    if (isAdmin(p)) {
                        userType = "Admin";
                    } else if (isTeacher(p)) {
                        userType = "Teacher";
                    } else if (isStudent(p)) {
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

    private static boolean isAdmin(Person p) {
        return p.getClass().equals(Admin.class);
    }

    private static boolean isTeacher(Person p) {
        return p.getClass().equals(Teacher.class);
    }

    private static boolean isStudent(Person p) {
        return p.getClass().equals(Student.class);
    }
//____________________________________________________________________________________________________________________________________
        
        

    public static void chooseExamToSolve() {
        for (int i = 0; i < Exam.exams.size(); i++) {
            Exam exam = Exam.exams.get(i);
            System.out.println("* Exam (" + exam.getId() + ")\nExam name: " + exam.examName + "\nnumOfQuestions: " + exam.numOfQuestions + "\npassGrade: " + exam.passGrade + "\nquestionType: " + exam.questionType + " *\n");
       
        }
    }
}


