package lk.usj.OPD_Management.java.controller.patient;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PatientBaseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox profileHBox;

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
    private HBox supportHBox;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private AnchorPane root;

    @FXML
    void appointmentHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void complainsHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void dashboardHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void supportHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void logoutBtn_ActionEvent(ActionEvent event) {
        try{
            Parent root= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/Login.fxml"));
            Scene scene =new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.setTitle("Login");
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void profileHBox_MouseEvent(MouseEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void transferMessage(String text) {
        nameTxt.setText(text);
    }
}
