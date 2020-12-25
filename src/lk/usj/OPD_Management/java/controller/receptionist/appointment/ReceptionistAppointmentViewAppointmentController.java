package lk.usj.OPD_Management.java.controller.receptionist.appointment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;

public class ReceptionistAppointmentViewAppointmentController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label appointmentNoLabel;

    @FXML
    private Label patientNameLabel;

    @FXML
    private Label patientUsernameLabel;

    @FXML
    private Label patientPhoneLabel;

    @FXML
    private Label appointmentStatus;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private JFXTextArea symptomTextArea;

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
        appointmentNoLabel.setText(String.valueOf(appointmentDTO.getAppointmentNo()));
        patientNameLabel.setText(appointmentDTO.getPatientName());
        patientUsernameLabel.setText(appointmentDTO.getPatientUsername());
        patientPhoneLabel.setText(appointmentDTO.getPatientPhone());
        appointmentStatus.setText(appointmentDTO.getStatus());
        doctorNameLabel.setText(appointmentDTO.getDoctorName());
        dateLabel.setText(strDate);
        timeLabel.setText(appointmentDTO.getAppointmentTime());
        symptomTextArea.setText(appointmentDTO.getSymptoms());
    }
}
