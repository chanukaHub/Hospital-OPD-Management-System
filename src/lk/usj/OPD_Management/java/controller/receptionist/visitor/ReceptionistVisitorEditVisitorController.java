package lk.usj.OPD_Management.java.controller.receptionist.visitor;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class ReceptionistVisitorEditVisitorController implements Initializable {
    private VisitorBO visitorBO= new VisitorBOImpl();
    String visitorId;
    String selectedFilePath="",currentFilePath;
    String path;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXTextField visitorNameTxt;

    @FXML
    private JFXTextField purposeTxt;

    @FXML
    private JFXTextField telNoTxt;

    @FXML
    private JFXTextField nicTxt;

    @FXML
    private JFXDatePicker dateDatePicker;

    @FXML
    private JFXTimePicker inTimeTimePicker;

    @FXML
    private JFXTimePicker outTimeTimePicker;

    @FXML
    private JFXButton visitorAttachmentBtn;

    @FXML
    private Label attachmentLabel;

    @FXML
    private JFXTextArea notesTxtArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void dateDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void inTimeTimePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void nicTxt_OnActon(ActionEvent event) {

    }

    @FXML
    void notesTxtArea_OnActon(MouseEvent event) {

    }

    @FXML
    void outTimeTimePicker_Onaction(ActionEvent event) {

    }

    @FXML
    void purposeTxt_OnActon(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) throws Exception{
        try{

            Integer telNo;
            if (visitorAttachmentBtn.getText().equals("")){
                Common.showError("Please Enter Name");
                return;
            }else if(nicTxt.getText().equals("")){
                Common.showError("Please Enter NIC No");
                return;
            }
            LocalDate ld = dateDatePicker.getValue();
            Calendar c =  Calendar.getInstance();
            if (ld == null){
                Common.showError("Please Enter Date");
                return;
            }
            c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
            Date date = c.getTime();

            if (inTimeTimePicker.getValue()== null){
                Common.showError("Please Enter In time");
                return;
            }else if (outTimeTimePicker.getValue()== null){
                Common.showError("Please Enter Out time");
                return;
            }

            if (selectedFilePath == null){
                Common.showError("Please Attach document");
                return;
            }
            try {
                telNo =Integer.parseInt(telNoTxt.getText());
            }catch (NumberFormatException e){
                Common.showError("Please Enter valid phone Number");
                return;
            }

            Date today= new Date();

            if (selectedFilePath.equals("")){
                path = currentFilePath;
            }else {
                File newFile1 = new File("AttachmentDocumentsStorage\\"+nicTxt.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".txt");
                Files.copy(Path.of(selectedFilePath),newFile1.toPath());
                path = newFile1.getPath();
            }


            VisitorDTO visitorDTO= new VisitorDTO(
                    visitorId,
                    visitorNameTxt.getText(),
                    purposeTxt.getText(),
                    telNo,
                    nicTxt.getText(),
                    date,
                    inTimeTimePicker.getValue(),
                    outTimeTimePicker.getValue(),
                    path,
                    notesTxtArea.getText()
            );

            boolean b = visitorBO.updateVisitor(visitorDTO);

            if (b){
                Common.showMessage("Update successfully!");
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();

    }

    @FXML
    void telNoTxt_OnActon(ActionEvent event) {

    }

    @FXML
    void visitorAttachmentBtn_OnActon(ActionEvent event) {
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
    void visitorNameTxt_OnActon(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(VisitorDTO visitorDTO) throws Exception{
        LocalDate localDate = (visitorDTO.getDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        visitorId= visitorDTO.getVisitorId();
        visitorNameTxt.setText(visitorDTO.getVisitorName());
        purposeTxt.setText(visitorDTO.getPurpose());
        visitorNameTxt.setText(visitorDTO.getVisitorName());
        nicTxt.setText(visitorDTO.getNicNo());
        telNoTxt.setText(String.valueOf(visitorDTO.getTelNo()));
        dateDatePicker.setValue(localDate);
        inTimeTimePicker.setValue(visitorDTO.getInTime());
        outTimeTimePicker.setValue(visitorDTO.getOutTime());
        attachmentLabel.setText(visitorDTO.getAttachment());
        notesTxtArea.setText(visitorDTO.getNotes());

    }
}
