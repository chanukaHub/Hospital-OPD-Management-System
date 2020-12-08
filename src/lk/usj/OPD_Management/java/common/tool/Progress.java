package lk.usj.OPD_Management.java.common.tool;

import com.jfoenix.controls.JFXProgressBar;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public final class Progress {
    private String title = "Loading";
    private String text = "Now Loading";
    private Pane root;
    private Label label;
    private VBox vBox;
    private Stage stage = new Stage();
    private JFXProgressBar progressBar;

//
//    Progress p = Progress.create(acImportStudentDetails, "Loading", "Connecting to database");
//                Progress.showProgress(p);
//                Progress.hideProgress(p);

    private Progress(Pane root) {
        stage.setIconified(false);
        stage.setAlwaysOnTop(true);
        stage.setTitle(title);
        vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(10);
        vBox.setPadding(new Insets(5));
        this.root = root;
        progressBar = new JFXProgressBar();
        label = new Label("Now loading");
        vBox.getChildren().setAll(label, progressBar);
        stage.setScene(new Scene(vBox, 300, 100));
        stage.initStyle(StageStyle.UNIFIED);
    }

    private Progress(Pane root, String title, String text) {
        this(root);
        this.title = title;
        this.text = text;
        label.setText(text);
    }

    public static Progress create(Pane root, String title, String text) {
        return new Progress(root, title, text);
    }

    public static Progress showProgress(Progress p) {
        p.stage.show();
        return p;
    }

    public static Progress setText(Progress p, String text) {
        p.label.setText(text);
        return p;
    }

    public static void hideProgress(Progress p) {
        p.stage.close();
    }

    private void setProgressValue(double value) {
        progressBar.setProgress(value);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


}


