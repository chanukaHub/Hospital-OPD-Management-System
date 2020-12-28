package lk.usj.OPD_Management.java.controller.receptionist.complaint;

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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.receptionist.patient.ReceptionistPatientEditController;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;
import lk.usj.OPD_Management.java.service.custom.impl.ComplaintsBOImpl;


public class ReceptionistComplaintController implements Initializable {
    private ComplaintBO complaintBO= new ComplaintsBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<ComplaintDTO> complainTable;

    @FXML
    void complainTable_MouseEvent(MouseEvent event) throws Exception{
        ComplaintDTO complaintDTO=(complainTable.getSelectionModel().getSelectedItem());
        if(complaintDTO == null){
            Common.showWarning("Please select complaint records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_complaints_viewComplaints.fxml"));
        Parent root = loader.load();
        ReceptionistComplainViewController receptionistComplainViewController = loader.getController();
        receptionistComplainViewController.transferMessage(complaintDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_complaints.fxml"));
        this.root.getChildren().setAll(pane);
    }


    private void loadComplaintTable() throws Exception {
        complainTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("complaintId"));
        complainTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type"));
        complainTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("complaintBy"));
        complainTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("date"));
        complainTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("actionTaken"));
        complainTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("status"));
        complainTable.setItems(FXCollections.observableArrayList(complaintBO.getAllComplaint()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadComplaintTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
