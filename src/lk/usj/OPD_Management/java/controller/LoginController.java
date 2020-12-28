package lk.usj.OPD_Management.java.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.common.tool.ButtonFireForEnterSetter;
import lk.usj.OPD_Management.java.common.tool.GlobalBoolean;
import lk.usj.OPD_Management.java.controller.admin.AdminBaseController;
import lk.usj.OPD_Management.java.controller.doctor.DoctorBaseController;
import lk.usj.OPD_Management.java.controller.doctor.appointment.DoctorAppointmentController;
import lk.usj.OPD_Management.java.controller.doctor.dashboard.DoctorDashboardController;
import lk.usj.OPD_Management.java.controller.patient.PatientBaseController;
import lk.usj.OPD_Management.java.controller.receptionist.ReceptionistBaseController;
import lk.usj.OPD_Management.java.dto.*;
import lk.usj.OPD_Management.java.service.BOFactory;
import lk.usj.OPD_Management.java.service.custom.LoginBO;

public class LoginController implements Initializable{

    private LoginBO loginBO;
    String userType="Patient";

    @FXML
    private HBox root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox patientBtn;

    @FXML
    private HBox doctorBtn;

    @FXML
    private HBox receptionistBtn;

    @FXML
    private HBox adminBtn;

    @FXML
    private JFXTextField usernameTxt1;

    @FXML
    private JFXPasswordField passwordTxt1;

    @FXML
    private JFXButton loginButton1;

    @FXML
    void ReceptionistClick(MouseEvent event) {
        patientBtn.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn.getStyleClass().removeAll("selected_login_type_btn");
        adminBtn.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn.getStyleClass().add("login_type_btn");
        doctorBtn.getStyleClass().add("login_type_btn");
        receptionistBtn.getStyleClass().add("selected_login_type_btn");
        adminBtn.getStyleClass().add("login_type_btn");

        userType = "Receptionist";
    }

    @FXML
    void adminClick(MouseEvent event) {
        patientBtn.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn.getStyleClass().removeAll("selected_login_type_btn");
        adminBtn.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn.getStyleClass().add("login_type_btn");
        doctorBtn.getStyleClass().add("login_type_btn");
        receptionistBtn.getStyleClass().add("login_type_btn");
        adminBtn.getStyleClass().add("selected_login_type_btn");

        userType = "Admin";

    }

    @FXML
    void doctorClick(MouseEvent event) {
        patientBtn.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn.getStyleClass().removeAll("selected_login_type_btn");
        adminBtn.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn.getStyleClass().add("login_type_btn");
        doctorBtn.getStyleClass().add("selected_login_type_btn");
        receptionistBtn.getStyleClass().add("login_type_btn");
        adminBtn.getStyleClass().add("login_type_btn");

        userType = "Doctor";
    }

    @FXML
    void patientClick(MouseEvent event) {
        patientBtn.getStyleClass().removeAll("selected_login_type_btn");
        doctorBtn.getStyleClass().removeAll("selected_login_type_btn");
        receptionistBtn.getStyleClass().removeAll("selected_login_type_btn");
        adminBtn.getStyleClass().removeAll("selected_login_type_btn");

        patientBtn.getStyleClass().add("selected_login_type_btn");
        doctorBtn.getStyleClass().add("login_type_btn");
        receptionistBtn.getStyleClass().add("login_type_btn");
        adminBtn.getStyleClass().add("login_type_btn");

        userType = "Patient";
    }

    @FXML
    void usernameTxt1_onAction(ActionEvent event){
        passwordTxt1.requestFocus();
    }

    @FXML
    void passwordTxt1_onAction(ActionEvent event){
        loginButton1_onAction(event);
    }

    @FXML
    void loginButton1_onAction(ActionEvent event){
        try {
            if (userType.equals("Admin")){
                if (loginBO.isValidAdminPassword(new AdminDTO(usernameTxt1.getText(), passwordTxt1.getText()))) {
                    try {
                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_base.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        AdminBaseController adminBaseController = loader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        adminBaseController.transferMessage(usernameTxt1.getText());

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Admin Dashboard");
                        stage.centerOnScreen();
                        stage.setResizable(false);
                        //stage.setMaximized(true);
                        stage.show();

                        ((Node)(event.getSource())).getScene().getWindow().hide();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Common.showError("Invalid Email name or password.");
                }
            }else if (userType.equals("Receptionist")){
                if (loginBO.isValidReceptionistPassword(new ReceptionistDTO(usernameTxt1.getText(), passwordTxt1.getText()))) {
                    try {
                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_base.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        ReceptionistBaseController receptionistBaseController = loader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        receptionistBaseController.transferMessage(usernameTxt1.getText());

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Receptionist Dashboard");
                        stage.centerOnScreen();
                        stage.setResizable(false);
                        //stage.setMaximized(true);
                        stage.show();

                        ((Node)(event.getSource())).getScene().getWindow().hide();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Common.showError("Invalid Email name or password.");
                }
            }else if (userType.equals("Patient")){
                if (loginBO.isValidPatientPassword(new PatientDTO(usernameTxt1.getText(), passwordTxt1.getText()))) {
                    try {
                        //Load second scene
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_base.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        PatientBaseController patientBaseController = loader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        patientBaseController.transferMessage(usernameTxt1.getText());

                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Patient Dashboard");
                        stage.centerOnScreen();
                        stage.setResizable(false);
                        //stage.setMaximized(true);
                        stage.show();

                        ((Node)(event.getSource())).getScene().getWindow().hide();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    Common.showError("Invalid Email name or password.");
                }
            }else if (userType.equals("Doctor")){
                if (loginBO.isValidDoctorPassword(new DoctorDTO(usernameTxt1.getText(), passwordTxt1.getText()))) {
                    try {
                      //Load second scene
                        DoctorDashboardController.doctorUserName = usernameTxt1.getText();
                        DoctorAppointmentController.doctorUserName= usernameTxt1.getText();
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/doctor/doctor_base.fxml"));
                        Parent root = loader.load();

                        //Get controller of scene2
                        DoctorBaseController doctorBaseController = loader.getController();
                        //Pass whatever data you want. You can have multiple method calls here
                        doctorBaseController.transferMessage(usernameTxt1.getText());



                        Stage stage = new Stage();
                        stage.setScene(new Scene(root));
                        stage.setTitle("Doctor Dashboard");
                        stage.centerOnScreen();
                        stage.setResizable(false);
                        //stage.setMaximized(true);
                        stage.show();


                        ((Node)(event.getSource())).getScene().getWindow().hide();


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Common.showError("Invalid Email name or password.");
                }
            }


            else{
                Common.showError("Invalid User Type");
            }





        } catch (NullPointerException e) {
            Common.showMessage("This Email is no longer available.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        patientBtn.getStyleClass().add("selected_login_type_btn");
        doctorBtn.getStyleClass().add("login_type_btn");
        receptionistBtn.getStyleClass().add("login_type_btn");
        adminBtn.getStyleClass().add("login_type_btn");


        GlobalBoolean.setLock(false);
        ButtonFireForEnterSetter.setGlobalEventHandler(root);
        usernameTxt1.clear();
        passwordTxt1.clear();
        loginBO = BOFactory.getInstance().getBO(BOFactory.BOTypes.LOG_IN);

        FadeTransition fade = new FadeTransition(Duration.seconds(3), root);

        fade.setFromValue(0);
        fade.setToValue(2);
        fade.play();
    }
}

