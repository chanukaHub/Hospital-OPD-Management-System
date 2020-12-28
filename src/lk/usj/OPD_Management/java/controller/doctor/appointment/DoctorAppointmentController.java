package lk.usj.OPD_Management.java.controller.doctor.appointment;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

