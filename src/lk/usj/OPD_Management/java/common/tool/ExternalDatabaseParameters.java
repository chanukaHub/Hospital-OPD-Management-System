package lk.usj.OPD_Management.java.common.tool;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by IntelliJ IDEA.
 *
 * @author pandu
 * Date: 8/5/2018
 * Time: 6:31 PM
 */
public final class ExternalDatabaseParameters {

    private static ExternalDatabaseParameters ourInstance;

    static {
        try {
            ourInstance = new ExternalDatabaseParameters();
        } catch (Exception e) {
            Logger.getLogger(ExternalDatabaseParameters.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private HashMap<String, String> parms;

    private ExternalDatabaseParameters() throws Exception {
        parms = new HashMap<>();

        File file = new File("resources/ms_table_column_names.properties");
        FileReader fileReader = new FileReader(file);
        Properties pro = new Properties();
        pro.load(fileReader);

        parms.put("table_name", pro.getProperty("table_name"));
        parms.put("SID", pro.getProperty("SID"));
        parms.put("sName", pro.getProperty("sName"));
        parms.put("gender", pro.getProperty("gender"));
        parms.put("DOB", pro.getProperty("DOB"));
        parms.put("class", pro.getProperty("class"));
        parms.put("father_name", pro.getProperty("father_name"));
        parms.put("mother_name", pro.getProperty("mother_name"));
        parms.put("address", pro.getProperty("address"));
        parms.put("quit", pro.getProperty("quit"));
        parms.put("BCID", pro.getProperty("BCID"));
        parms.put("desc", pro.getProperty("desc"));
    }

    public static ExternalDatabaseParameters getInstance() {
        return ourInstance;
    }

    public HashMap<String, String> getParms() {
        return parms;
    }

}
