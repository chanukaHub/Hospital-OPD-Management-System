package lk.usj.OPD_Management.java.controller.admin.postal;

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
import lk.usj.OPD_Management.java.controller.receptionist.postal.ReceptionistPostalEditReceivedPostalController;
import lk.usj.OPD_Management.java.dto.PostalDTO;
import lk.usj.OPD_Management.java.service.custom.PostalBO;
import lk.usj.OPD_Management.java.service.custom.impl.PostalBOImpl;

public class AdminPostalController implements Initializable {
    private PostalBO postalBO = new PostalBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox root;

    @FXML
    private TableView<PostalDTO> postalTable;

    @FXML
    void postalTable_MouseEvent(MouseEvent event) throws Exception{
        PostalDTO postalDTO=(postalTable.getSelectionModel().getSelectedItem());
        if(postalDTO == null){
            Common.showWarning("Please select Postal records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_postal_deletePostal.fxml"));
        Parent root = loader.load();
        AdminPostalDeleteViewController adminPostalDeleteViewController = loader.getController();
        adminPostalDeleteViewController.transferMessage(postalDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        Pane pane= FXMLLoader.load(this.getClass().getResource("/lk/usj/OPD_Management/resources/view/admin/admin_postal.fxml"));
        this.root.getChildren().setAll(pane);

    }

    private void loadPostalTable() throws Exception {
        postalTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("referenceNumber"));
        postalTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("postalDate"));
        postalTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fromName"));
        postalTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("toName"));
        postalTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("type"));

        postalTable.setItems(FXCollections.observableArrayList(postalBO.getPostalList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadPostalTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
