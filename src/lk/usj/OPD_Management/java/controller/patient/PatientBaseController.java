package lk.usj.OPD_Management.java.controller.patient;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class PatientBaseController {

    @FXML
    private ImageView profileImageView;

    @FXML
    private VBox profileVBox;

    @FXML
    private Text nameTxt;

    @FXML
    private Text userTypeTxt;

    @FXML
    private HBox dashboardHBox;

    @FXML
    private HBox appointmentHBox;

    @FXML
    private HBox complainsHBox;

    @FXML
    private HBox referenceHBox;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private AnchorPane root;

    @FXML
    void dashboardHBox_OnAction(MouseEvent event) {

    }

    @FXML
    void logout(ActionEvent event) {

    }

}