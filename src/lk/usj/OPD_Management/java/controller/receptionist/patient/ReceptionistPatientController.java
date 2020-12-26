package lk.usj.OPD_Management.java.controller.receptionist.patient;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.admin.user.AdminUserEditDeletePatientController;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class ReceptionistPatientController implements Initializable {
    private PatientBO patientBO= new PatientBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<PatientDTO> patientTable;

    @FXML
    void patientTable_MouseEvent(MouseEvent event) throws Exception{
        PatientDTO patientDTO=(patientTable.getSelectionModel().getSelectedItem());
        if(patientDTO == null){
            Common.showWarning("Please select patient records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_patients_edit.fxml"));
        Parent root = loader.load();
        ReceptionistPatientEditController receptionistPatientEditController = loader.getController();
        receptionistPatientEditController.transferMessage(patientDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_patients.fxml"));
        this.root.getChildren().setAll(pane);

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
