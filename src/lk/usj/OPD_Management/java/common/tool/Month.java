package lk.usj.OPD_Management.java.common.tool;

public final class Month {
    public static int ALL = -1;
    public static int NONE = 0;
    public static int JANUARY = 1;
    public static int FEBRUARY = 2;
    public static int MARCH = 3;
    public static int APRIL = 4;
    public static int MAY = 5;
    public static int JUNE = 6;
    public static int JULY = 7;
    public static int AUGUST = 8;
    public static int SEPTEMBER = 9;
    public static int OCTOBER = 10;
    public static int NOVEMBER = 11;
    public static int DECEMBER = 12;

    static Month[] months;

    private int value;

    public Month(int value) {
        this.value = value;
    }

    public static Month[] getAllMonth() {
        if (months == null) {
            final Month[] month_local = new Month[12];
            for (int i = 1; i <= 12; i++) {
                month_local[i - 1] = new Month(i);
            }
            months = month_local;
        }
        return months;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        switch (value) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            case -1:
                return "All";
            case 0:
                return "-";
            default:
                return "ERROR";

        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month = (Month) o;
        return value == month.value;
    }
}
