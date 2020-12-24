package lk.usj.OPD_Management.java.controller.receptionist;

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

public class ReceptionistBaseController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private HBox profileHBox;

    @FXML
    private ImageView prifileImageView;

    @FXML
    private Text profileNameTxt;

    @FXML
    private HBox dashboardHBox;

    @FXML
    private HBox visitorsHBox;

    @FXML
    private HBox postalHBox;

    @FXML
    private HBox complaintsHBox;

    @FXML
    private HBox appointmentsHBox;

    @FXML
    private HBox patientHBox;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    void appointmentsHBox_MouseEvent(MouseEvent event) throws Exception{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorsHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complaintsHBox.getStyleClass().add("hover_border");
        appointmentsHBox.getStyleClass().add("hover_border");
        patientHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_appointments.fxml"));
        root.getChildren().setAll(pane);
        appointmentsHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        appointmentsHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        patientHBox.setBackground(background2);
        visitorsHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complaintsHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);

    }

    @FXML
    void complaintsHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void dashboardHBox_MouseEvent(MouseEvent event) throws IOException {
        dashboardHBox.getStyleClass().add("hover_border");
        visitorsHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complaintsHBox.getStyleClass().add("hover_border");
        appointmentsHBox.getStyleClass().add("hover_border");
        patientHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_dashboard.fxml"));
        root.getChildren().setAll(pane);
        dashboardHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        dashboardHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        patientHBox.setBackground(background2);
        visitorsHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complaintsHBox.setBackground(background2);
        appointmentsHBox.setBackground(background2);

    }


    @FXML
    void patientHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void postalHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorsHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complaintsHBox.getStyleClass().add("hover_border");
        appointmentsHBox.getStyleClass().add("hover_border");
        patientHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_postal.fxml"));
        root.getChildren().setAll(pane);
        postalHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        postalHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        patientHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);
        visitorsHBox.setBackground(background2);
        complaintsHBox.setBackground(background2);
        appointmentsHBox.setBackground(background2);

    }

    @FXML
    void visitorsHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorsHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complaintsHBox.getStyleClass().add("hover_border");
        appointmentsHBox.getStyleClass().add("hover_border");
        patientHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_visitors.fxml"));
        root.getChildren().setAll(pane);
        visitorsHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        visitorsHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        patientHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complaintsHBox.setBackground(background2);
        appointmentsHBox.setBackground(background2);
    }

    @FXML
    void profileHBox_MouseEvent(MouseEvent event) {

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

    private void loadInitialPanel() throws IOException {
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_dashboard.fxml"));
        root.getChildren().setAll(pane);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardHBox.getStyleClass().add("hover_border");
        patientHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complaintsHBox.getStyleClass().add("hover_border");
        appointmentsHBox.getStyleClass().add("hover_border");
        visitorsHBox.getStyleClass().add("hover_border");


        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        dashboardHBox.setBackground(background);
        try {
            loadInitialPanel();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void transferMessage(String text) {
        profileNameTxt.setText(text);
    }
}

