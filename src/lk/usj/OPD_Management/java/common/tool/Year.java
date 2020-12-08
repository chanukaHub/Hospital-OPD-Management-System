package lk.usj.OPD_Management.java.common.tool;

import java.time.LocalDate;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 7/22/2018
 * Time: 11:38 AM
 */

public final class Year {
    public static final Year ALL = new Year(-1);
    private static Year[] years;
    private final int year;
    private String name;

    public Year(int year) {
        this.year = year;
        if (year == -1)
            this.name = "All";
        else
            this.name = String.valueOf(year);

    }

    public static Year[] getAllYear() {
        if (years == null) {
            final int year = LocalDate.now().getYear();
            return years = new Year[]{
                    new Year(year - 3),
                    new Year(year - 2),
                    new Year(year - 1),
                    new Year(year)
            };
        } else
            return years;

    }

    public boolean isForAll() {
        return this.year == -1;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year1 = (Year) o;
        return this.year == year1.year;
    }

    public int getYear() {
        return year;
    }
}
