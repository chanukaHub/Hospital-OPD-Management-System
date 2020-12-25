package lk.usj.OPD_Management.java.controller.receptionist.postal;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class ReceptionistPostalDispatchedTableController implements Initializable {
    private PostalBO postalBO = new PostalBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<PostalDTO> dispatchedTable;

    @FXML
    void dispatchedTable_MouseEvent(MouseEvent event) {

    }
    private void loadDispatchedPostalTable() throws Exception {
        dispatchedTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("referenceNumber"));
        dispatchedTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fromName"));
        dispatchedTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("toName"));
        dispatchedTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("postalDate"));
        dispatchedTable.setItems(FXCollections.observableArrayList(postalBO.getDispatchedPostalList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadDispatchedPostalTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

