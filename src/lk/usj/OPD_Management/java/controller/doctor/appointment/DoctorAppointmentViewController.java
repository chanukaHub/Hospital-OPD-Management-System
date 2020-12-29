package lk.usj.OPD_Management.java.controller.doctor.appointment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;

public class DoctorAppointmentViewController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label patientNameLabel;

    @FXML
    private Label patientUsernameLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private JFXTextField symptomsTextField;

    @FXML
    private JFXButton okBtn;

    @FXML
    void okBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(AppointmentDTO appointmentDTO) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(appointmentDTO.getAppointmentDate());

        patientNameLabel.setText(appointmentDTO.getPatientName());
        patientUsernameLabel.setText(appointmentDTO.getPatientUsername());
        phoneNumberLabel.setText(appointmentDTO.getPatientPhone());
        dateLabel.setText(strDate);
        timeLabel.setText(appointmentDTO.getAppointmentTime());
        statusLabel.setText(appointmentDTO.getStatus());
        symptomsTextField.setText(appointmentDTO.getSymptoms());


    }
}
