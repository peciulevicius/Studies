package Controllers;

import BackEnd.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.*;

public class SecondaryScreen {
    @FXML
    private ObservableList<Group> groupList = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Student> studentList = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Subject> subjectList = FXCollections.observableArrayList();
    @FXML
    private TableView<Student> studentTableView;
    @FXML
    private TableColumn<Student, String> studentNameColumn;
    @FXML
    private TableColumn<Student, String> studentSurnameColumn;
    @FXML
    private TableView<Subject> subjectTableView;
    @FXML
    private TableColumn<Subject, String> subjectsColumn;
    @FXML
    private TableColumn<Subject, Integer> creditsColumn;
    @FXML
    private Button addGroupButton;
    @FXML
    private TextField studentSurnameInput;
    @FXML
    private TextField subjectCreditsInput;
    @FXML
    private TextField studentNameInput;
    @FXML
    private TextField groupField;
    @FXML
    private TextField semester;
    @FXML
    private TextField subjectNameInput;
    @FXML
    private Button addStudentButton;
    @FXML
    private Button confirmSelectionButton;
    @FXML
    private ListView<Student> top3List;
    @FXML
    private Label studentGradesOutput;
    @FXML
    private Button deleteSubjectButton;
    @FXML
    private ComboBox<Group> groupSelect;
    @FXML
    private ComboBox<Student> studentSelect;
    @FXML
    private ComboBox<Subject> subjectSelect;
    @FXML
    private ChoiceBox<Student> gradeSelect;
    @FXML
    private Button deleteStudentButton;
    @FXML
    private Label studentAverageOutput;
    @FXML
    private TextField gradeInput;
    @FXML
    private Button addSubjectButton;
    @FXML
    private Button deleteGradeButton;
    @FXML
    private Label groupAverageOutput;
    @FXML
    private Button exitButton;
    @FXML
    private Button addGradeButton;
    @FXML
    private Button clearFieldsButton;

    @FXML
    void initialize(){
        groupSelect.setPromptText("Group Name");
        studentSelect.setPromptText("Student Name");
        subjectSelect.setPromptText("Subject");
    }

    @FXML
    void deleteStudentAction(ActionEvent event) {
        try {
            Student student = studentTableView.getSelectionModel().getSelectedItem();
            if (student!=null) {
                studentList.remove(student);

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("LIST EMPTY");
                alert.setContentText("Your list is empty. There is nothing to remove!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println("Error/List is empty");
        }
    }

    @FXML
    void addStudentAction(ActionEvent event) {
        if (studentNameInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY STUDENT NAME FIELD");
            alert.setContentText("CHECK and FILL student name field!");
            alert.showAndWait();
        } if (studentSurnameInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY STUDENT SURNAME FIELD");
            alert.setContentText("CHECK and FILL student surname field!");
            alert.showAndWait();
        } else{
            if (studentList.size() < 30) {
                Student student = new Student();
                student.setStudentName(studentNameInput.getText());
                student.setStudentSurname(studentSurnameInput.getText());

                studentTableView.setItems(studentList);
                studentList.add(student);

                studentNameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentName"));
                studentSurnameColumn.setCellValueFactory(new PropertyValueFactory<Student, String>("studentSurname"));

                studentNameInput.clear();
                studentSurnameInput.clear();

                System.out.println(studentList);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("LIST IS FULL");
                alert.setContentText("You can only have maximum of 30 students per group!");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void deleteSubjectAction(ActionEvent event) {
        try {
            Subject subject = subjectTableView.getSelectionModel().getSelectedItem();
            if (subject!=null) {
                subjectList.remove(subject);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("LIST EMPTY");
                alert.setContentText("Your list is empty. There is nothing to remove!");
                alert.showAndWait();
            }
        } catch (Exception e) {
            System.out.println("Error/List is empty");
        }
    }

    @FXML
    void addSubjectAction(ActionEvent event) {
        if (subjectNameInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY SUBJECT NAME FIELD");
            alert.setContentText("CHECK and FILL subject name field!");
            alert.showAndWait();
        }
        if (subjectCreditsInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY SUBJECT CREDIT FIELD");
            alert.setContentText("CHECK and FILL subject credit field!");
            alert.showAndWait();
        } else {
            if (subjectList.size() < 6) {
                Subject subject = new Subject();

                subject.setSubjectName(subjectNameInput.getText());
                subject.setSubjectCredits(Integer.parseInt(subjectCreditsInput.getText()));
                subjectList.add(subject);

                subjectTableView.setItems(subjectList);

                subjectsColumn.setCellValueFactory(new PropertyValueFactory<Subject, String>("subjectName"));
                creditsColumn.setCellValueFactory(new PropertyValueFactory<Subject, Integer>("subjectCredits"));

                subjectNameInput.clear();
                subjectCreditsInput.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("LIST IS FULL");
                alert.setContentText("You can only have maximum of 6 subjects per group!");
                alert.showAndWait();
            }
        }
    }
    @FXML
    void clearFieldsAction(ActionEvent event) {
        groupField.clear();
        semester.clear();
        studentNameInput.clear();
        studentSurnameInput.clear();
        subjectNameInput.clear();
        subjectCreditsInput.clear();
    }

    @FXML
    void addGroupAction(ActionEvent event) throws FileNotFoundException, IOException {
        if (groupField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY GROUP FIELD");
            alert.setContentText("CHECK and FILL group field!");
            alert.showAndWait();
        } if (semester.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY SEMESTER FIELD");
            alert.setContentText("CHECK and FILL semester field!");
            alert.showAndWait();
        } if (studentList.size() <= 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY STUDENT LIST");
            alert.setContentText("CHECK and FILL student list!");
            alert.showAndWait();
        } if (subjectList.size() <= 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("EMPTY SUBJECT LIST");
            alert.setContentText("CHECK and FILL subject list!");
            alert.showAndWait();
        } else {
            Group group = new Group();

            group.setGroupName(groupField.getText());
            group.setSemester(Integer.parseInt(semester.getText()));
            group.setSubjectList(subjectList);
            group.setStudentList(studentList);

            groupList.add(toString(group));
            groupSelect.setItems(groupList);

            groupField.clear();
            semester.clear();
            studentList.clear();
            subjectList.clear();
            System.out.println(subjectList);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("GROUP HAS BEEN ADDED");
            alert.setHeaderText(null);
            alert.setContentText("New group has been successfully added!");
            alert.showAndWait();
        }
    }

    private Group toString(Group groupName) {
        return groupName;
    }

    @FXML
    void groupSelectAction(ActionEvent event) {
        groupSelect.getSelectionModel().selectedItemProperty().addListener( (v, oldValue, newValue) -> {
                studentSelect.setItems(studentList);
        });

    }

    @FXML
    void studentSelectAction(ActionEvent event) {

    }

    @FXML
    void subjectSelectAction(ActionEvent event) {

    }

    @FXML
    void confirmSelectionAction(ActionEvent event) {

    }

    @FXML
    void deleteGradeAction(ActionEvent event) {

    }

    @FXML
    void addGradeAction(ActionEvent event) {

    }

    @FXML
    void exitButtonAction(ActionEvent event) {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}