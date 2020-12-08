package lk.usj.OPD_Management.java.common.tool;//package lk.ijse.login.tool;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//
//import java.io.File;
//import java.io.FileReader;
//import java.util.Properties;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// * Created by IntelliJ IDEA.
// *
// * @author pandu
// * Date: 7/22/2018
// * Time: 11:24 AM
// */
//public final class Terms {
//    private static Terms ourInstance;
//
//    static {
//        try {
//            ourInstance = new Terms();
//        } catch (Exception e) {
//            Logger.getLogger(Terms.class.getName()).log(Level.SEVERE, null, e);
//        }
//    }
//
//    private ObservableList<TermDTO> terms;
//
//    private Terms() throws Exception {
//        terms = FXCollections.observableArrayList();
//        File file = new File("resources/terms.properties");
//        FileReader fileReader = new FileReader(file);
//        Properties properties = new Properties();
//        properties.load(fileReader);
//        String val;
//        for (int i = 0; true; i++) {
//            String key = "term".concat(String.valueOf(i));
//            val = properties.getProperty(key);
//            if (val == null) break;
//            terms.add(new TermDTO(val, i));
//        }
//    }
//
//    public static Terms getInstance() {
//        return ourInstance;
//    }
//
//    public ObservableList<TermDTO> getTerms() {
//        return terms;
//    }
//}
