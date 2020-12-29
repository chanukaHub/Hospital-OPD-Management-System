package lk.usj.OPD_Management.java.controller.patient.appointment;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class PatientAppointmentController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
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
    void appointmentTable_MouseEvent(MouseEvent event) {

    }

    private void loadThisPatientAppointmentTable() throws Exception {

        appointmentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        appointmentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        appointmentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        appointmentTable.setItems(FXCollections.observableArrayList(appointmentBO.getAppointmentListUsingPatientUsername(patientUsername)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadThisPatientAppointmentTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
