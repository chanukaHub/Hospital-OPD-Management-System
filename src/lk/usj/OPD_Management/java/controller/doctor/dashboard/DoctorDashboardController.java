package lk.usj.OPD_Management.java.controller.doctor.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.receptionist.appointment.AppointmentApproveController;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class DoctorDashboardController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
    public static String doctorUserName;

    @FXML
    private VBox root;

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
    void upcomingAppointmentTable_MouseEvent(MouseEvent event) throws Exception{
        AppointmentDTO appointmentDTO=(upcomingAppointmentTable.getSelectionModel().getSelectedItem());
        if(appointmentDTO == null){
            Common.showWarning("Please select Appointment records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/doctor/appointments_completed.fxml"));
        Parent root = loader.load();
        AppointmentCompletedController appointmentCompletedController = loader.getController();
        appointmentCompletedController.transferMessage(appointmentDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/doctor/doctor_dashboard.fxml"));
        this.root.getChildren().setAll(pane);

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
