package lk.usj.OPD_Management.java.controller.patient.dashboard;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PatientDashboardSaveComplaintController implements Initializable {
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
    private JFXComboBox<?> complaintTypeComboBox;

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

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {

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

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
