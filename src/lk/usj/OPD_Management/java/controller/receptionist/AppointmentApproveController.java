package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class AppointmentApproveController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label appointmentIDLabel;

    @FXML
    private Label appointmentNoLabel;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(AppointmentDTO appointmentDTO) {
        int appointmentNo = 0;
        appointmentIDLabel.setText(appointmentDTO.getAppointmentId());
        try {
            appointmentNo = appointmentBO.getNextAppointmentNo(appointmentDTO.getDoctorUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        appointmentNoLabel.setText(String.valueOf(appointmentNo));
    }
}
