package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.DoctorBO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.DoctorBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class ReceptionistDashboardSaveAppointmentController implements Initializable {

    private AppointmentBO appointmentBO =new AppointmentBOImpl();
    private DoctorBO doctorBO=new DoctorBOImpl();
    private PatientBO patientBO=new PatientBOImpl();
    String appointmentId;
    PatientDTO patientDTO;
    DoctorDTO doctorDTO;
    @FXML
    private VBox root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField patientNameTextField;


    @FXML
    private JFXButton patientSearchBtn;

    @FXML
    private JFXTextField patientUsernameTextField;

    @FXML
    private JFXTextField patientPhoneNo;

    @FXML
    private JFXDatePicker appointmentDateDatePicker;

    @FXML
    private JFXComboBox<String> timeComboBox;

    @FXML
    private JFXComboBox<String> specialistAreaComboBox;

    @FXML
    private TableView<DoctorDTO> doctorTable;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private JFXTextArea symptomsTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void appointmentDateDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void timeComboBox_OnAction(ActionEvent event) {

    }

    @FXML
    void cancelBtn_OnAction(ActionEvent event) throws Exception{
        //root.setVisible(false);
        VBox pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_dashboard_default.fxml"));
        root.getChildren().setAll(pane);

    }

    @FXML
    void doctorTable_MouseEvent(MouseEvent event) throws Exception{
        doctorDTO=(doctorTable.getSelectionModel().getSelectedItem());
        if(doctorDTO == null){
            Common.showWarning("Please select Doctor records");
            return;
        }
        doctorNameLabel.setText(doctorDTO.getName());
    }

    private void loadDoctorTable(String specialistArea) throws Exception {
        doctorTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        doctorTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("gender"));
        doctorTable.setItems(FXCollections.observableArrayList(doctorBO.getAllDoctorsUsingSpecialistArea(specialistArea)));
    }

    @FXML
    void patientUsernameTextField_OnAction(ActionEvent event) throws Exception{
        patientSearchBtn_OnAction(event);
    }

    @FXML
    void patientNameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void patientPhoneNo_OnAction(ActionEvent event) {

    }

    @FXML
    void patientSearchBtn_OnAction(ActionEvent event) throws Exception{
        if (patientUsernameTextField.getText().equals("")){
            Common.showError("Please enter username");
            return;
        }else{
            try {
                patientDTO=patientBO.searchPatient(patientUsernameTextField.getText());
                patientNameTextField.setText(patientDTO.getName());
                patientPhoneNo.setText(patientDTO.getPhoneNumber());
            }catch (Exception e){
                Common.showError("Invalid Username");
                return;
            }

        }

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try{
            String status ="Pending";
            int appointmentNo =-1;

            if (patientUsernameTextField.getText().equals("")){
                Common.showError("Please Enter Patient Username");
                return;
            }



            LocalDate ld = appointmentDateDatePicker.getValue();
            if (ld == null){
                Common.showError("Please Enter Appointment Date");
                return;
            }
            Calendar c =  Calendar.getInstance();
            c.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
            Date date = c.getTime();

            timeComboBox.getSelectionModel().getSelectedItem();

            if (doctorNameLabel.getText().equals("")){
                Common.showWarning("Please select Doctor");
                return;
            }

            AppointmentDTO appointmentDTO= new AppointmentDTO(
                    appointmentId,
                    patientDTO,
                    doctorDTO,
                    appointmentNo,
                    date,
                    timeComboBox.getSelectionModel().getSelectedItem(),
                    symptomsTextArea.getText(),
                    status
            );

            boolean b = appointmentBO.addAppointment(appointmentDTO);

            if (b){
                Common.showMessage("Added Appointment!");
            }
            else
                Common.showError("Not added");
        } catch (Exception e1) {
            Common.showError("Not added");
            e1.printStackTrace();
        }

    }



    @FXML
    void specialistAreaComboBox_OnAction(ActionEvent event) {
        try {
            loadDoctorTable(specialistAreaComboBox.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    int getNextAppointmentID() throws Exception {
        return appointmentBO.getNextAppointmentID();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            appointmentId=("A"+String.format("%04d",getNextAppointmentID()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(appointmentId);
        specialistAreaComboBox.getItems().addAll(
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
        timeComboBox.getItems().addAll(
                "8.30 AM",
                "10.30 AM",
                "2.30 PM",
                "4.30PM"
        );
        specialistAreaComboBox.getSelectionModel().selectFirst();
        timeComboBox.getSelectionModel().selectFirst();
    }
}
