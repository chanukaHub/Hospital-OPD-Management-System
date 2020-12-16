package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.DoctorBO;
import lk.usj.OPD_Management.java.service.custom.impl.DoctorBOImpl;


public class AdminUsersSaveDoctorController implements Initializable {
    private DoctorBO doctorBO = new DoctorBOImpl();
    String selectedFilePath;
    String selectedPhotographPath;

    @FXML
    private VBox root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private JFXTextArea notesTextArea;

    @FXML
    private JFXButton staffPhotographBtn;

    @FXML
    private Label photographPathLabel;

    @FXML
    private JFXButton attachmentBtn;

    @FXML
    private Label attachmentLabel;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

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
    void cancelBtn_OnAction(ActionEvent event) throws IOException {
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users.fxml"));
        root.getChildren().setAll(pane);
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
    void phoneNoTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try{
            Date today = new Date();
            String address,maritalStatus,specialistArea;
            if (usernameTextField.getText().equals("")){
                Common.showError("Please Enter username");
                return;
            }else if(nicNoTextField.getText().equals("")){
                Common.showError("Please Enter NIC No");
                return;
            }
            if(address1TextField.getText().equals("")&&address3TextField.getText().equals("")&&address2TextField.getText().equals("")){
                address=null;
            }else {
                address=address1TextField.getText()+","+address2TextField.getText()+","+address3TextField.getText();
            }
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
            if (specializedAreaComboBox.getSelectionModel().getSelectedItem().equals("Choose")){
                specialistArea = null;
            }else{
                specialistArea = specializedAreaComboBox.getSelectionModel().getSelectedItem();
            }

            /*DoctorDTO doctorDTO= new DoctorDTO(
                    usernameTextField.getText(),
                    nameTextField.getText(),
                    Gender.getSelectedToggle().getUserData().toString(),
                    phoneNoTextField.getText(),
                    nicNoTextField.getText(),
                    date,
                    address,
                    maritalStatus,
                    initialPassword,
                    staffIDLabel.getText(),
                    staffEmailTextField.getText(),
                    today,


            );

            boolean b = doctorBO.addDoctor(doctorDTO);

            if (b){
                Common.showMessage("Added Patient!");
                usernameTextField.clear();
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
                Common.showError("Not added");*/
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }
    }

    @FXML
    void specializedAreaComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void staffEmailTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void staffPhotographBtn_OnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Images", "*.jpg"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            attachmentLabel.setText(selectedFile.getPath());
            //selectedPhotographPath = selectedFile.getPath();

            try {
            File newFile = new File("StaffPhotograph\\new.jpg");
            Files.copy(selectedFile.toPath(),newFile.toPath());
            }catch (Exception e){
            e.printStackTrace();
            }
        }
        else {
            attachmentLabel.setText("File selection cancelled.");
        }
    }

    @FXML
    void usernameTextField_OnAction(ActionEvent event) {

    }

    int getNextDoctorID() throws Exception {
        return doctorBO.getNextDoctorID();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            staffIDLabel.setText("D"+String.format("%04d",getNextDoctorID()));
        } catch (Exception e) {
            e.printStackTrace();
        }


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

        maritalStatusComboBox.getSelectionModel().selectFirst();
        specializedAreaComboBox.getSelectionModel().selectFirst();
    }
}
