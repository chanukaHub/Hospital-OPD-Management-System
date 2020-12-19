package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.DoctorDTO;

public class AdminUsersEditDoctorController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private Label staffIDLabel;

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField usernameTextField;

    @FXML
    private JFXRadioButton MaleRadioBtn;

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
    private JFXComboBox<String> maritalStatusComboBox;

    @FXML
    private JFXTextField staffEmailTextField;

    @FXML
    private JFXComboBox<String> specializedAreaComboBox;

    @FXML
    private JFXPasswordField passwordField;

    @FXML
    private JFXTextArea notesTextArea;

    @FXML
    private JFXButton staffPhotographBtn;

    @FXML
    private ImageView imageView;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private Label attachmentLabel;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void MaleRadioBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void address1TextField_OnAction(ActionEvent event) {

    }

    @FXML
    void address2TextField_OnAction(ActionEvent event) {

    }

    @FXML
    void address3TextField_OnAction(ActionEvent event) {

    }

    @FXML
    void attachmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void deleteBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void dobDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void femaleRadioBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void maritalStatusComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void nameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void nicNoTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void notesTextArea_MouseEvent(MouseEvent event) {

    }

    @FXML
    void otherRadioBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void passwordField_OnAction(ActionEvent event) {

    }

    @FXML
    void phoneNoTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void specializedAreaComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void staffEmailTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void staffPhotographBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void usernameTextField_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MaleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        otherRadioBtn.setUserData("Other");

        specializedAreaComboBox.getItems().addAll(
                "Choose",
                "Psychiatrist",
                "Surgeon",
                "Cardiologist",
                "Dermatologist",
                "Endocrinologist",
                "Gastroenterologist",
                "Oncologist",
                "Radiologist"
        );
        maritalStatusComboBox.getItems().addAll(
                "Choose a Status",
                "Single",
                "Married",
                "Divorced",
                "Widowed"
        );

    }

    public void transferMessage(DoctorDTO doctorDTO){
        MaleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        otherRadioBtn.setUserData("Other");

        specializedAreaComboBox.getItems().addAll(
                "Choose",
                "Psychiatrist",
                "Surgeon",
                "Cardiologist",
                "Dermatologist",
                "Endocrinologist",
                "Gastroenterologist",
                "Oncologist",
                "Radiologist"
        );
        maritalStatusComboBox.getItems().addAll(
                "Choose a Status",
                "Single",
                "Married",
                "Divorced",
                "Widowed"
        );
        LocalDate localDate = (doctorDTO.getDateOfBirth()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        usernameTextField.setText(doctorDTO.getUsername());
        nameTextField.setText(doctorDTO.getName());
        String gender = doctorDTO.getGender();
        if (gender.equals("Male"))
            MaleRadioBtn.setSelected(true);
        else if(gender.equals("Female"))
            femaleRadioBtn.setSelected(true);
        else
            otherRadioBtn.setSelected(true);
        phoneNoTextField.setText(doctorDTO.getPhoneNumber());
        nicNoTextField.setText(doctorDTO.getIdCard());
        dobDatePicker.setValue(localDate);
        String addressLine = doctorDTO.getAddress();
        String[] address = addressLine.split(",");
        address1TextField.setText(address[0]);
        address2TextField.setText(address[1]);
        address3TextField.setText(address[2]);
        specializedAreaComboBox.getSelectionModel().select(doctorDTO.getSpecialistArea());
        maritalStatusComboBox.getSelectionModel().select(doctorDTO.getMaritalStatus());
        passwordField.setText(doctorDTO.getPassword());
        staffIDLabel.setText(doctorDTO.getStaffID());
        notesTextArea.setText(doctorDTO.getNote());
        staffEmailTextField.setText(doctorDTO.getStaffEmail());
        try {
            imageView.setImage(new Image(new FileInputStream(doctorDTO.getPhotograph())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        attachmentLabel.setText(doctorDTO.getDocument());

    }
}
