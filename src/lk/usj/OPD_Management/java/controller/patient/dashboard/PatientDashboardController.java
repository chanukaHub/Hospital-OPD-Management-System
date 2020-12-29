package lk.usj.OPD_Management.java.controller.patient.dashboard;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.controller.doctor.dashboard.AppointmentCompletedController;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.ComplaintsBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class PatientDashboardController implements Initializable {
    private PatientBO patientBO=new PatientBOImpl();
    private AppointmentBO appointmentBO=new AppointmentBOImpl();
    private ComplaintBO complaintBO=new ComplaintsBOImpl();
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
    void addNewAppointmentBtn_OnAction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard_addAppointment.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard.fxml"));
        this.root.getChildren().setAll(pane);

    }

    @FXML
    void addNewComplaint_OnAction(ActionEvent event) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard_addComplaints.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard.fxml"));
        this.root.getChildren().setAll(pane);
    }

    @FXML
    void appointmentTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void complaintTable_MouseEvent(MouseEvent event) {

    }

    private void loadTodayAppointmentTable() throws Exception {

        appointmentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        appointmentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        appointmentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("status"));
        appointmentTable.setItems(FXCollections.observableArrayList(appointmentBO.getTodayAppointmentListUsingPatientUsername(patientUsername)));
    }

    private void loadThisPatientComplaintTable() throws Exception {

        complaintTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        complaintTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        complaintTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        complaintTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("status"));
        complaintTable.setItems(FXCollections.observableArrayList(complaintBO.getComplaintUsingPatientUsername(patientUsername)));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadTodayAppointmentTable();
            loadThisPatientComplaintTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
