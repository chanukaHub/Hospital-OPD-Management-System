package lk.usj.OPD_Management.java.controller.receptionist.visitor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class ReceptionistVisitorController implements Initializable {
    private VisitorBO visitorBO=new VisitorBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<VisitorDTO> visitorTable;

    @FXML
    void visitorTable_OnAction(MouseEvent event) {

    }

    private void loadVisitorTable() throws Exception {
        visitorTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("visitorName"));
        visitorTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("nicNo"));
        visitorTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("date"));
        visitorTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("inTime"));
        visitorTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("outTime"));
        visitorTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("telNo"));
        visitorTable.setItems(FXCollections.observableArrayList(visitorBO.getAllVisitor()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadVisitorTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
