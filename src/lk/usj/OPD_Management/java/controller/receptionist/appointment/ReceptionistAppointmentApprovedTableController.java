package lk.usj.OPD_Management.java.controller.receptionist.appointment;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.entity.Appointment;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class ReceptionistAppointmentApprovedTableController implements Initializable {
    private AppointmentBO appointmentBO=new AppointmentBOImpl();


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<AppointmentDTO> approvedTable;

    @FXML
    private JFXButton exportPdfBtn;

    @FXML
    void approvedTable_MouseEvent(MouseEvent event) throws Exception{
        AppointmentDTO appointmentDTO=(approvedTable.getSelectionModel().getSelectedItem());
        if(appointmentDTO == null){
            Common.showWarning("Please select Appointment records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_appointments_viewAppointment.fxml"));
        Parent root = loader.load();
        ReceptionistAppointmentViewAppointmentController receptionistAppointmentViewAppointmentController = loader.getController();
        receptionistAppointmentViewAppointmentController.transferMessage(appointmentDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();


        //try {
        //    loadPendingAppointmentTable();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}
        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_appointment_approvedTable.fxml"));
        this.root.getChildren().setAll(pane);
    }

    @FXML
    void exportPdfBtn_OnAction(ActionEvent event) throws Exception{
        ArrayList<AppointmentDTO> appointments=appointmentBO.getApprovedAppointmentList();
        try {
            Date today =new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String strDate = formatter.format(today);
            String fileName= "GeneratedReports\\ApprovedAppointment"+String.valueOf(today.getDate())+String.valueOf(today.getMinutes())+String.valueOf(today.getSeconds())+".pdf";

            Document document=new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            Paragraph paragraph=new Paragraph("Approved Appointments : "+strDate);
            document.add(paragraph);

            //document.add(new Paragraph(" "));

            PdfPTable table =new PdfPTable(6);
            table.setWidthPercentage(108);
            table.setSpacingBefore(15f);
            table.setSpacingAfter(15f);

            PdfPCell c1 = new PdfPCell(new Phrase("Appointment Id"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Patient Name"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            c1 = new PdfPCell(new Phrase("Doctor Name"));
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

            c1 = new PdfPCell(new Phrase("Appointment No"));
            c1.setBackgroundColor(BaseColor.LIGHT_GRAY);
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);

            table.setHeaderRows(1);
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

            for (AppointmentDTO appointmentDTO: appointments){
                String strDate1 = format.format(appointmentDTO.getAppointmentDate());

                table.addCell(appointmentDTO.getAppointmentId());
                table.addCell(appointmentDTO.getPatientName());
                table.addCell(appointmentDTO.getDoctorName());
                table.addCell(strDate1);
                table.addCell(appointmentDTO.getAppointmentTime());
                table.addCell(String.valueOf(appointmentDTO.getAppointmentNo()));
            }

            document.add(table);

            document.close();
            Common.showMessage("Report Generated Successfully");


            /*String[] strings=fileName.split("\\\\");
            System.out.println(strings[0]);
            System.out.println(strings[1]);
            //String path= "\"/"+strings[0]+"/"+strings[1]+"\"";
            String path="\"C:\\Users\\USER\\Desktop\\AS2019941.pdf\"";
            System.out.println(path);
            URI myUri = new URI(path);
            if (Desktop.isDesktopSupported()){
                Desktop desktop = Desktop.getDesktop();
                if (desktop.isSupported(Desktop.Action.BROWSE)){
                    desktop.browse(myUri);
                }
            }*/
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



    private void loadApprovedAppointmentTable() throws Exception {
        approvedTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        approvedTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        approvedTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        approvedTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        approvedTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        approvedTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("patientPhone"));
        approvedTable.getColumns().get(6).setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        approvedTable.setItems(FXCollections.observableArrayList(appointmentBO.getApprovedAppointmentList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            loadApprovedAppointmentTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
