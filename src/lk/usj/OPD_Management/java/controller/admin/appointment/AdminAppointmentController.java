package lk.usj.OPD_Management.java.controller.admin.appointment;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.admin.visitor.AdminVisitorDeleteViewController;
import lk.usj.OPD_Management.java.dto.AppointmentDTO;
import lk.usj.OPD_Management.java.service.custom.AppointmentBO;
import lk.usj.OPD_Management.java.service.custom.impl.AppointmentBOImpl;

public class AdminAppointmentController implements Initializable {
    private AppointmentBO appointmentBO =new AppointmentBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<AppointmentDTO> appointmentTable;

    @FXML
    void appointmentTable_MouseEvent(MouseEvent event) throws Exception{
        AppointmentDTO appointmentDTO=(appointmentTable.getSelectionModel().getSelectedItem());
        if(appointmentDTO == null){
            Common.showWarning("Please select visitor records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_appointments_deleteViewAppointments.fxml"));
        Parent root = loader.load();
        AdminAppointmentDeleteViewController adminAppointmentDeleteViewController = loader.getController();
        adminAppointmentDeleteViewController.transferMessage(appointmentDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_appointments.fxml"));
        this.root.getChildren().setAll(pane);

    }

    private void loadApprovedAppointmentTable() throws Exception {
        appointmentTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("appointmentId"));
        appointmentTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("patientName"));
        appointmentTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("doctorName"));
        appointmentTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));
        appointmentTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointmentTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("status"));
        appointmentTable.setItems(FXCollections.observableArrayList(appointmentBO.getAppointmentList()));
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
