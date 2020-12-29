package lk.usj.OPD_Management.java.controller.patient;

import com.jfoenix.controls.JFXButton;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    private JFXButton logoutBtn;

    @FXML
    private AnchorPane root;

    @FXML
    void appointmentHBox_MouseEvent(MouseEvent event) throws Exception{
        dashboardHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_appointments.fxml"));
        root.getChildren().setAll(pane);
        appointmentHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        appointmentHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        dashboardHBox.setBackground(background2);
        complainsHBox.setBackground(background2);
    }

    @FXML
    void complainsHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void dashboardHBox_MouseEvent(MouseEvent event) throws Exception{
        dashboardHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard.fxml"));
        root.getChildren().setAll(pane);
        dashboardHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        dashboardHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        appointmentHBox.setBackground(background2);
        complainsHBox.setBackground(background2);
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
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();

            ((Node)(event.getSource())).getScene().getWindow().hide();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void profileHBox_MouseEvent(MouseEvent event) {

    }

    private void loadInitialPanel() throws Exception {
        VBox pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/patient/patient_dashboard.fxml"));
        root.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        dashboardHBox.setBackground(background);
        try {
            loadInitialPanel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void transferMessage(String text) {
        nameTxt.setText(text);
    }
}
