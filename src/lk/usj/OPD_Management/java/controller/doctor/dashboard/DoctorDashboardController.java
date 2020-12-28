package lk.usj.OPD_Management.java.controller.doctor.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class DoctorDashboardController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
    public static String doctorUserName;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Text pendingCountText;

    @FXML
    private Text approvedCountText;

    @FXML
    private Text completedCountText;

    @FXML
    private TableView<AppointmentDTO> upcomingAppointmentTable;

    @FXML
    void upcomingAppointmentTable_MouseEvent(MouseEvent event) {

    }

    private void loadUpcomingAppointmentTable() throws Exception {
        //System.out.println(doctorUserName);
        upcomingAppointmentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        upcomingAppointmentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientUsername"));
        upcomingAppointmentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        upcomingAppointmentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        upcomingAppointmentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        upcomingAppointmentTable.setItems(FXCollections.observableArrayList(appointmentBO.getApprovedAppointmentListUsingDoctorUsername(doctorUserName)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadUpcomingAppointmentTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
