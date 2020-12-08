package lk.usj.OPD_Management.java.common.tool;

import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Date;
import java.util.Locale;

public final class DateRange {

    public static final int ALL = 0;
    public static final int IN_THIS_WEEK = 1;
    public static final int IN_THIS_MONTH = 2;
    public static final int IN_THIS_YEAR = 3;

    private static LocalDate today;
    private static TemporalField woy;
    private static int week_today;

    static {
        today = LocalDate.now();
        woy = WeekFields.of(Locale.FRANCE).weekOfWeekBasedYear();
        week_today = today.get(woy);
    }

    public static String[] getDateRanges() {
        return new String[]{
                "All",
                "This week",
                "This month",
                "This year"
        };
    }

    public static boolean checkInRange(Range range, Date date) {
        switch (range) {
            case WEEK:
                return isInThisWeek(date);
            case MONTH:
                return isInThisMonth(date);
            case YEAR:
                return isInThisYear(date);
            case ALL:
                return true;
            default:
                return false;
        }
    }

    private static boolean isInThisMonth(Date dt) {
        LocalDate date = Common.dateToLocalDate(dt);
        return today.getMonth() == date.getMonth() && isInThisYear(dt);
    }


    private static boolean isInThisWeek(Date dt) {
        LocalDate date = Common.dateToLocalDate(dt);
        int week_day = date.get(woy);
        return week_day == week_today && isInThisMonth(dt);

    }

    private static boolean isInThisYear(Date dt) {
        LocalDate date = Common.dateToLocalDate(dt);
        return date.getYear() == today.getYear();
    }

    public enum Range {
        WEEK, MONTH, YEAR, ALL
    }
}
