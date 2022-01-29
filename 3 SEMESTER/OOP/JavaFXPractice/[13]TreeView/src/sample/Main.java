package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage window;
    //root -> branches -> other branches -> leaf
    TreeView<String> tree;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        window.setTitle("Tree View");

        //root and branches
        TreeItem<String> root, bucky, megan;

        //ROOT
        root = new TreeItem<>(); //Container for all our branches
        root.setExpanded(true); //setting everything to expanded by default

        //Bucky
        //                ("name", parent)
        bucky = makeBranch("Bucky", root);
        makeBranch("guns", bucky);
        makeBranch("cars", bucky);
        makeBranch("Chicken", bucky);
        makeBranch("Youtube", bucky);

        //Megan
        megan = makeBranch("Megan", root);
        makeBranch("makeup", megan);
        makeBranch("glitter", megan);

        //Create tree
        tree = new TreeView<>(root);
        //setShowRoot - false.   If if did not set to false then we would need to expand root to see others roots
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> { //everything will be printed when clicked
                    if(newValue != null)
                        System.out.println(newValue.getValue());
                });

        //Layout
        StackPane layout = new StackPane();
        layout.getChildren().add(tree);
        window.setScene(new Scene(layout, 300, 275));
        window.show();
    }

    //Create branches
    public TreeItem<String> makeBranch(String title, TreeItem<String> parent){
        TreeItem<String> item = new TreeItem<>(title); //when it takes for example guns , cars, Chicken, it will make new list item
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item; //returning branch
    }


    public static void main(String[] args) {
        launch(args);
    }
}
