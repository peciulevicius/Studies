//Write a program that calculates student grade average considering the number of credits.
//MAIN REQUIREMENTS:
//-Program has to let us insert student data (name, surname, group) and his lectures passed (subject name, evaluation, credit number)
//-Program has to print full student information and calculated average value
//
//EXTRA REQUIREMENT: program architecture has to have single responsibility

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Student studentRecord = new Student();

        System.out.println("Enter your name: ");
        String inputName = input.nextLine();
        studentRecord.setStudentName(inputName);

        System.out.println("Enter your surname: ");
        String inputSurname = input.nextLine();
        studentRecord.setStudentSurname(inputSurname);

        System.out.println("Enter your group: ");
        String inputGroup = input.nextLine();
        studentRecord.setStudentGroup(inputGroup);

        System.out.println("Enter the amount of subjects you are taking this semester: ");
        int numberOfSubjects = input.nextInt();
        studentRecord.setNumberOfSubjects(numberOfSubjects);

        for (int i = 1; i <= numberOfSubjects; i++) {
            studentRecord.subjectList[i] = new Subject();
            System.out.println("Enter the name of a subject #" + i + ":");
            String inputSubjectName = input.next();
            studentRecord.subjectList[i].setSubjectName(inputSubjectName);

            System.out.println("Enter the grade of a subject #" + i + ":");
            float inputSubjectGrade = input.nextFloat();
            studentRecord.subjectList[i].setSubjectGrade(inputSubjectGrade);

            System.out.println("Enter the credit number of a subject #" + i + ":");
            int inputSubjectCredits = input.nextInt();
            studentRecord.subjectList[i].setSubjectCredits(inputSubjectCredits);
        }

        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.println("\nSubject name: " + studentRecord.subjectList[i].getSubjectName());
            System.out.println("Subject grade: " + studentRecord.subjectList[i].getSubjectGrade());
            System.out.println("Subject credits: " + studentRecord.subjectList[i].getSubjectCredits());
        }


        System.out.println("\nYOUR STUDENT INFORMATION: ");
        System.out.println("Name: " + studentRecord.getStudentName());
        System.out.println("Surname: " + studentRecord.getStudentSurname());
        System.out.println("Group: " + studentRecord.getStudentGroup());
        System.out.println("Average GPA: " + studentRecord.getGPA());
    }
}