package lk.usj.OPD_Management.java.controller.receptionist.postal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.PostalDTO;

public class ReceptionistPostalEditDispatchedPostalController implements Initializable {
    final String postalType="Dispatched";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXTextField postalReferenceNOTxt;

    @FXML
    private JFXTextField fromAddressTxt;

    @FXML
    private JFXTextField toAddressTxt;

    @FXML
    private JFXTextField fromNameTxt;

    @FXML
    private JFXTextField toNameTxt;

    @FXML
    private JFXDatePicker postalDateDatePicker;

    @FXML
    private JFXButton postalAttachmentBtn;

    @FXML
    private Label postalAttachmentLbl;

    @FXML
    private JFXTextArea postalNotesTxtArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) throws Exception{

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) throws Exception{

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void fromAddressTxt_OnAction(ActionEvent event) {

    }

    @FXML
    void fromNameTxt_OnAction(ActionEvent event) {

    }

    @FXML
    void postalAttachmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void postalReferenceNOTxt_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) throws Exception{

        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void toAddressTxt_OnAction(ActionEvent event) {

    }

    @FXML
    void toNameTxt_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
    }

    public void transferMessage(PostalDTO postalDTO) throws Exception{
        LocalDate localDate = (postalDTO.getPostalDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        postalReferenceNOTxt.setText(postalDTO.getReferenceNumber());
        fromAddressTxt.setText(postalDTO.getFromAddress());
        toAddressTxt.setText(postalDTO.getToAddress());
        fromNameTxt.setText(postalDTO.getFromName());
        toNameTxt.setText(postalDTO.getToName());
        postalDateDatePicker.setValue(localDate);
        postalAttachmentLbl.setText(postalDTO.getAttachment());
        postalNotesTxtArea.setText(postalDTO.getNotes());
    }
}
