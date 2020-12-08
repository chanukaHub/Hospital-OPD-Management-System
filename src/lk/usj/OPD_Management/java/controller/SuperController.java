package lk.usj.OPD_Management.java.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 8/10/2018
 * Time: 9:15 PM
 */
public abstract class SuperController {
    protected final void callLogger(Throwable t) {
        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, t);
    }
}
