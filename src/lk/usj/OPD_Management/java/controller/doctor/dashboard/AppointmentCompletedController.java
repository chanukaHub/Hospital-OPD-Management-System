package lk.usj.OPD_Management.java.controller.doctor.dashboard;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class AppointmentCompletedController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label appointmentIdLabel;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) throws Exception {
        appointmentBO.completeAppointment(appointmentIdLabel.getText());
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void transferMessage(AppointmentDTO appointmentDTO) {
        appointmentIdLabel.setText(appointmentDTO.getAppointmentId());

    }
}
