package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class ReceptionistAppointmentApprovedTableController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<AppointmentDTO> approvedTable;

    @FXML
    private JFXButton exportPdfBtn;

    @FXML
    void approvedTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void exportPdfBtn_OnAction(ActionEvent event) {

    }

    private void loadApprovedAppointmentTable() throws Exception {
        approvedTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        approvedTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        approvedTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        approvedTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        approvedTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        approvedTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("patientPhone"));
        approvedTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        approvedTable.setItems(FXCollections.observableArrayList(appointmentBO.getApprovedAppointmentList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadApprovedAppointmentTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
