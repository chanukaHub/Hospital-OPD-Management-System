package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class ReceptionistDashboardSaveAppointmentController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField patientNameTextField;

    @FXML
    private JFXButton patientSearchBtn;

    @FXML
    private JFXTextField patientNICNoTextField;

    @FXML
    private JFXTextField patientPhoneNo;

    @FXML
    private JFXDatePicker appointmentDateDatePicker;

    @FXML
    private JFXTimePicker appointmentTimeTimePicker;

    @FXML
    private JFXComboBox<String> specialistAreaComboBox;

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
    void appointmentTimeTimePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void doctorTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void patientNICNoTextField_OnAction(ActionEvent event) {

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
    void saveBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void specialistAreaComboBox_OnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        specialistAreaComboBox.getItems().addAll(
                "Choose",
                "Psychiatrist",
                "Surgeon",
                "Cardiologist",
                "Dermatologist",
                "Endocrinologist",
                "Gastroenterologist",
                "Oncologist",
                "Radiologist"
        );
        specialistAreaComboBox.getSelectionModel().selectFirst();
    }
}
