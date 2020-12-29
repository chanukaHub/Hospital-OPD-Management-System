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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.dto.LoginDTO;
import lk.usj.OPD_Management.java.dto.PatientDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.LoginBO;
import lk.usj.OPD_Management.java.service.custom.PatientBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.LoginBOImpl;
import lk.usj.OPD_Management.java.service.custom.impl.PatientBOImpl;

public class AdminReportController implements Initializable {
    private PatientBO patientBO= new PatientBOImpl();
    private AppointmentBO appointmentBO= new AppointmentBOImpl();
    private LoginBO loginBO =new LoginBOImpl();

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
    void generateAppointmentBtn_OnAction(ActionEvent event) throws Exception {
        LocalDate ld = appointmentFromDatePicker.getValue();
        if (ld == null){
            Common.showError("Please Enter Appointment FromDate");
            return;
        }
        Calendar cal1 =  Calendar.getInstance();
        cal1.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
        Date fromDate = cal1.getTime();

        LocalDate ld1 = appointmentToDatePicker.getValue();
        if (ld1 == null){
            Common.showError("Please Enter Appointment ToDate");
            return;
        }
        Calendar cal2 =  Calendar.getInstance();
        cal2.set(ld1.getYear(), ld1.getMonthValue() - 1, ld1.getDayOfMonth());
        Date toDate = cal2.getTime();

        System.out.println(fromDate);
        System.out.println(toDate);

        ArrayList<AppointmentDTO> appointments =appointmentBO.getAppointmentUsingDateRange(fromDate,toDate);

        //System.out.println(appointments);

        try {
            Date today =new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(today);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            String strFromDate = formatter1.format(fromDate);
            String strToDate = formatter1.format(toDate);
            String fileName= "GeneratedReports\\AppointmentReport"+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".pdf";

            Document document=new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Paragraph paragraph=new Paragraph("Patient Login Credential : "+strDate);
            document.add(paragraph);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph paragraph1=new Paragraph("Date Range : "+strFromDate+" - "+strToDate);
            document.add(paragraph1);


            //document.add(new Paragraph(" "));

            PdfPTable table =new PdfPTable(6);
            table.setWidthPercentage(108);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(15f);

            PdfPCell c1 = new PdfPCell(new Phrase("Appointment ID"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Patient"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Doctor"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Date"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Time"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("status"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);


            table.setHeaderRows(1);

            for (AppointmentDTO appointmentDTO: appointments){
                String printedDate = formatter1.format(appointmentDTO.getAppointmentDate());

                table.addCell(appointmentDTO.getAppointmentId());
                table.addCell(appointmentDTO.getPatientName());
                table.addCell(appointmentDTO.getDoctorName());
                table.addCell(printedDate);
                table.addCell(appointmentDTO.getAppointmentTime());
                table.addCell(appointmentDTO.getStatus());
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
    void generateUserLogBtn_OnAction(ActionEvent event) throws Exception{
        LocalDate ld = userLogFromDatePicker.getValue();
        if (ld == null){
            Common.showError("Please Enter User Login FromDate");
            return;
        }
        Calendar cal1 =  Calendar.getInstance();
        cal1.set(ld.getYear(), ld.getMonthValue() - 1, ld.getDayOfMonth());
        Date fromDate = cal1.getTime();

        LocalDate ld1 = userLogToDatePicker.getValue();
        if (ld1 == null){
            Common.showError("Please Enter User Login ToDate");
            return;
        }
        Calendar cal2 =  Calendar.getInstance();
        cal2.set(ld1.getYear(), ld1.getMonthValue() - 1, ld1.getDayOfMonth());
        Date toDate = cal2.getTime();

        System.out.println(fromDate);
        System.out.println(toDate);

        ArrayList<LoginDTO> logins =loginBO.getAppointmentUsingDateRange(fromDate,toDate);

        //System.out.println(appointments);

        try {
            Date today =new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(today);
            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
            String strFromDate = formatter1.format(fromDate);
            String strToDate = formatter1.format(toDate);
            String fileName= "GeneratedReports\\UserLogin"+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".pdf";

            Document document=new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Paragraph paragraph=new Paragraph("User Login Report : "+strDate);
            document.add(paragraph);

            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));

            Paragraph paragraph1=new Paragraph("Date Range : "+strFromDate+" - "+strToDate);
            document.add(paragraph1);


            //document.add(new Paragraph(" "));

            PdfPTable table =new PdfPTable(4);
            table.setWidthPercentage(108);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(15f);

            PdfPCell c1 = new PdfPCell(new Phrase("Username"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Name"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Role"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Date/Time"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            table.setHeaderRows(1);

            for (LoginDTO loginDTO: logins){
                String printedDate = formatter.format(loginDTO.getLoginDateTime());

                table.addCell(loginDTO.getUserName());
                table.addCell(loginDTO.getName());
                table.addCell(loginDTO.getUserType());
                table.addCell(printedDate);
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
    void userLogFromDatePicker_OnAction(ActionEvent event) {

    }

    @FXML
    void userLogToDatePicker_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
