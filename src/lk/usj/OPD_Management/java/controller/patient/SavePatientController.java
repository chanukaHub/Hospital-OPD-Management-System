package lk.usj.OPD_Management.java.controller.patient;

import com.jfoenix.controls.*;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class SavePatientController implements Initializable {

    private PatientBO patientBO = new PatientBOImpl();

    @FXML
    private VBox root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXRadioButton maleRadioBtn;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private JFXRadioButton femaleRadioBtn;

    @FXML
    private JFXRadioButton otherRadioBtn;

    @FXML
    private JFXTextField phoneNoTextField;

    @FXML
    private JFXTextField nicNoTextField;

    @FXML
    private JFXDatePicker dobDatePicker;


    @FXML
    private JFXTextField address1TextField;

    @FXML
    private JFXTextField address2TextField;

    @FXML
    private JFXTextField address3TextField;

    @FXML
    private JFXComboBox<String> bloodGroupComboBox;

    @FXML
    private JFXTextField allergiesTextField;

    @FXML
    private JFXComboBox<String> maritalStatusComboBox;

    @FXML
    private JFXTextArea notesTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void address1TextField_ActionEvent(ActionEvent event) {

    }

    @FXML
    void address2TextField_ActionEvent(ActionEvent event) {

    }

    @FXML
    void allergiesTextField_ActionEvent(ActionEvent event) {

    }

    @FXML
    void bloodGroupComboBox_ActionEvent(ActionEvent event) {

    }

    @FXML
    void cancelBtn_ActionEvent(ActionEvent event) throws IOException{
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void dobDatePicker_ActionEvent(ActionEvent event) {

    }

    @FXML
    void maritalStatusComboBox_ActionEvent(ActionEvent event) {

    }

    @FXML
    void nameTextField_ActionEvent(ActionEvent event) {

    }

    @FXML
    void nicNoTextField_ActionEvent(ActionEvent event) {

    }

    @FXML
    void phoneNoTextField_ActinEvent(ActionEvent event) {

    }

    @FXML
    void saveBtn_ActionEvent(ActionEvent event) {
        try{
            String address,maritalStatus,bloodGroup;

            if (nameTextField.getText().equals("")){
                Common.showError("Please Enter Name");
                return;
            }else if(nicNoTextField.getText().equals("")){
                Common.showError("Please Enter NIC No");
                return;
            }
            if(address1TextField.getText().equals("")&&address3TextField.getText().equals("")&&address2TextField.getText().equals("")){
                Common.showError("Please enter Address");
                return;
            }else {
                address=address1TextField.getText()+", "+address2TextField.getText()+", "+address3TextField.getText();
            }
            String userName =nicNoTextField.getText();
            String initialPassword =nicNoTextField.getText();

            LocalDate ld = dobDatePicker.getValue();
            Calendar c =  Calendar.getInstance();
            if (ld == null){
                Common.showError("Please Enter BirthDay");
                return;
            }
            c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
            Date date = c.getTime();
            if (Gender.getSelectedToggle() == null){
                Common.showError("Please Select Gender");
                return;
            }
            if (maritalStatusComboBox.getSelectionModel().getSelectedItem().equals("Choose a Status")){
                maritalStatus = null;
            }else{
                maritalStatus = maritalStatusComboBox.getSelectionModel().getSelectedItem();
            }
            if (bloodGroupComboBox.getSelectionModel().getSelectedItem().equals("Choose")){
                bloodGroup = null;
            }else{
                bloodGroup = bloodGroupComboBox.getSelectionModel().getSelectedItem();
            }

            PatientDTO patientDTO= new PatientDTO(
                    userName,
                    nameTextField.getText(),
                    Gender.getSelectedToggle().getUserData().toString(),
                    phoneNoTextField.getText(),
                    nicNoTextField.getText(),
                    date,
                    address,
                    maritalStatus,
                    initialPassword,
                    bloodGroup,
                    allergiesTextField.getText(),
                    notesTextArea.getText()
            );

            boolean b = patientBO.addPatient(patientDTO);

            if (b){
                Common.showMessage("Added Patient!");
                nameTextField.clear();
                maleRadioBtn.setSelected(false);
                femaleRadioBtn.setSelected(false);
                otherRadioBtn.setSelected(false);
                phoneNoTextField.clear();
                nicNoTextField.clear();
                dobDatePicker.getEditor().clear();
                address1TextField.clear();
                address2TextField.clear();
                address3TextField.clear();
                maritalStatusComboBox.getSelectionModel().clearSelection();
                bloodGroupComboBox.getSelectionModel().clearSelection();
                allergiesTextField.clear();
                notesTextArea.clear();
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }

    }

    @FXML
    void usernameTextField_ActionEvent(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        maleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        otherRadioBtn.setUserData("Other");

        bloodGroupComboBox.getItems().addAll(
                "Choose",
                "A−",
                "A+",
                "B−",
                "B+",
                "AB−",
                "AB+",
                "O−",
                "O+"
        );
        maritalStatusComboBox.getItems().addAll(
                "Choose a Status",
                "Single",
                "Married",
                "Divorced",
                "Widowed"
        );

        maritalStatusComboBox.getSelectionModel().selectFirst();
        bloodGroupComboBox.getSelectionModel().selectFirst();

    }
}
