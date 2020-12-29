package lk.usj.OPD_Management.java.controller.patient.complaint;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;
import lk.usj.OPD_Management.java.service.custom.impl.ComplaintsBOImpl;

public class PatientComplaintController implements Initializable {
    private ComplaintBO complaintBO=new ComplaintsBOImpl();
    public static String patientUsername;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<ComplaintDTO> complaintTable;

    @FXML
    void complaintTable_MouseEvent(MouseEvent event) {

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
            loadThisPatientComplaintTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
