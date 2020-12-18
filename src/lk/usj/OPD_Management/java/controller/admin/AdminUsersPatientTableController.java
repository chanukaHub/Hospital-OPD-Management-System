package lk.usj.OPD_Management.java.controller.admin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.controller.patient.PatientBaseController;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class AdminUsersPatientTableController implements Initializable {
    private PatientBO patientBO= new PatientBOImpl();

    @FXML
    private VBox tableRoot;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<PatientDTO> patientTable;

    @FXML
    void patientTable_MouseEvent(MouseEvent event) throws IOException {
        PatientDTO patientDTO=(patientTable.getSelectionModel().getSelectedItem());
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_editPatient.fxml"));
        Parent root = loader.load();
        tableRoot.getChildren().setAll(root);
        AdminUsersEditPatientController adminUsersEditPatientController = loader.getController();
        adminUsersEditPatientController.transferMessage(patientDTO);
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
