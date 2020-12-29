package lk.usj.OPD_Management.java.controller.admin.report;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;

import java.awt.*;
import java.io.FileOutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class AdminReportController implements Initializable {
    private PatientBO patientBO= new PatientBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private JFXDatePicker appointmentFromDatePicker;

    @FXML
    private JFXDatePicker appointmentToDatePicker;

    @FXML
    private JFXButton generateAppointmentBtn;

    @FXML
    private JFXDatePicker userLogFromDatePicker;

    @FXML
    private JFXDatePicker userLogToDatePicker;

    @FXML
    private JFXButton generateUserLogBtn;

    @FXML
    private JFXButton generatePatientLoginBtn;

    @FXML
    void appointmentFromDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void appointmentToDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void generateAppointmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void generatePatientLoginBtn_OnAction(ActionEvent event) throws Exception {
        ArrayList<PatientDTO> patients =patientBO.getAllPatient();
        try {
            Date today =new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(today);
            String fileName= "GeneratedReports\\PatientLoginCredential"+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".pdf";

            Document document=new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Paragraph paragraph=new Paragraph("Patient Login Credential : "+strDate);
            document.add(paragraph);

            //document.add(new Paragraph(" "));

            PdfPTable table =new PdfPTable(3);
            table.setWidthPercentage(80);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(15f);

            PdfPCell c1 = new PdfPCell(new Phrase("Patient Name"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Username"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Password"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);


            table.setHeaderRows(1);

            for (PatientDTO patientDTO: patients){

                table.addCell(patientDTO.getName());
                table.addCell(patientDTO.getUsername());
                table.addCell(patientDTO.getPassword());
            }

            document.add(table);

            document.close();
            Common.showMessage("Report Generated Successfully");

            try {
                Desktop.getDesktop().open(new java.io.File(fileName));
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
            Common.showError("Fail!");
        }

    }

    @FXML
    void generateUserLogBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void userLogFromDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void userLogToDatePicker_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
