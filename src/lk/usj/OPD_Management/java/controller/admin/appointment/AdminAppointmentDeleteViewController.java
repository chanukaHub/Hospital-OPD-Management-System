package lk.usj.OPD_Management.java.controller.admin.appointment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class AdminAppointmentDeleteViewController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
    String appointmentId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label patientNameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label phoneNoLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label timeLabel;

    @FXML
    private JFXTextField symptomsTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) {
        boolean deleted = false;
        try {
            deleted = appointmentBO.deleteAppointment(appointmentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (deleted) {
            Common.showMessage("DELETE !");
        }

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(AppointmentDTO appointmentDTO) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(appointmentDTO.getAppointmentDate());

        appointmentId = appointmentDTO.getAppointmentId();
        patientNameLabel.setText(appointmentDTO.getPatientName());
        usernameLabel.setText(appointmentDTO.getPatientUsername());
        phoneNoLabel.setText(appointmentDTO.getPatientPhone());
        doctorNameLabel.setText(appointmentDTO.getDoctorName());
        dateLabel.setText(strDate);
        timeLabel.setText(appointmentDTO.getAppointmentTime());
        symptomsTextArea.setText(appointmentDTO.getSymptoms());
        statusLabel.setText(appointmentDTO.getStatus());
    }
}
