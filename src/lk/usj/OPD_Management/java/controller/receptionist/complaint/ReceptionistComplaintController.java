package lk.usj.OPD_Management.java.controller.receptionist.complaint;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;

public class ReceptionistComplaintController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<ComplaintDTO> complainTable;

    @FXML
    private JFXButton saveBtn;

    @FXML
    void complainTable_MouseEvent(MouseEvent event) {

    }

    @FXML
    void saveBtn_OnAction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
