/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONObject;

/**
 *
 * @author KSGamer
 */
public class FileCreator {
    private final File file = new File("settings.json");

    public FileCreator() {
        if(!this.file.exists()) {
            try {
                this.file.createNewFile();
                fileWriter(defaultSettings("", "", 0, "", "", "").toJSONString());
            } catch (IOException ex) {
                Logger.getLogger(FileCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void fileWriter(String dates) {
        FileWriter write = null;
        try {
            write = new FileWriter(this.file);
            try (BufferedWriter buffer = new BufferedWriter(write)) {
                buffer.write(dates);
                buffer.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(FileCreator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                write.close();
            } catch (IOException ex) {
                Logger.getLogger(FileCreator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public JSONObject defaultSettings(String server, String instance, int port, String dateBase, String user, String password) {
        JSONObject object = new JSONObject();
        object.put("SERVER", server);
        object.put("INSTANCE", instance);
        object.put("PORT", port);
        object.put("DATABASE", dateBase);
        object.put("USER", user);
        object.put("PASSWORD", password);
        return object;
    }
    
    public File path() {
        return this.file;
    }
}
