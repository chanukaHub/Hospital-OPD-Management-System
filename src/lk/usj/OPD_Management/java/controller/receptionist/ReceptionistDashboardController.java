package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionistDashboardController implements Initializable {

    @FXML
    private JFXButton addNewVisitorBtn;

    @FXML
    private JFXButton addNewPatientBtn;

    @FXML
    private JFXButton addAppointmentBtn;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private AnchorPane root;

    @FXML
    void AddComplaintBtn_OnActon(ActionEvent event) {

    }

    @FXML
    void addAppointmentBtn_OnActon(ActionEvent event) throws IOException{
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_dashboard_addAppointment.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void addNewPatientBtn_OnActon(ActionEvent event) throws IOException{
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_dashboard_addPatient.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void addNewVisitorBtn_OnActon(ActionEvent event) throws IOException {
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_dashboard_addVisitor.fxml"));
        root.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        VBox pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_dashboard_default.fxml"));
            root.getChildren().setAll(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
