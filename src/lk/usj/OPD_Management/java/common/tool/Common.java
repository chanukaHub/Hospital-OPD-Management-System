package lk.usj.OPD_Management.java.common.tool;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Date;

public final class Common {
    public static Object removeItemFromTable(TableView table) {
        Object selectedItem = table.getSelectionModel().getSelectedItem();
        try {
            return selectedItem;
        } finally {
            table.getItems().remove(selectedItem);
        }
    }

    public static void clearSortOrder(TableView... tables) {
        for (TableView t : tables)
            t.getSortOrder().clear();
    }

    public static void clearTextFields(TextField... textFields) {
        for (TextField t : textFields)
            t.clear();
    }

    public static void disableTextFields(boolean shouldDisable, TextField... textFields) {
        for (TextField t : textFields)
            t.setDisable(shouldDisable);
    }

    public static boolean isInteger(String text) {
        try {
            return !text.equals("") && (text.matches("[0-9]*"));
        } catch (Exception e) {
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

    public static String[] getResultSet() {
        return new String[]{
                "1st Place",
                "2nd Place",
                "3rd Place",
                "Participation"
        };
    }

    public static void loadClass(JFXComboBox cboxClass) {
        cboxClass.getItems().addAll("A", "B", "C", "D");
    }

    public static void loadGrade(JFXComboBox cboxGrade) {
        cboxGrade.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "Left");
    }

    public static void loadGradeForFiler(JFXComboBox cboxGrade) {
        cboxGrade.getItems().addAll("All", "1", "2", "3", "4", "5", "6", "7", "8", "9");
    }

    public static void loadClassForFiler(JFXComboBox cboxGrade) {
        cboxGrade.getItems().addAll("All", "A", "B", "C", "D");
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
