package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.service.custom.ReceptionistBO;
import lk.usj.OPD_Management.java.service.custom.impl.ReceptionistBOImpl;

public class AdminUsersEditDeleteReceptionistController implements Initializable {
    private ReceptionistBO receptionistBO = new ReceptionistBOImpl();
    String path1,path2;
    String selectedFilePath="",currentFilePath;
    String selectedPhotographPath="",currentPhotographPath;

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
    private JFXTextField staffEmailTextField;

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
    private JFXPasswordField passwordField;

    @FXML
    private JFXButton photographBtn;

    @FXML
    private ImageView imageView;

    @FXML
    private JFXButton documentBtn;

    @FXML
    private Label documentLabel;

    @FXML
    private JFXTextArea notesTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton deleteBtn;

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
    void documentBtn_OnAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("TEXT Files", "*.txt"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            documentLabel.setText(selectedFile.getPath());
            selectedFilePath = selectedFile.getPath();
        }
        else {
            documentLabel.setText("File selection cancelled.");
        }
    }

    @FXML
    void femaleRadioBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void maleRadioBtn_OnAction(ActionEvent event) {

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
    void photographBtn_OnAction(ActionEvent event) throws FileNotFoundException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select PDF files");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Images", "*.jpg"));

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {

            String iconImagePath = selectedFile.getAbsolutePath();
            imageView.setImage(new Image(new FileInputStream(iconImagePath)));
            selectedPhotographPath = selectedFile.getPath();

        }
        else {
            Common.showError("File selection cancelled.");
            return;
        }

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try{
            Date today = new Date();
            String address,maritalStatus,specialistArea;
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
                address=address1TextField.getText()+","+address2TextField.getText()+","+address3TextField.getText();
            }
            String userName =nicNoTextField.getText();

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

            if (selectedPhotographPath.equals("")){
                path1 = currentPhotographPath;
            }else {
                File newFile = new File("StaffPhotograph\\"+nicNoTextField.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".jpg");
                Files.copy(Path.of(selectedPhotographPath),newFile.toPath());
                path1 = newFile.getPath();
            }
            if (selectedFilePath.equals("")){
                path2 = currentFilePath;
            }else {
                File newFile1 = new File("AttachmentDocumentsStorage\\"+nicNoTextField.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".txt");
                Files.copy(Path.of(selectedFilePath),newFile1.toPath());
                path2 = newFile1.getPath();
            }



            ReceptionistDTO receptionistDTO= new ReceptionistDTO(
                    userName,
                    nameTextField.getText(),
                    Gender.getSelectedToggle().getUserData().toString(),
                    phoneNoTextField.getText(),
                    nicNoTextField.getText(),
                    date,
                    address,
                    maritalStatus,
                    passwordField.getText(),
                    staffIDLabel.getText(),
                    staffEmailTextField.getText(),
                    today,
                    path1,
                    path2,
                    notesTextArea.getText()
            );

            boolean b = receptionistBO.updateDoctor(receptionistDTO);

            if (b){
                Common.showMessage("Updated!");
            }
            else
                Common.showError("Not Updated");
        } catch (Exception e1) {
            Common.showError("Not Updated");
            e1.printStackTrace();
        }

    }

    @FXML
    void staffEmailTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void usernameTextField_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        maleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        otherRadioBtn.setUserData("Other");

        maritalStatusComboBox.getItems().addAll(
                "Choose a Status",
                "Single",
                "Married",
                "Divorced",
                "Widowed"
        );

    }

    public void transferMessage(ReceptionistDTO receptionistDTO) {
        maleRadioBtn.setUserData("Male");
        femaleRadioBtn.setUserData("Female");
        otherRadioBtn.setUserData("Other");

        maritalStatusComboBox.getItems().addAll(
                "Choose a Status",
                "Single",
                "Married",
                "Divorced",
                "Widowed"
        );
        LocalDate localDate = (receptionistDTO.getDateOfBirth()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        usernameTextField.setText(receptionistDTO.getUsername());
        nameTextField.setText(receptionistDTO.getName());
        String gender = receptionistDTO.getGender();
        if (gender.equals("Male"))
            maleRadioBtn.setSelected(true);
        else if(gender.equals("Female"))
            femaleRadioBtn.setSelected(true);
        else
            otherRadioBtn.setSelected(true);
        phoneNoTextField.setText(receptionistDTO.getPhoneNumber());
        nicNoTextField.setText(receptionistDTO.getIdCard());
        dobDatePicker.setValue(localDate);
        String addressLine = receptionistDTO.getAddress();
        String[] address = addressLine.split(",");
        address1TextField.setText(address[0]);
        address2TextField.setText(address[1]);
        address3TextField.setText(address[2]);
        maritalStatusComboBox.getSelectionModel().select(receptionistDTO.getMaritalStatus());
        passwordField.setText(receptionistDTO.getPassword());
        staffIDLabel.setText(receptionistDTO.getStaffID());
        notesTextArea.setText(receptionistDTO.getNote());
        staffEmailTextField.setText(receptionistDTO.getStaffEmail());
        try {
            imageView.setImage(new Image(new FileInputStream(receptionistDTO.getPhotograph())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        currentPhotographPath =receptionistDTO.getPhotograph();
        documentLabel.setText(receptionistDTO.getDocument());
        currentFilePath=receptionistDTO.getDocument();
    }
}
