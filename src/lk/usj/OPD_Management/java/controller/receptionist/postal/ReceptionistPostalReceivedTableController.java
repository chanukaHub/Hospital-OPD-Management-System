package lk.usj.OPD_Management.java.controller.receptionist.postal;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.controller.admin.user.AdminUserEditDeleteDoctorController;
import lk.usj.OPD_Management.java.dto.DoctorDTO;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class ReceptionistPostalReceivedTableController implements Initializable {
    private PostalBO postalBO = new PostalBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<PostalDTO> receivedPostalTable;

    @FXML
    void receivedPostalTable_OnAction(MouseEvent event) throws Exception{
        PostalDTO postalDTO=(receivedPostalTable.getSelectionModel().getSelectedItem());
        if(postalDTO == null){
            Common.showWarning("Please select Doctor records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_editReceivedPostal.fxml"));
        Parent root = loader.load();
        ReceptionistPostalEditReceivedPostalController receptionistPostalEditReceivedPostalController = loader.getController();
        receptionistPostalEditReceivedPostalController.transferMessage(postalDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/receptionist/receptionist_postal_receivedTable.fxml"));
        this.root.getChildren().setAll(pane);

    }

    private void loadReceivedPostalTable() throws Exception {
        receivedPostalTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("referenceNumber"));
        receivedPostalTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("fromName"));
        receivedPostalTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("toName"));
        receivedPostalTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("postalDate"));
        receivedPostalTable.setItems(FXCollections.observableArrayList(postalBO.getReceivedPostalList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadReceivedPostalTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}