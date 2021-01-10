/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datebase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KSGamer
 */
public class Connect {
    private Connection link = null;
    
    public Connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String route = "jdbc:sqlserver://localhost\\KSGAMER:1433;databaseName=SCH;user=developer;password=1234;";
            link = DriverManager.getConnection(route);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Connection getLink() {
        return link;
    }
}
