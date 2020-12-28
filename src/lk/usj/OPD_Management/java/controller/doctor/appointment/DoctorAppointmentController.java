package lk.usj.OPD_Management.java.controller.doctor.appointment;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class DoctorAppointmentController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
    public static String doctorUserName;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<AppointmentDTO> appointmentTable;

    private void loadThisDoctorAppointmentTable() throws Exception {

        appointmentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        appointmentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientUsername"));
        appointmentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        appointmentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("status"));
        appointmentTable.setItems(FXCollections.observableArrayList(appointmentBO.loadThisDoctorAppointmentTable(doctorUserName)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadThisDoctorAppointmentTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

