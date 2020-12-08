package lk.usj.OPD_Management.java.common.tool;

public final class GlobalBoolean {

    private static boolean lock;

    public static boolean isLocked() {
        return lock;
    }

    public static void setLock(boolean lock) {
        GlobalBoolean.lock = lock;
    }

}
