package com.mycompany.java2project;

import Questions.FillTheBlankQuestion;
import Questions.MCQuestion;
import Questions.Question;
import Questions.TrueFalseQuestion;

/**
 *
 * @author Atef
 */
public class Utils {

    public static void addMembers() {
        Person.teachers.add(new Teacher(2000, "Eng", "JafarAgha", "112233", "1/1/1997", true, "Jafar Al-Agha"));
        Person.teachers.add(new Teacher(1000, "Eng", "MohDalo", "112233", "1/1/1998", true, "Mohammed Al-Dalo"));
        Person.teachers.add(new Teacher(3000, "Eng", "EtafHadda", "112233", "1/1/1999", false, "Etaf Abu Hadda"));
        Person.teachers.add(new Teacher(1500, "IT", "HashemSaqqa", "112233", "1/1/2000", true, "Hashem Al-Saqqa"));

        Person.students.add(new Student("s1", "123456", "Ahmed Ali", "120180001", "1/1/2000", true));
        Person.students.add(new Student("s2", "123456", "Heba Ahmed", "120190001", "1/1/2001", false));
        Person.students.add(new Student("s3", "123456", "Dalia Mohammed ", "120200001", "1/1/2002", false));
    }

    public static void addQuestions() {
        Questions.Question.questions.add(new TrueFalseQuestion("Does Java can build GUI?", "Yes", 2));
        Questions.Question.questions.add(new TrueFalseQuestion("Java doesn't support OOP?", "No", 2));

        Questions.Question.questions.add(new MCQuestion(2, "Which Type is not primitive", new String[]{"String", "int", "double", "char"}, 0));
        Questions.Question.questions.add(new MCQuestion(2, "Which class is super class for all classes", new String[]{"String", "Object", "Number", "Exception"}, 1));

        Questions.Question.questions.add(new FillTheBlankQuestion("What is the keywords that used to call super class constructor?", "super", 2));
        Questions.Question.questions.add(new FillTheBlankQuestion("What is the keywords that used to inherit from a class?", "extends", 2));
    }
    public static void addExams() {
       Exam exam = new Exam("Biology",5,5,2);
    }
}
