package lk.usj.OPD_Management.java.common.tool;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 7/11/2018
 * Time: 11:12 AM
 */
public final class ButtonFireForEnterSetter {


    public static void setGlobalEventHandler(Pane root) {
        new Thread(() -> setGlobalEventHandlerOnPrivate(root)).start();
    }

    private static void setGlobalEventHandlerOnPrivate(Pane root) {
        for (Node node : root.getChildren()) {
            if (node instanceof Pane)
                setGlobalEventHandlerOnPrivate((Pane) node);
            if (node instanceof Button) {
                node.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
                    if (ev.getCode() == KeyCode.ENTER) {
                        ((Button) node).fire();
                        ev.consume();
                    }
                });
            }
            if (node instanceof DatePicker) {
                node.addEventHandler(KeyEvent.KEY_PRESSED, ev -> {
                    if (ev.getCode() == KeyCode.ENTER) {
                        node.fireEvent(new ActionEvent());
                        ev.consume();
                    }
                });
            }
        }
    }

}
