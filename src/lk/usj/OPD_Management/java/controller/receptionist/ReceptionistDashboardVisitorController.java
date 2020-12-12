package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;

import java.net.URL;
import java.util.ResourceBundle;

public class ReceptionistDashboardVisitorController implements Initializable {
    @FXML
    private VBox root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField vistorNameTxt;

    @FXML
    private JFXTextField purposeTxt;

    @FXML
    private JFXTextField telNotxt;

    @FXML
    private JFXTextField nicTxt;

    @FXML
    private JFXComboBox<?> dateCBox;

    @FXML
    private JFXComboBox<?> monthCBox;

    @FXML
    private JFXComboBox<?> yearCBox;

    @FXML
    private JFXComboBox<?> inTImeHourCBox;

    @FXML
    private JFXComboBox<?> inTimeMinutesCBox;

    @FXML
    private JFXComboBox<?> inTimeAmPmCBox;

    @FXML
    private JFXComboBox<?> outTimeHourCBox;

    @FXML
    private JFXComboBox<?> outTimeMinutesCBox;

    @FXML
    private JFXComboBox<?> outTimeAmPmCBox;

    @FXML
    public JFXButton visitorAttachmentBtn;

    @FXML
    private JFXTextArea notesTxtArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;
    @FXML
    private VBox VBoxarea1;
    @FXML
    private VBox VBoxarea2;
    @FXML
    private VBox VBoxarea3;


    private VisitorBO VisitorBO;
    private Object Stage;

    @FXML
    void cancelBtn_OnActon(ActionEvent event) {

    }

    @FXML
    void dateCBox_OnActon(ActionEvent event) {
        monthCBox.requestFocus();
    }

    @FXML
    void inTImeHourCBox_OnActon(ActionEvent event) {
        inTimeMinutesCBox.requestFocus();
    }

    @FXML
    void inTimeAmPmCBox_OnActon(ActionEvent event) {
        outTimeHourCBox.requestFocus();
    }

    @FXML
    void inTimeMinutesCBox_OnActon(ActionEvent event) {
        inTimeAmPmCBox.requestFocus();
    }

    @FXML
    void monthCBox_OnActon(ActionEvent event) {
        yearCBox.requestFocus();
    }

    @FXML
    void nicTxt_OnActon(ActionEvent event) {
        dateCBox.requestFocus();

    }

    @FXML
    void notesTxtArea_OnActon(MouseEvent event) {
        saveBtn.requestFocus();
    }

    @FXML
    void outTimeAmPmCBox_OnActon(ActionEvent event) {
        visitorAttachmentBtn.requestFocus();
    }
    @FXML
    void outTimeHourCBox_OnActon(ActionEvent event) {
        outTimeMinutesCBox.requestFocus();
    }

    @FXML
    void outTimeMinutesCBox_OnActon(ActionEvent event) {
        outTimeAmPmCBox.requestFocus();
    }

    @FXML
    void purposeTxt_OnActon(ActionEvent event) {
    telNotxt.requestFocus();
    }

    @FXML
    void saveBtn_OnActon(ActionEvent event) {
         String visitorName=vistorNameTxt.getText();
         String purpose=purposeTxt.getText();
         String telNo=telNotxt.getText();
         String nicNo=nicTxt.getText();
         int visitDay= (int) dateCBox.getValue();
         int visitMonth= (int) monthCBox.getValue();
         int visitYear= (int) yearCBox.getValue();
         int inTimeHour= (int) inTImeHourCBox.getValue();
         int inTimeMinutes= (int) inTimeMinutesCBox.getValue();
         String inTimeAMPM= (String) inTimeAmPmCBox.getValue();
         int outTimeHour= (int) outTimeHourCBox.getValue();
         int outTimeMinutes= (int) outTimeMinutesCBox.getValue();
         String outTimeAMPM= (String) outTimeAmPmCBox.getValue();
         String attchment=visitorAttachmentBtn.getText();
//         JFileChooser attachment=visitorAttachmentBtn.getExtensionFilters().addAll(
//                 new FileChooser.ExtensionFilter("All Images", "*.*"),
//                 new FileChooser.ExtensionFilter("JPG", "*.jpg"),
//                 new FileChooser.ExtensionFilter("PNG", "*.png")
//         );
         String notes;
    }

    @FXML
    void telNotxt_OnActon(ActionEvent event) {
        nicTxt.requestFocus();
    }

    @FXML

    void visitorAttachmentBtn_OnActon(ActionEvent event){
       notesTxtArea.requestFocus();
    }

//    @FXML

//    void visitorAttachmentBtn_OnActon(new EventHandler<ActionEvent>(){
//        public void handle(ActionEvent Event event;
//        event){
//            //Opening a dialog box
//            FileChooser fileChooser = new FileChooser();
//            List<File> files = fileChooser.showOpenMultipleDialog((Window) Stage);
//        });
//
//        notesTxtArea.requestFocus();
//    }

    @FXML
    void vistorNameTxt_OnActon(ActionEvent event) {
        purposeTxt.requestFocus();

    }

    @FXML
    void yearCBox_OnActon(ActionEvent event) {
        inTImeHourCBox.requestFocus();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
