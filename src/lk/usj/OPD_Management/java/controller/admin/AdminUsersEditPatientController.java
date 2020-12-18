package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.PatientDTO;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;

public class AdminUsersEditPatientController implements Initializable {

    @FXML
    private VBox root;

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
    private JFXPasswordField passwordField;

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
    void cancelBtn_ActionEvent(ActionEvent event) {

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
    void passwordField_OnAction(ActionEvent event) {

    }

    @FXML
    void phoneNoTextField_ActinEvent(ActionEvent event) {

    }

    @FXML
    void saveBtn_ActionEvent(ActionEvent event) {

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


    }


    public void transferMessage(PatientDTO newPatientDTO) {
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
        LocalDate localDate = (newPatientDTO.getDateOfBirth()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        usernameTextField.setText(newPatientDTO.getUsername());
        nameTextField.setText(newPatientDTO.getName());
        String gender = newPatientDTO.getGender();
        if (gender.equals("Male"))
            maleRadioBtn.setSelected(true);
        else if(gender.equals("Female"))
            femaleRadioBtn.setSelected(true);
        else
            otherRadioBtn.setSelected(true);
        phoneNoTextField.setText(newPatientDTO.getPhoneNumber());
        nicNoTextField.setText(newPatientDTO.getIdCard());
        dobDatePicker.setValue(localDate);
        String addressLine = newPatientDTO.getAddress();


    }

}