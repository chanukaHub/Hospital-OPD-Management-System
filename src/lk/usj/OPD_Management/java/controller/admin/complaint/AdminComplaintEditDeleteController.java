package lk.usj.OPD_Management.java.controller.admin.complaint;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;
import lk.usj.OPD_Management.java.service.custom.ComplaintBO;
import lk.usj.OPD_Management.java.service.custom.impl.ComplaintsBOImpl;

public class AdminComplaintEditDeleteController implements Initializable {
    private ComplaintBO complaintBO= new ComplaintsBOImpl();
    String complaintId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXTextField complaintByTextField;

    @FXML
    private JFXComboBox<String> complainttypeComboBox;

    @FXML
    private JFXTextField phoneTextField;

    @FXML
    private JFXTextField dateTextField;

    @FXML
    private JFXComboBox<String> statusComboBox;

    @FXML
    private JFXTextField actionTakenTextField;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private Label attachmentLable;

    @FXML
    private JFXTextField descriptionTextField;

    @FXML
    private JFXTextField noteTextField;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void actionTakenTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void attachmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void complaintByTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void complainttypeComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void dateTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void descriptionTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void noteTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void phoneTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void statusComboBox_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void transferMessage(ComplaintDTO complaintDTO) {
        complainttypeComboBox.getItems().addAll(
                "Choose a Type",
                "Long Wait Times",
                "Issues with Staff Members",
                "Amount of Time Spent with Doctor",
                "Insurance and Billing"
        );

        statusComboBox.getItems().addAll(
                "NEW",
                "IN PROGRESS",
                "REOPENED",
                "CLOSED"
        );

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(complaintDTO.getDate());

        complaintId= complaintDTO.getComplaintId();

        complainttypeComboBox.getSelectionModel().select(complaintDTO.getType());
        statusComboBox.getSelectionModel().select(complaintDTO.getStatus());
        complaintByTextField.setText(complaintDTO.getComplaintBy());
        phoneTextField.setText(complaintDTO.getPhoneNumber());
        dateTextField.setText(strDate);

        actionTakenTextField.setText(complaintDTO.getActionTaken());
        attachmentLable.setText(complaintDTO.getAttachDocument());
        descriptionTextField.setText(complaintDTO.getDescription());
        noteTextField.setText(complaintDTO.getNote());
    }
}
