package lk.usj.OPD_Management.java.controller.admin.postal;

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
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class AdminPostalDeleteViewController implements Initializable {
    private PostalBO postalBO= new PostalBOImpl();
    String referenceNo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label referenceNoLabel;

    @FXML
    private Label fomAddressLabel;

    @FXML
    private Label toAddressLabel;

    @FXML
    private Label fromNameLabel;

    @FXML
    private Label toNameLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label attachmentLabel;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private JFXTextArea noteTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void attachmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) {
        boolean deleted = false;
        try {
            deleted = postalBO.deleteDoctor(referenceNo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (deleted) {
            Common.showMessage("DELETE !");
        }

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(PostalDTO postalDTO) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(postalDTO.getPostalDate());

        referenceNo =postalDTO.getReferenceNumber();
        referenceNoLabel.setText(postalDTO.getReferenceNumber());
        fomAddressLabel.setText(postalDTO.getFromAddress());
        toAddressLabel.setText(postalDTO.getToAddress());
        fromNameLabel.setText(postalDTO.getFromName());
        toNameLabel.setText(postalDTO.getToName());
        dateLabel.setText(strDate);
        attachmentLabel.setText(postalDTO.getAttachment());
        noteTextArea.setText(postalDTO.getNotes());

    }
}
