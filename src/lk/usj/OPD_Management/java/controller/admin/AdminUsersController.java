package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class AdminUsersController implements Initializable {
    String selectedUserType= "Patient";

    @FXML
    private VBox mainRoot;

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
    void doctorBtn_MouseEvent(MouseEvent event) throws IOException{
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        doctorBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        patientBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");

        selectedUserType= "Doctor";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_user_doctor_table.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void patientBtn_MouseEvent(MouseEvent event) throws IOException {
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");

        selectedUserType= "Patient";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_Patient_table.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void receptionistBtn_MouseEvent(MouseEvent event) {
        patientBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().removeAll("selected_login_type_btn");

        receptionistBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        patientBtn_AnchorPane.getStyleClass().add("login_type_btn");

        selectedUserType= "Receptionist";
    }

    @FXML
    void editBtn_ActionEvent(ActionEvent event) {

    }

    @FXML
    void addBtn_ActionEvent(ActionEvent event) throws IOException{
        if (selectedUserType.equals("Patient")){
            VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_addPatient.fxml"));
            mainRoot.getChildren().setAll(pane);
        }else if (selectedUserType.equals("Doctor")){
            VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_addDoctor.fxml"));
            mainRoot.getChildren().setAll(pane);
        }else if (selectedUserType.equals("Receptionist")){
            VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_addReceptionist.fxml"));
            mainRoot.getChildren().setAll(pane);
        }

    }

    @FXML
    void deleteBtn_ActionEvent(ActionEvent event) {

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        patientBtn_AnchorPane.getStyleClass().add("selected_login_type_btn");
        doctorBtn_AnchorPane.getStyleClass().add("login_type_btn");
        receptionistBtn_AnchorPane.getStyleClass().add("login_type_btn");
        Pane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_Patient_table.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().setAll(pane);

    }
}
