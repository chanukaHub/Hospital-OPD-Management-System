package lk.usj.OPD_Management.java.controller.admin.dashboard;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.text.Text;
import lk.usj.OPD_Management.java.dto.LoginDTO;
import lk.usj.OPD_Management.java.service.custom.LoginBO;
import lk.usj.OPD_Management.java.service.custom.impl.LoginBOImpl;

public class AdminDashboardController implements Initializable {
    private LoginBO loginBO =new LoginBOImpl();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> RequestTable;

    @FXML
    private Text TodayAppointmentText;

    @FXML
    private Text numberOfPatientText;

    @FXML
    private Text openComplaintsText;

    @FXML
    private TableView<LoginDTO> loginUserTable;

    @FXML
    void RequestTable_MouseEvent(MouseEvent event) {

    }

    private void loadLoginUserTable() throws Exception {

        loginUserTable.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("userName"));
        loginUserTable.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("userType"));

        loginUserTable.setItems(FXCollections.observableArrayList(loginBO.getLatestLoginUserList()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadLoginUserTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
