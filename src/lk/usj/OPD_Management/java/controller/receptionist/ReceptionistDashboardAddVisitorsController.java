package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class ReceptionistDashboardAddVisitorsController implements Initializable {
    private VisitorBO visitorBO = new VisitorBOImpl();
    String selectedFilePath;

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
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnActon(ActionEvent event) throws IOException {
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_dashboard.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void dateDatePicker_OnAction(ActionEvent event) {
        inTimeTimePicker.requestFocus();
    }

    @FXML
    void inTimeTimePicker_OnAction(ActionEvent event) {
        outTimeTimePicker.requestFocus();
    }

    @FXML
    void nicTxt_OnActon(ActionEvent event) {
        dateDatePicker.requestFocus();
    }

    @FXML
    void notesTxtArea_OnActon(MouseEvent event) {
        saveBtn.requestFocus();
    }

    @FXML
    void outTimeTimePicker_Onaction(ActionEvent event) {
        visitorAttachmentBtn.requestFocus();
    }

    @FXML
    void purposeTxt_OnActon(ActionEvent event) {
        telNoTxt.requestFocus();
    }

    @FXML
    void saveBtn_OnActon(ActionEvent event) {
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

            File newFile = new File("AttachmentDocumentsStorage\\"+nicTxt.getText()+String.valueOf(date.getDate())+String.valueOf(inTimeTimePicker.getValue().getHour())+String.valueOf(inTimeTimePicker.getValue().getMinute())+String.valueOf(inTimeTimePicker.getValue().getSecond())+".txt");
            Files.copy(Path.of(selectedFilePath),newFile.toPath());


            VisitorDTO visitorDTO= new VisitorDTO(
                    visitorNameTxt.getText(),
                    purposeTxt.getText(),
                    telNo,
                    nicTxt.getText(),
                    date,
                    inTimeTimePicker.getValue(),
                    outTimeTimePicker.getValue(),
                    newFile.getPath(),
                    notesTxtArea.getText()
            );

            boolean b = visitorBO.addVisitor(visitorDTO);

            if (b){
                Common.showMessage("Added Visitor!");
                visitorNameTxt.clear();
                purposeTxt.clear();
                telNoTxt.clear();
                nicTxt.clear();
                dateDatePicker.getEditor().clear();
                inTimeTimePicker.getEditor().clear();
                outTimeTimePicker.getEditor().clear();
                attachmentLabel.setText("");
                notesTxtArea.clear();
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }
    }

    @FXML
    void telNoTxt_OnActon(ActionEvent event) {
        nicTxt.requestFocus();
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
            //try {
                //File newFile = new File("AttachmentDocumentsStorage\\new.txt");
                //Files.copy(selectedFile.toPath(),newFile.toPath());
            //}catch (Exception e){
                //e.printStackTrace();
            //}
        }
        else {
            attachmentLabel.setText("File selection cancelled.");
        }
        notesTxtArea.requestFocus();
    }

    @FXML
    void visitorNameTxt_OnActon(ActionEvent event) {
            purposeTxt.requestFocus();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
