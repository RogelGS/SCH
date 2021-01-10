/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import datebase.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import object.UsersObject;

/**
 *
 * @author KSGamer
 */
public class UsersModel {
    
    private final Connect connection = new Connect();
    private ResultSet rs;
    private PreparedStatement ps;
    
    private ArrayList<UsersObject> list = new ArrayList<>();

    public UsersModel() {
        try {
            this.ps = this.connection.getLink().prepareStatement("SELECT * FROM USERS");
            this.rs = this.ps.executeQuery();
            while(this.rs.next()) {
                list.add(new UsersObject(rs.getString(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsersModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<UsersObject> getUsers() {
        return list;
    }
}
