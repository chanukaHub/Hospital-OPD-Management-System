package lk.usj.OPD_Management.java.controller.admin;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class AdminUsersSaveReceptionistController implements Initializable {
    private ReceptionistBO receptionistBO=new ReceptionistBOImpl();
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
    private JFXTextField staffEmailTextField;

    @FXML
    private JFXComboBox<String> maritalStatusComboBox;

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
    void address1TextField_OnAction(ActionEvent event) {

    }

    @FXML
    void address2TextField_OnAction(ActionEvent event) {

    }

    @FXML
    void address3TextField_OnAction(ActionEvent event) {

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
            Common.showWarning("File selection cancelled.");
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

            /*try {
            File newFile = new File("StaffPhotograph\\new.jpg");
            Files.copy(selectedFile.toPath(),newFile.toPath());
            }catch (Exception e){
            e.printStackTrace();
            }*/
        }
        else {
            Common.showWarning("File selection cancelled.");
        }
    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try{
            Date today = new Date();
            String address,maritalStatus;
            if (nameTextField.getText().equals("")){
                Common.showError("Please Enter name");
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

            File newFile = new File("StaffPhotograph\\"+nicNoTextField.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".jpg");
            Files.copy(Path.of(selectedPhotographPath),newFile.toPath());

            File newFile1 = new File("AttachmentDocumentsStorage\\"+nicNoTextField.getText()+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".txt");
            Files.copy(Path.of(selectedFilePath),newFile1.toPath());

            ReceptionistDTO receptionistDTO= new ReceptionistDTO(
                    userName,
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
                    newFile.getPath(),
                    newFile1.getPath(),
                    notesTextArea.getText()
            );

            boolean b = receptionistBO.addReceptionist(receptionistDTO);

            if (b){
                Common.showMessage("Added Receptionist!");
                VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_addReceptionist.fxml"));
                root.getChildren().setAll(pane);
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }
    }

    @FXML
    void staffEmailTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void usernameTextField_OnAction(ActionEvent event) {

    }
    int getNextReceptionistID() throws Exception {
        return receptionistBO.getNextReceptionistID();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            staffIDLabel.setText("R"+String.format("%04d",getNextReceptionistID()));
        } catch (Exception e) {
            e.printStackTrace();
        }


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

        maritalStatusComboBox.getSelectionModel().selectFirst();
    }
}
