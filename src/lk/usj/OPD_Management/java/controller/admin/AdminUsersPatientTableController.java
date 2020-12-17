package lk.usj.OPD_Management.java.controller.admin;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class AdminUsersPatientTableController implements Initializable {
    private PatientBO patientBO= new PatientBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<PatientDTO> patientTable;

    @FXML
    void patientTable_MouseEvent(MouseEvent event) {

    }
    private void loadPatientTable() throws Exception {
        patientTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("idCard"));
        patientTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        patientTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("username"));
        patientTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("gender"));
        patientTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("address"));
        patientTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        patientTable.setItems(FXCollections.observableArrayList(patientBO.getAllPatient()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadPatientTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
