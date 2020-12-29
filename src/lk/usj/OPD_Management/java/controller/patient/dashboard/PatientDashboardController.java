package lk.usj.OPD_Management.java.controller.patient.dashboard;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class PatientDashboardController implements Initializable {
    private PatientBO patientBO=new PatientBOImpl();
    public static String patientUsername;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<AppointmentDTO> appointmentTable;

    @FXML
    private TableView<ComplaintDTO> complaintTable;

    @FXML
    private JFXButton addNewAppointmentBtn;

    @FXML
    private JFXButton addNewComplaint;

    @FXML
    void addNewAppointmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void addNewComplaint_OnAction(ActionEvent event) {

    }

    @FXML
    void appointmentTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void complaintTable_MouseEvent(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
