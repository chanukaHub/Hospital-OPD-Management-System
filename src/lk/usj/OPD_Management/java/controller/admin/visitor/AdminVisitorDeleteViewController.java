package lk.usj.OPD_Management.java.controller.admin.visitor;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class AdminVisitorDeleteViewController implements Initializable {
    private VisitorBO visitorBO =new VisitorBOImpl();
    String visitorId;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label visitorNameLabel;

    @FXML
    private Label purposeLabel;

    @FXML
    private Label phoneNoLabel;

    @FXML
    private Label nicNoLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label inTimeLabel;

    @FXML
    private Label outTimeLabel;

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
            deleted = visitorBO.deleteVisitor(visitorId);
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

    public void transferMessage(VisitorDTO visitorDTO) throws Exception{
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = format.format(visitorDTO.getDate());

        visitorId= visitorDTO.getVisitorId();
        visitorNameLabel.setText(visitorDTO.getVisitorName());
        purposeLabel.setText(visitorDTO.getPurpose());
        nicNoLabel.setText(visitorDTO.getNicNo());
        phoneNoLabel.setText(String.valueOf(visitorDTO.getTelNo()));
        dateLabel.setText(strDate);
        inTimeLabel.setText(visitorDTO.getInTime().toString());
        outTimeLabel.setText(visitorDTO.getOutTime().toString());
        attachmentLabel.setText(visitorDTO.getAttachment());
        noteTextArea.setText(visitorDTO.getNotes());
    }
}
