package lk.usj.OPD_Management.java.common.tool;

import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import lk.usj.OPD_Management.java.controller.SuperController;


public final class ScreenLoader extends SuperController {

    private static ScreenLoader ourInstance;

    static {
        ourInstance = new ScreenLoader();
    }

    private BorderPane borderPane;

    private ScreenLoader() {
    }

    public static ScreenLoader getInstance() {
        return ourInstance;
    }

    public void loadWindow(String url, Pane pane, Initializable controller) {
        try {
            Parent root = FXMLLoader.load(controller.getClass().getResource(url));

            Scene sc = new Scene(root);
            Stage window = (Stage) pane.getScene().getWindow();

            window.setScene(sc);
            window.show();
        } catch (Exception e) {
            callLogger(e);
        }
    }

    public Parent loadOnCenterOfBorderPane(String url, Pane where, Initializable controller) {
        try {
            FadeTransition t = new FadeTransition(Duration.millis(200), where);
            t.setFromValue(0.0);
            t.setToValue(5.0);
            t.play();

            Parent root = FXMLLoader.load(controller.getClass().getResource(url));
            borderPane.setCenter(root);

            return root;
        } catch (Exception e) {
            callLogger(e);
            return null;
        }
//       System.out.println("Pass");
//        where.getChildren().setAll(root);
    }

    public Object loadOnCenterOfBorderPaneAndCallController(String url, Pane where, Initializable controller) {
        try {
            FadeTransition t = new FadeTransition(Duration.millis(200), where);
            t.setFromValue(0.0);
            t.setToValue(5.0);
            t.play();
            FXMLLoader fxmlLoader = new FXMLLoader(controller.getClass().getResource(url));
            Parent root = fxmlLoader.load();
            borderPane.setCenter(root);
            System.out.println(root);
            return fxmlLoader.getController();

        } catch (Exception e) {
            callLogger(e);
            return null;
        }
//       System.out.println("Pass");
//        where.getChildren().setAll(root);
    }

    public void loadPanel(String url, Pane where, Initializable controller) {
        try {
            FadeTransition t = new FadeTransition(Duration.millis(200), where);
            t.setFromValue(0.0);
            t.setToValue(5.0);
            t.play();

            Parent root = FXMLLoader.load(controller.getClass().getResource(url));
            where.getChildren().setAll(root);

        } catch (Exception e) {
            callLogger(e);
        }
    }

    public void loadOnCenterOfBorderPane(String url, BorderPane borderPane, Initializable controller) {
        try {
            this.borderPane = borderPane;
            Parent root = FXMLLoader.load(controller.getClass().getResource(url));
            borderPane.setCenter(root);

            FadeTransition t = new FadeTransition(Duration.millis(200), borderPane.getCenter());
            t.setFromValue(0.0);
            t.setToValue(5.0);
            t.play();
        } catch (Exception e) {
            callLogger(e);
        }
    }

    public void loadInsidePanel(String url, Pane where, Initializable controller) {
        try {
            Pane root = FXMLLoader.load(controller.getClass().getResource(url));
            where.getChildren().add(root);
        } catch (Exception e) {
            callLogger(e);
        }
    }

    public <T extends SuperController> T loadNewWindow(String url, String title) {
        Stage window = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
            Pane p = fxmlLoader.load();

            window = new Stage();
            window.setScene(new Scene(p));
            window.setTitle(title);

//            window.getIcons().add(ApplicationIcons.getDefaultIcon());
            window.setMaximized(false);

            return (T) fxmlLoader.getController();
        } catch (Exception e) {
            callLogger(e);
            return null;
        } finally {
            window.show();
        }
    }

    public <T extends SuperController> T loadNewWindowAndWait(String url, String title) {
        Stage window = null;
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(url));
            Pane p = fxmlLoader.load();

            window = new Stage();
            window.setScene(new Scene(p));
            window.setTitle(title);

            window.initStyle(StageStyle.UTILITY);

//            window.getIcons().add(ApplicationIcons.getDefaultIcon());
            window.setMaximized(false);

            return (T) fxmlLoader.getController();
        } catch (Exception e) {
            callLogger(e);
            return null;
        } finally {
            window.showAndWait();
        }
    }

}
