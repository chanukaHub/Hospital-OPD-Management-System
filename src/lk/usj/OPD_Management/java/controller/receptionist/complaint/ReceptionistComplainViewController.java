package lk.usj.OPD_Management.java.controller.receptionist.complaint;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
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

public class ReceptionistComplainViewController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label complainIdLabel;

    @FXML
    private Label complaintTypeLabel;

    @FXML
    private Label complaintByLabel;

    @FXML
    private Label phoneLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label statusLabel;

    @FXML
    private Label actionTackenLabel;

    @FXML
    private Label pathLabel;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private JFXTextArea descriptionTextField;

    @FXML
    private JFXTextArea noteTextField;

    @FXML
    private JFXButton okBtn;

    @FXML
    void attachmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void okBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(ComplaintDTO complaintDTO) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(complaintDTO.getDate());

        complainIdLabel.setText(complaintDTO.getComplaintId());
        complaintTypeLabel.setText(complaintDTO.getType());
        complaintByLabel.setText(complaintDTO.getComplaintBy());
        phoneLabel.setText(complaintDTO.getPhoneNumber());
        dateLabel.setText(strDate);
        statusLabel.setText(complaintDTO.getStatus());
        actionTackenLabel.setText(complaintDTO.getActionTaken());
        pathLabel.setText(complaintDTO.getAttachDocument());
        descriptionTextField.setText(complaintDTO.getDescription());
        noteTextField.setText(complaintDTO.getNote());

    }
}
