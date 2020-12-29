package lk.usj.OPD_Management.java.controller.patient.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PatientDashboardSaveAppointmentController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXTextField patientUsernameTextField;

    @FXML
    private JFXButton patientSearchBtn;

    @FXML
    private JFXTextField patientNameTextField;

    @FXML
    private JFXTextField patientPhoneNo;

    @FXML
    private JFXDatePicker appointmentDateDatePicker;

    @FXML
    private JFXComboBox<?> timeComboBox;

    @FXML
    private JFXComboBox<?> specialistAreaComboBox;

    @FXML
    private TableView<?> doctorTable;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private JFXTextArea symptomsTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void appointmentDateDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void doctorTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void patientNameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void patientPhoneNo_OnAction(ActionEvent event) {

    }

    @FXML
    void patientSearchBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void patientUsernameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void specialistAreaComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void timeComboBox_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
