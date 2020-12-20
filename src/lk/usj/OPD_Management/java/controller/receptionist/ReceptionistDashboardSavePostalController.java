package lk.usj.OPD_Management.java.controller.receptionist;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class ReceptionistDashboardSavePostalController implements Initializable {
    private PostalBO postalBO=new PostalBOImpl();
    String selectedFilePath;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXButton addPostalSaveBtn;

    @FXML
    void addPostalSaveBtn_OnAction(ActionEvent event) {
        try{

            if (postalAttachmentBtn.getText().equals("")){
                Common.showError("Please Enter Reference Number");
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



            if (selectedFilePath == null){
                Common.showError("Please Attach document");
                return;
            }


            File newFile = new File("AttachmentDocumentsStorage\\"+postalReferenceNOTxt.getText()+String.valueOf(date.getDate())+toNameTxt.getText()+fromAddressTxt.getText()+".txt");
            Files.copy(Path.of(selectedFilePath),newFile.toPath());


            PostalDTO postalDTO= new PostalDTO(
                    postalReferenceNOTxt.getText(),
                    fromAddressTxt.getText(),
                    toAddressTxt.getText(),
                    fromNameTxt.getText(),
                    toNameTxt.getText(),
                    date,
                    newFile.getPath(),
                    postalNotesTxtArea.getText()
            );

            boolean b = postalBO.addPostal(postalDTO);

            if (b){
                Common.showMessage("Added Postal Details!");
                postalReferenceNOTxt.clear();
                        fromAddressTxt.clear();
                        toAddressTxt.clear();
                        fromNameTxt.clear();
                        toNameTxt.clear();
                        postalDateDatePicker.getEditor().clear();
                        postalAttachmentLbl.setText("");
                        postalNotesTxtArea.clear();
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }

    }

    @FXML
    void addpostalCancelBtn_OnAction(ActionEvent event) {

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
            //try {
            //File newFile = new File("AttachmentDocumentsStorage\\new.txt");
            //Files.copy(selectedFile.toPath(),newFile.toPath());
            //}catch (Exception e){
            //e.printStackTrace();
            //}
        }
        else {
            postalAttachmentLbl.setText("File selection cancelled.");
        }

    }

    @FXML
    void postalReferenceNOTxt_OnAction(ActionEvent event) {

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


    }

