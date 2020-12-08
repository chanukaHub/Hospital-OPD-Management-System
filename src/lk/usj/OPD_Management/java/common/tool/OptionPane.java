package lk.usj.OPD_Management.java.common.tool;//package lk.ijse.salun.common.tool;
//
//import javafx.geometry.Pos;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
//import java.util.Optional;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @author pandu
// * Date: 6/21/2018
// * Time: 4:43 PM
// */
//
//public final class OptionPane {
//
//    public static void showErrorAtSide(String message) {
//        final Notifications notifications = Notifications.create()
//                .title("Error")
//                .position(Pos.CENTER_RIGHT)
//                .text(message)
//                .graphic(new ImageView(ApplicationIcons.getErrorIcon()))
//                .hideCloseButton();
//        notifications.show();
//    }
//
//    public static void showMessageAtSide(String message) {
//        final Notifications notifications = Notifications.create()
//                .title("Alerts")
//                .position(Pos.CENTER_RIGHT)
//                .text(message)
//                .graphic(new ImageView(ApplicationIcons.getInfoIcon()))
//                .hideCloseButton();
//        notifications.show();
//    }
//
//    public static void showErrorWherever(String message, Pos pos, Stage stage) {
//        final Notifications notifications = Notifications.create()
//                .title("Error")
//                .position(pos)
//                .text(message)
//                .owner(stage)
//                .graphic(new ImageView(ApplicationIcons.getErrorIcon()))
//                .hideCloseButton();
//        notifications.hideAfter(Duration.millis(950));
//        notifications.show();
//    }
//
//    public static void showError(String message) {
//        Alert a = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
//        a.setGraphic(new ImageView(ApplicationIcons.getErrorIcon()));
//        setIconToTheAlert(a);
//        a.showAndWait();
//    }
//
//    public static void showWarning(String message) {
//        Alert a = new Alert(Alert.AlertType.WARNING, message, ButtonType.OK);
//        a.setGraphic(new ImageView(ApplicationIcons.getWarningIcon()));
//        setIconToTheAlert(a);
//        a.showAndWait();
//    }
//
//    public static boolean askQuestion(String message) {
//        Alert a = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.YES, ButtonType.NO);
//        a.setGraphic(new ImageView(ApplicationIcons.getQuestionIcon()));
//        setIconToTheAlert(a);
//        return returnButtonSetResult(a.showAndWait());
//    }
//
//
//    public static ButtonType askQuestion(String message, ButtonType... types) {
//        Alert s = new Alert(Alert.AlertType.CONFIRMATION);
//        s.getButtonTypes().setAll(types);
//
//        s.setGraphic(new ImageView(ApplicationIcons.getQuestionIcon()));
//        setIconToTheAlert(s);
//        return s.showAndWait().get();
//    }
//
//    public static boolean askWarning(String message) {
//        Alert a = new Alert(Alert.AlertType.WARNING, message, ButtonType.YES, ButtonType.NO);
//        a.setGraphic(new ImageView(ApplicationIcons.getWarningIcon()));
//        setIconToTheAlert(a);
//        return returnButtonSetResult(a.showAndWait());
//    }
//
//    private static boolean returnButtonSetResult(Optional<ButtonType> btSet) {
//        if (btSet.get() == ButtonType.YES)
//            return true;
//        else if (btSet.get() == ButtonType.NO)
//            return false;
//        else
//            return false;
//    }
//
//    public static void showMessage(String message) {
//        Alert a = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
//        a.setGraphic(new ImageView(ApplicationIcons.getInfoIcon()));
//        setIconToTheAlert(a);
//        a.showAndWait();
//    }
//
//    public static void showDoneAtSide(String message) {
//        Notifications notifications = Notifications.create()
//                .title("Done")
//                .position(Pos.CENTER_RIGHT)
//                .text(message)
//                .graphic(new ImageView(ApplicationIcons.getDoneIcon()))
//                .hideCloseButton();
//        notifications.show();
//    }
//
//    public static void showWarningAtSide(String message) {
//        Notifications notifications = Notifications.create()
//                .title("Warning")
//                .position(Pos.CENTER_RIGHT)
//                .text(message)
//                .graphic(new ImageView(ApplicationIcons.getWarningIcon()))
//                .hideCloseButton();
//        notifications.show();
//    }
////
////    public static int askCustomQuestion(){
////
////
////
////        List<CommandLinksDialog.CommandLinksButtonType> links = new ArrayList<>();
////
////        links.add(new CommandLinksDialog.CommandLinksButtonType("Go to the Zoo",
////                "Here you will see zebras, monkeys, lions, elephants, and maybe also an alligator.", false));
////        links.add(new CommandLinksDialog.CommandLinksButtonType("Go to the Circus",
////                "Watch acrobats fly around and clowns, of course.", true));
////        links.add(new CommandLinksDialog.CommandLinksButtonType("Stay Home",
////                "Watch TV or play some board games with your siblings.", false));
////
////        Action response = Dialogs.create()
////                .title("Command Link Dialog")
////                .masthead(null)
////                .message("Where do you want to go?")
////                .showCommandLinks(links);
////
////    }
//
//    private static void setIconToTheAlert(Alert a) {
//        Stage stage = (Stage) a.getDialogPane().getScene().getWindow();
//        stage.getIcons().add(ApplicationIcons.getDefaultIcon());
//    }
//
////    public static String getTextInput(String s) {
////        return getTextInput(null, s);
////    }
//
////    public static String getTextInput(Stage owner, String s) {
////        return Dialogs.create()
////                .owner(owner)
////                .title(s)
////                .graphic(new ImageView(ApplicationIcons.getQuestionIcon()))
////
////                .showTextInput().get();
////    }
//}
