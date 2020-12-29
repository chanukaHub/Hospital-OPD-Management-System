package lk.usj.OPD_Management.java.controller.patient.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;
import lk.usj.OPD_Management.java.service.custom.impl.ComplaintsBOImpl;

public class PatientDashboardSaveComplaintController implements Initializable {
    private ComplaintBO complaintBO =new ComplaintsBOImpl();
    String selectedFilePath;
    String complainId;
    public static String patientUsername;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXTextField complaintByTextField;

    @FXML
    private JFXComboBox<String> complaintTypeComboBox;

    @FXML
    private JFXTextField phoneNoTextField;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private Label attachmentLabel;

    @FXML
    private JFXTextArea descriptionTextField;

    @FXML
    private JFXTextArea noteTextField;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void attachmentBtn_OnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT Files", "*.txt"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            attachmentLabel.setText(selectedFile.getPath());
            selectedFilePath = selectedFile.getPath();
        }
        else {
            attachmentLabel.setText("File selection cancelled.");
        }
    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void complaintByTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void complaintTypeComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void phoneNoTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try{
            Date currentDate = new Date();
            String status = "NEW";
            String complaintType;
            String actionTaken="";

            if (complaintByTextField.getText().equals("")){
                Common.showError("Error patient not found!");
                return;
            }else if(phoneNoTextField.getText().equals("")){
                Common.showError("Please Enter Phone No");
                return;
            }
            if (complaintTypeComboBox.getSelectionModel().getSelectedItem().equals("Choose a Type")){
                Common.showError("Please choose Type");
                return;
            }else{
                complaintType = complaintTypeComboBox.getSelectionModel().getSelectedItem();
            }

            File newFile = new File("AttachmentDocumentsStorage\\complaint"+complaintByTextField.getText()+String.valueOf(currentDate.getDay())+String.valueOf(currentDate.getHours())+String.valueOf(currentDate.getSeconds())+".txt");
            Files.copy(Path.of(selectedFilePath),newFile.toPath());

            ComplaintDTO complaintDTO= new ComplaintDTO(
                    complainId,
                    complaintType,
                    complaintByTextField.getText(),
                    phoneNoTextField.getText(),
                    currentDate,
                    descriptionTextField.getText(),
                    actionTaken,
                    noteTextField.getText(),
                    newFile.getPath(),
                    status
            );

            boolean b = complaintBO.addComplaint(complaintDTO);

            if (b){
                Common.showMessage("Added Complaint!");
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }
    }

    int getNextComplainID() throws Exception {
        return complaintBO.getNextComplainID();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            complainId=("C"+String.format("%04d",getNextComplainID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        complaintTypeComboBox.getItems().addAll(
                "Choose a Type",
                "Long Wait Times",
                "Issues with Staff Members",
                "Amount of Time Spent with Doctor",
                "Insurance and Billing"
        );

        complaintTypeComboBox.getSelectionModel().selectFirst();

        complaintByTextField.setText(patientUsername);
    }
}
