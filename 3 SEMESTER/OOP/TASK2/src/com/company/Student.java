package com.company;

public class Student {
    private String studentName;
    private String studentSurname;
    private String studentGroup;
    private int numberOfSubjects;
    Subject[] subjectList = new Subject[10];

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public void setNumberOfSubjects(int numberOfSubjects) {
        this.numberOfSubjects = numberOfSubjects;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public float getGPA() {
        float x = 0;
        float y = 0;

        /*
        //---THIS LOOP WORKS FINE---//
        for (int i = 1; i <= numberOfSubjects; i++) {
            x = x + subjectList[i].getSubjectCredits() * subjectList[i].getSubjectGrade();
            y = y + subjectList[i].getSubjectCredits();
        }
        return x / y;
        */

        //---THIS LOOP DOES NOT WORK---//

        for (Subject s : subjectList) {
            x = x + s.getSubjectCredits() * s.getSubjectGrade();
            y = y + s.getSubjectCredits();
        }
        return x / y;
    }
}