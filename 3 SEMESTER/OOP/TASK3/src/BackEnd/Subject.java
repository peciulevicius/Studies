package BackEnd;

import javafx.beans.property.*;

public class Subject {

    private StringProperty subjectName;
    private FloatProperty subjectGrades;
    private IntegerProperty subjectCredits;

    public Subject(){
        this("", 0);
    }

    public Subject(String subjectName, Integer subjectCredits){
        this.subjectName = new SimpleStringProperty(subjectName);
        this.subjectCredits = new SimpleIntegerProperty(subjectCredits);
    }

    public StringProperty getSubjectName(){
        return subjectName;
    }

    public void setSubjectName(String subjectName){
        this.subjectName.set(subjectName);
    }

    public StringProperty subjectNameProperty() {
        return subjectName;
    }

    public FloatProperty getSubjectGrade(){
        return subjectGrades;
    }

    public void setSubjectGrade(float subjectGrade){
        this.subjectGrades.set(subjectGrade);
    }

    public FloatProperty subjectGradesProperty() {
        return subjectGrades;
    }

    public IntegerProperty getSubjectCredits(){
        return subjectCredits;
    }

    public void setSubjectCredits(int subjectCredits){
        this.subjectCredits.set(subjectCredits);
    }

    public IntegerProperty subjectCreditsProperty() {
        return subjectCredits;
    }

}
