package lk.usj.OPD_Management.java.controller.admin.visitor;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.receptionist.visitor.ReceptionistVisitorEditVisitorController;
import lk.usj.OPD_Management.java.dto.VisitorDTO;
import lk.usj.OPD_Management.java.entity.Visitor;
import lk.usj.OPD_Management.java.service.custom.VisitorBO;
import lk.usj.OPD_Management.java.service.custom.impl.VisitorBOImpl;

public class AdminVisitorController implements Initializable {
    private VisitorBO visitorBO =new VisitorBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<VisitorDTO> visitorTable;

    @FXML
    void visitorTable_MouseEvent(MouseEvent event) throws Exception{
        VisitorDTO visitorDTO=(visitorTable.getSelectionModel().getSelectedItem());
        if(visitorDTO == null){
            Common.showWarning("Please select visitor records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_visitors_deleteVisitor.fxml"));
        Parent root = loader.load();
        AdminVisitorDeleteViewController adminVisitorDeleteViewController = loader.getController();
        adminVisitorDeleteViewController.transferMessage(visitorDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_visitors.fxml"));
        this.root.getChildren().setAll(pane);

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
