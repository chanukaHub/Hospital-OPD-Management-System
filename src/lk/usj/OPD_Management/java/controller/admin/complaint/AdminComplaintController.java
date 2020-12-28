package lk.usj.OPD_Management.java.controller.admin.complaint;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.ComplaintDTO;

public class AdminComplaintController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<ComplaintDTO> complaintTable;

    @FXML
    void complaintTable_MouseEvent(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
