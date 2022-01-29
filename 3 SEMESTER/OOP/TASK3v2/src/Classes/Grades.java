package Classes;

public class Grades {
    //reference to setGrade method in studentGradesController
    public Subject subject;
    private double grade;

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
