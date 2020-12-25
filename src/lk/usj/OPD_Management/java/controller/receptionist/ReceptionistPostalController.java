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

public class ReceptionistPostalController implements Initializable {
    String postalType = "received";
    @FXML
    private VBox mainRoot;

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
    void addPostalBtn_OnAction(ActionEvent event) throws IOException {
        if (postalType.equals("received")){
            Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_addReceivedPostal.fxml"));
            mainRoot.getChildren().setAll(pane);
        }else if (postalType.equals("Dispatched")){
            Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_addDispatchedPostal.fxml"));
            mainRoot.getChildren().setAll(pane);
        }
    }

    @FXML
    void postalDispatchedBtn_OnAction(ActionEvent event) throws Exception{
        postalRecivedBtn.getStyleClass().removeAll("selected_login_type_btn");
        postalDispatchedBtn.getStyleClass().removeAll("selected_login_type_btn");

        postalDispatchedBtn.getStyleClass().add("selected_login_type_btn");
        postalRecivedBtn.getStyleClass().add("login_type_btn");
        postalType ="Dispatched";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_receivedTable.fxml"));
        root.getChildren().setAll(pane);
    }

    @FXML
    void postalRecivedBtn_OnAction(ActionEvent event) throws Exception{
        postalRecivedBtn.getStyleClass().removeAll("selected_login_type_btn");
        postalDispatchedBtn.getStyleClass().removeAll("selected_login_type_btn");

        postalRecivedBtn.getStyleClass().add("selected_login_type_btn");
        postalDispatchedBtn.getStyleClass().add("login_type_btn");
        postalType = "received";

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_dispatchedTable.fxml"));
        root.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        postalRecivedBtn.getStyleClass().add("selected_login_type_btn");
        postalDispatchedBtn.getStyleClass().add("login_type_btn");

        Pane pane= null;
        try {
            pane = FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_receivedTable.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().setAll(pane);
    }
}
