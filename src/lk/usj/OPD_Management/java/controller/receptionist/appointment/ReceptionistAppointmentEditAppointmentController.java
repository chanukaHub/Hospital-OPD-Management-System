package lk.usj.OPD_Management.java.controller.receptionist.appointment;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

public class ReceptionistAppointmentEditAppointmentController implements Initializable {
    private DoctorBO doctorBO=new DoctorBOImpl();
    private PatientBO patientBO = new PatientBOImpl();
    private AppointmentBO appointmentBO =new AppointmentBOImpl();
    String appointmentId;
    DoctorDTO doctorDTO;
    PatientDTO patientDTO;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField patientUsernameTextField;

    @FXML
    private JFXTextField patientNameTextField;

    @FXML
    private JFXTextField patientPhoneTextField;

    @FXML
    private JFXDatePicker dateDatePicker;

    @FXML
    private JFXComboBox<String> timeComboBox;

    @FXML
    private JFXComboBox<String> specialistAreaComboBox;

    @FXML
    private TableView<DoctorDTO> doctorTable;

    @FXML
    private Label doctorNameLabel;

    @FXML
    private JFXTextArea symptomesTextArea;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void cancelBtn_OnAction(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void dateDatePicker_OnAction(ActionEvent event) {

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

    @FXML
    void patientNameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void patientPhoneTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void patientUsernameTextField_OnAction(ActionEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {
        try {
            patientDTO=patientBO.searchPatient(patientUsernameTextField.getText());

        }catch (Exception e){
            Common.showError("Sorry! Can not found Patient Account");
            return;
        }
        try{
            String status ="Pending";
            int appointmentNo =-1;


            LocalDate ld = dateDatePicker.getValue();
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
                    symptomesTextArea.getText(),
                    status
            );

            boolean b = appointmentBO.updateAppointment(appointmentDTO);

            if (b){
                Common.showMessage("Updated successfully!");
            }
            else
                Common.showError("Updated Fail!");
        } catch (Exception e1) {
            Common.showError("Updated Fail!");
            e1.printStackTrace();
        }
        ((Node)(event.getSource())).getScene().getWindow().hide();


    }

    @FXML
    void specialistAreaComboBox_OnAction(ActionEvent event) {
        doctorNameLabel.setText("");
        try {
            loadDoctorTable(specialistAreaComboBox.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void symptomesTextArea_MouseEvent(MouseEvent event) {

    }

    @FXML
    void timeComboBox_OnAction(ActionEvent event) {

    }

    private void loadDoctorTable(String specialistArea) throws Exception {
        doctorTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("name"));
        doctorTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("gender"));
        doctorTable.setItems(FXCollections.observableArrayList(doctorBO.getAllDoctorsUsingSpecialistArea(specialistArea)));

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(AppointmentDTO appointmentDTO) throws Exception{
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
        LocalDate localDate = (appointmentDTO.getAppointmentDate()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        appointmentId = appointmentDTO.getAppointmentId();
        patientNameTextField.setText(appointmentDTO.getPatientName());
        patientUsernameTextField.setText(appointmentDTO.getPatientUsername());
        patientPhoneTextField.setText(appointmentDTO.getPatientPhone());
        doctorNameLabel.setText(appointmentDTO.getDoctorName());
        dateDatePicker.setValue(localDate);
        timeComboBox.getSelectionModel().select(appointmentDTO.getAppointmentTime());
        symptomesTextArea.setText(appointmentDTO.getSymptoms());
        specialistAreaComboBox.getSelectionModel().select(appointmentDTO.getSpecialistArea());
        doctorDTO = doctorBO.searchDoctor(appointmentDTO.getDoctorUsername());

        loadDoctorTable(appointmentDTO.getSpecialistArea());
    }
}

