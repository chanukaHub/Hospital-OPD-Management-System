package lk.usj.OPD_Management.java.controller;

import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SuperController {
    protected final void callLogger(Throwable t) {
        Logger.getLogger(SuperController.class.getName()).log(Level.SEVERE, null, t);
    }
}
