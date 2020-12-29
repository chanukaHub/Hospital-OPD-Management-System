package lk.usj.OPD_Management.java.controller.admin;

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

public class AdminBaseController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private HBox visitorHBox;

    @FXML
    private HBox postalHBox;

    @FXML
    private HBox complainsHBox;

    @FXML
    private HBox appointmentHBox;


    @FXML
    private HBox userHBox;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    private AnchorPane root;


    @FXML
    void appointmentsHBox_MouseEvent(MouseEvent event) throws Exception{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_appointments.fxml"));
        root.getChildren().setAll(pane);
        appointmentHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        appointmentHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        userHBox.setBackground(background2);
        visitorHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complainsHBox.setBackground(background2);

        dashboardHBox.setBackground(background2);
    }

    @FXML
    void complaintsHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_complaints.fxml"));
        root.getChildren().setAll(pane);
        complainsHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        complainsHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        userHBox.setBackground(background2);
        visitorHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);

        appointmentHBox.setBackground(background2);
    }

    @FXML
    void dashboardHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        HBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_dashboard.fxml"));
        root.getChildren().setAll(pane);
        dashboardHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        dashboardHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        userHBox.setBackground(background2);
        visitorHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complainsHBox.setBackground(background2);

        appointmentHBox.setBackground(background2);

    }
    @FXML
    void visitorsHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_visitors.fxml"));
        root.getChildren().setAll(pane);
        visitorHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        visitorHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        userHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complainsHBox.setBackground(background2);

        appointmentHBox.setBackground(background2);

    }

    @FXML
    void postalHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_postal.fxml"));
        root.getChildren().setAll(pane);
        postalHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        postalHBox.setBackground(background);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        userHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);
        visitorHBox.setBackground(background2);
        complainsHBox.setBackground(background2);

        appointmentHBox.setBackground(background2);

    }

    @FXML
    void referenceHBox_MouseEvent(MouseEvent event) {

    }

    @FXML
    void usersHBox_MouseEvent(MouseEvent event) throws IOException{
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");

        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_users.fxml"));
        root.getChildren().setAll(pane);
        userHBox.getStyleClass().removeAll("hover_border");

        BackgroundFill background_fill1 = new BackgroundFill(Color.rgb(80, 157, 255), CornerRadii.EMPTY, Insets.EMPTY);
        Background background1 = new Background(background_fill1);
        userHBox.setBackground(background1);

        BackgroundFill background_fill2 = new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY);
        Background background2 = new Background(background_fill2);
        visitorHBox.setBackground(background2);
        dashboardHBox.setBackground(background2);
        postalHBox.setBackground(background2);
        complainsHBox.setBackground(background2);

        appointmentHBox.setBackground(background2);

    }

    @FXML
    void logoutBtn_ActionEvent(ActionEvent event){
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
        HBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_dashboard.fxml"));
        root.getChildren().setAll(pane);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardHBox.getStyleClass().add("hover_border");
        visitorHBox.getStyleClass().add("hover_border");
        postalHBox.getStyleClass().add("hover_border");
        complainsHBox.getStyleClass().add("hover_border");
        appointmentHBox.getStyleClass().add("hover_border");

        userHBox.getStyleClass().add("hover_border");


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
        nameTxt.setText(text);
    }
}