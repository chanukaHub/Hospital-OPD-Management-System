package lk.usj.OPD_Management.java.controller.receptionist;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Receptionist_DashBoardController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton addNewVisitorBtn;

    @FXML
    private JFXButton addNewPatientBtn;

    @FXML
    private JFXButton addAppointmentBtn;

    @FXML
    private JFXButton AddComplaintBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private HBox menuHBox;

    @FXML
    void AddComplaintBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void addAppointmentBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void addNewPatientBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void addNewVisitorBtn_OnAction(ActionEvent event) throws IOException{
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_dashboard_addVisitor.fxml"));
        root.getChildren().setAll(pane);

        //dashboardHBox.getStyleClass().removeAll("hover_border");




    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
