/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sch;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import model.UsersModel;
import utility.Encrypter;
import view.Login;

/**
 *
 * @author KSGamer
 */
public class SCH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            new Thread() {
                @Override
                public void run() {
                    Login login = new Login();
                    login.setVisible(true);
                }
            }.start();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(SCH.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
