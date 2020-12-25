package lk.usj.OPD_Management.java.controller.receptionist.postal;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class ReceptionistPostalEditReceivedPostalController implements Initializable {
    private PostalBO postalBO=new PostalBOImpl();
    final String postalType="Received";
    String selectedFilePath="",currentFilePath;
    String path;

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
    private JFXButton addpostalCancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void addpostalCancelBtn_OnAction(ActionEvent event) throws Exception{

        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) throws Exception{
        boolean deleted = false;
        try {
            deleted = postalBO.deleteDoctor(postalReferenceNOTxt.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (deleted) {
            Common.showMessage("DELETE !");
        }

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
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT Files", "*.txt"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            postalAttachmentLbl.setText(selectedFile.getPath());
            selectedFilePath = selectedFile.getPath();
        }
        else {
            postalAttachmentLbl.setText("File selection cancelled.");
        }

    }

    @FXML
    void postalReferenceNOTxt_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) throws Exception{
        try{

            if (postalReferenceNOTxt.getText().equals("")){
                Common.showError("Can not found reference No !");
                return;
            }else if(fromAddressTxt.getText().equals("")){
                Common.showError("Please Enter from Address ");
                return;
            }else if(toAddressTxt.getText().equals("")){
                Common.showError("Please Enter to Address ");
                return;
            }else if(fromNameTxt.getText().equals("")){
                Common.showError("Please Enter from Name ");
                return;
            }else if(toNameTxt.getText().equals("")){
                Common.showError("Please Enter to Name ");
                return;
            }
            LocalDate ld = postalDateDatePicker.getValue();
            Calendar c =  Calendar.getInstance();
            if (ld == null){
                Common.showError("Please Enter Date");
                return;
            }
            c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
            Date date = c.getTime();

            Date today= new Date();

            if (selectedFilePath.equals("")){
                path = currentFilePath;
            }else {
                File newFile1 = new File("AttachmentDocumentsStorage\\"+postalReferenceNOTxt.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+toNameTxt.getText()+fromAddressTxt.getText()+".txt");
                Files.copy(Path.of(selectedFilePath),newFile1.toPath());
                path = newFile1.getPath();
            }


            PostalDTO postalDTO= new PostalDTO(
                    postalReferenceNOTxt.getText(),
                    fromAddressTxt.getText(),
                    toAddressTxt.getText(),
                    fromNameTxt.getText(),
                    toNameTxt.getText(),
                    date,
                    path,
                    postalNotesTxtArea.getText(),
                    postalType
            );

            boolean b = postalBO.updatePostal(postalDTO);

            if (b){
                Common.showMessage("Successfully Updated!");
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

        currentFilePath=postalDTO.getAttachment();

    }
}
