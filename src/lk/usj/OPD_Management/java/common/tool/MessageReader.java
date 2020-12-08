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
 * Date: 7/9/2018
 * Time: 1:43 PM
 */
public final class MessageReader {

    private static MessageReader ourInstance;

    static {
        try {
            ourInstance = new MessageReader();
        } catch (Exception e) {
            Logger.getLogger(MessageReader.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private HashMap<String, String> messages;

    private MessageReader() throws Exception {
        messages = new HashMap<>();

        File file = new File("resources/message.properties");
        FileReader fileReader = new FileReader(file);
        Properties properties = new Properties();
        properties.load(fileReader);

        String val = properties.getProperty("message0");

        for (int i = 0; val != null; i++) {
            String key = "message".concat(String.valueOf(i));
            messages.put(key, val);
            val = properties.getProperty(key);
        }

    }

    public static MessageReader getInstance() {
        return ourInstance;
    }

    public String getMessage(int i) {
        return messages.get("message".concat(String.valueOf(i)));
    }
}
