package lk.usj.OPD_Management.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/Login.fxml"));
        Scene scene =new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("Login");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
