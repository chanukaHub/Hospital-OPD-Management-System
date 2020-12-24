package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ReceptionistAppointmentController implements Initializable {

    String selectedType="Approved";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox mainRoot;

    @FXML
    private JFXButton approvedBtn;

    @FXML
    private JFXButton pendingBtn;

    @FXML
    private AnchorPane subRoot;

    @FXML
    void approvedBtn_OnAction(ActionEvent event) throws IOException{
        approvedBtn.getStyleClass().removeAll("selected_login_type_btn");
        pendingBtn.getStyleClass().removeAll("selected_login_type_btn");

        approvedBtn.getStyleClass().add("selected_login_type_btn");
        pendingBtn.getStyleClass().add("login_type_btn");

        selectedType= "Approved";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_appointment_approvedTable.fxml"));
        subRoot.getChildren().setAll(pane);
    }

    @FXML
    void pendingBtn_OnAction(ActionEvent event) throws IOException{
        approvedBtn.getStyleClass().removeAll("selected_login_type_btn");
        pendingBtn.getStyleClass().removeAll("selected_login_type_btn");

        pendingBtn.getStyleClass().add("selected_login_type_btn");
        approvedBtn.getStyleClass().add("login_type_btn");

        selectedType= "Pending";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_appointment_pendingTable.fxml"));
        subRoot.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        approvedBtn.getStyleClass().add("selected_login_type_btn");
        pendingBtn.getStyleClass().add("login_type_btn");

        Pane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_appointment_approvedTable.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        subRoot.getChildren().setAll(pane);
    }
}

