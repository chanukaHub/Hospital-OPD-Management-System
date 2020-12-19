package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
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

    public void transferMessage(DoctorDTO doctorDTO) {
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
}
