package lk.usj.OPD_Management.java.controller.admin;

import java.io.IOException;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import lk.usj.OPD_Management.java.common.Common;
import lk.usj.OPD_Management.java.dto.ReceptionistDTO;
import lk.usj.OPD_Management.java.service.custom.ReceptionistBO;
import lk.usj.OPD_Management.java.service.custom.impl.ReceptionistBOImpl;

public class AdminUserViewReceptionistTableController implements Initializable {
    private ReceptionistBO receptionistBO= new ReceptionistBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<ReceptionistDTO> receptionistTable;

    @FXML
    void receptionistTable_MouseEvent(MouseEvent event) throws IOException {
        ReceptionistDTO receptionistDTO=(receptionistTable.getSelectionModel().getSelectedItem());
        if(receptionistDTO == null){
            Common.showWarning("Please select Receptionist records");
            return;
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/lk/usj/OPD_Management/resources/view/admin_users_editReceptionist.fxml"));
        Parent root = loader.load();
        AdminUserEditDeleteReceptionistController adminUserEditDeleteReceptionistController = loader.getController();
        adminUserEditDeleteReceptionistController.transferMessage(receptionistDTO);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        //stage.setTitle("");
        stage.centerOnScreen();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

        try {
            loadReceptionistTable();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void loadReceptionistTable() throws Exception {
        receptionistTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("staffID"));
        receptionistTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        receptionistTable.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("idCard"));
        receptionistTable.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        receptionistTable.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("staffEmail"));
        receptionistTable.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("gender"));
        receptionistTable.setItems(FXCollections.observableArrayList(receptionistBO.getAllReceptionist()));
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadReceptionistTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



