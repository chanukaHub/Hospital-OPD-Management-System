package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AdminUsersController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane patientBtn_AnchorPane;

    @FXML
    private AnchorPane doctorBtn_AnchorPane;

    @FXML
    private AnchorPane receptionistBtn_AnchorPane;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton addBtn;

    @FXML
    private JFXButton editBtn;

    @FXML
    private JFXButton deleteBtn;




    @FXML
    void doctorBtn_MouseEvent(MouseEvent event) {
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        doctorBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        patientBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");
    }

    @FXML
    void patientBtn_MouseEvent(MouseEvent event) {
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");
    }

    @FXML
    void receptionistBtn_MouseEvent(MouseEvent event) {
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        receptionistBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        patientBtn_AnchorPane.getStyleClass().add("login_type_btn");
    }

    @FXML
    void editBtn_ActionEvent(ActionEvent event) {

    }

    @FXML
    void addBtn_ActionEvent(ActionEvent event) {

    }

    @FXML
    void deleteBtn_ActionEvent(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        patientBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");
    }
}
