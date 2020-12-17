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
import javafx.scene.layout.VBox;

public class Receptionist_PostalController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXButton postalRecivedBtn;

    @FXML
    private JFXButton postalDispatchedBtn;

    @FXML
    private AnchorPane root;

    @FXML
    private JFXButton addPostalBtn;

    @FXML
    private JFXButton editPostalBtn;

    @FXML
    private JFXButton deletePostalBtn;

    @FXML
    void addPostalBtn_OnAction(ActionEvent event) throws IOException {
        VBox pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist_postal_addPostal.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void deletePostalBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void editPostalBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void postalDispatchedBtn_OnAction(ActionEvent event) {

    }

    @FXML
    void postalRecivedBtn_OnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
