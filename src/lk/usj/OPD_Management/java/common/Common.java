package lk.usj.OPD_Management.java.common;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

public class Common {

    public static void showError(String message) {
        Alert a = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        setIconToTheAlert(a);
        a.showAndWait();
    }

    public static void showWarning(String message) {
        Alert a = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
        setIconToTheAlert(a);
        a.showAndWait();
    }

    public static boolean askQuestion(String message) {
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
        setIconToTheAlert(a);
        Optional<ButtonType> btSet = a.showAndWait();
        if (btSet.get() == ButtonType.YES)
            return true;
        else if (btSet.get() == ButtonType.NO)
            return false;
        else
            return false;
    }

    public static boolean askWarning(String message) {
        Alert a = new Alert(Alert.AlertType.WARNING, message, ButtonType.YES, ButtonType.NO);
        setIconToTheAlert(a);
        Optional<ButtonType> btSet = a.showAndWait();
        if (btSet.get() == ButtonType.YES)
            return true;
        else if (btSet.get() == ButtonType.NO)
            return false;
        else
            return false;
    }

    public static void showMessage(String message) {

        Alert a = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
        setIconToTheAlert(a);
        a.showAndWait();
    }

    private static void setIconToTheAlert(Alert a) {

    }

    public static Object removeItemFromTable(TableView table) {
        Object selectedItem = table.getSelectionModel().getSelectedItem();
        try {
            return selectedItem;
        } finally {
            table.getItems().remove(selectedItem);
        }
    }

    public static boolean isInteger(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static Date getDate(JFXDatePicker dt) {
        try {
            return java.sql.Date.valueOf(dt.getValue());
        } catch (Exception e) {
            return null;
        }
    }

    public static void loadClass(JFXComboBox cboxClass) {
        cboxClass.getItems().addAll("A", "B", "C", "D");
    }

    public static void loadGrade(JFXComboBox cboxGrade) {
        cboxGrade.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "Left");
    }

    public static Integer[] loadYear() {
        final int year = LocalDate.now().getYear();
        return new Integer[]{year - 3, year - 2, year - 1, year};
    }

    public static LocalDate dateToLocalDate(Date dt) {
        try {
            return new java.sql.Date(dt.getTime()).toLocalDate();
        } catch (Exception e) {
            return null;
        }
    }

    public static Date localDateToDate(LocalDate dt) {
        try {
            return java.sql.Date.valueOf(dt);
        } catch (Exception e) {
            return null;
        }
    }

}
