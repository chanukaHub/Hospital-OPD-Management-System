package lk.usj.OPD_Management.java.common.tool;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 7/18/2018
 * Time: 9:13 PM
 */
public class House {

    private static String house_0 = "0";
    private static String house_1 = "1";
    private static String house_2 = "2";
    private static String house_3 = "3";

    private static House[] allHouses;

    static {
        try {
            File file = new File("resources/houses.properties");
            FileReader fileReader = new FileReader(file);
            Properties properties = new Properties();
            properties.load(fileReader);

            house_0 = properties.getProperty("0");
            house_1 = properties.getProperty("1");
            house_2 = properties.getProperty("2");
            house_3 = properties.getProperty("3");

            allHouses = new House[]{
                    new House(0),
                    new House(1),
                    new House(2),
                    new House(3),
            };
        } catch (IOException e) {
            Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private int houseValue;
    private String houseName;

    public House(int houseValue) {
        if (houseValue >= 4 || houseValue < 0) throw new IndexOutOfBoundsException("Not a house value");
        this.houseValue = houseValue;
        switch (houseValue % 4) {
            case 0:
                houseName = house_0;
                break;
            case 1:
                houseName = house_1;
                break;
            case 2:
                houseName = house_2;
                break;
            case 3:
                houseName = house_3;
                break;
            default:
                houseName = String.valueOf(houseValue % 4);
        }
    }

    public static House[] getAllHouses() {
        return allHouses;
    }

    public int getHouseValue() {
        return houseValue;
    }

    @Override
    public String toString() {
        return houseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return houseValue == house.houseValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(houseValue);
    }
}
