package BackEnd;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    private StringProperty studentName;
    private StringProperty studentSurname;
    //private StringProperty studentName = new SimpleStringProperty(this, "studentName", "");


    //refering to the object
    public Student(){
        this("", "");
    }

    //to create new string properties to read and write to
    public Student(String studentName, String studentSurname){
        this.studentName = new SimpleStringProperty(studentName);
        this.studentSurname = new SimpleStringProperty(studentSurname);
    }


    public StringProperty getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName.set(studentName);
    }

    public StringProperty studentNameProperty() {
        return studentName;
    }

    public StringProperty getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname.set(studentSurname);
    }

    public StringProperty studentSurnameProperty() {
        return studentSurname;
    }

/*
    public float getGPA() {
        float x = 0;
        float y = 0;

        for (int i = 1; i <= subjectGrades; i++) {
            x = x + subjectList[i].getSubjectCredits() * subjectList[i].getSubjectGrade();
            y = y + subjectList[i].getSubjectCredits();
        }
        return x / y;
    }*/
}