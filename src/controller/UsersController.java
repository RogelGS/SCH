/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.UsersModel;
import object.UsersObject;
import view.Main;

/**
 *
 * @author KSGamer
 */
public class UsersController {

    private final UsersModel model = new UsersModel();
    private final Main main = new Main();

    public boolean auth(JTextField user, JPasswordField password, JLabel notify, JButton button, JFrame login) {
        boolean flag = false;
        button.setEnabled(flag);
        for (UsersObject userObject : this.model.getUsers()) {
            if (user.getText().equals(userObject.getUsername())) {
                flag = true;
            }
        }
        if (flag == false) {
            notify.setText("<html><center>El usuario es incorrecto, verifiquelo nuevamente.</center></html>");
            button.setEnabled(!flag);
            return flag;
        }

        flag = false;

        for (UsersObject userObject : this.model.getUsers()) {
            if (String.valueOf(password.getPassword()).equals(userObject.getPassword())) {
                flag = true;
            }
        }
        if (flag == false) {
            notify.setText("<html><center>La contraseña es incorrecta, verifiquelo nuevamente.</center></html>");
            button.setEnabled(!flag);
            return flag;
        }

        flag = false;

        for (UsersObject userObject : this.model.getUsers()) {
            if (user.getText().equals(userObject.getUsername()) && String.valueOf(password.getPassword()).equals(userObject.getPassword())) {
                flag = true;
            }
        }
        if (flag == false) {
            notify.setText("<html><center>Las credenciales no coinciden, verifiquelo nuevamente.</center></html>");
            button.setEnabled(!flag);
            return flag;
        }

        for (double i = 1; i >= 0; i -= 0.01) {
            login.setOpacity((float) i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        login.setVisible(false);
        login.dispose();

        this.main.setVisible(true);

        return true;
    }

    public boolean auth(JTextField user, JPasswordField password, JLabel notify, JButton button, JFrame login, java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            boolean flag = false;
            button.setEnabled(flag);
            for (UsersObject userObject : this.model.getUsers()) {
                if (user.getText().equals(userObject.getUsername())) {
                    flag = true;
                }
            }
            if (flag == false) {
                notify.setText("<html><center>El usuario es incorrecto, verifiquelo nuevamente.</center></html>");
                button.setEnabled(!flag);
                return flag;
            }

            flag = false;

            for (UsersObject userObject : this.model.getUsers()) {
                if (String.valueOf(password.getPassword()).equals(userObject.getPassword())) {
                    flag = true;
                }
            }
            if (flag == false) {
                notify.setText("<html><center>La contraseña es incorrecta, verifiquelo nuevamente.</center></html>");
                button.setEnabled(!flag);
                return flag;
            }

            flag = false;

            for (UsersObject userObject : this.model.getUsers()) {
                if (user.getText().equals(userObject.getUsername()) && String.valueOf(password.getPassword()).equals(userObject.getPassword())) {
                    flag = true;
                }
            }
            if (flag == false) {
                notify.setText("<html><center>Las credenciales no coinciden, verifiquelo nuevamente.</center></html>");
                button.setEnabled(!flag);
                return flag;
            }

            for (double i = 1; i >= 0; i -= 0.01) {
                login.setOpacity((float) i);
                try {
                    Thread.sleep(2);
                } catch (InterruptedException ex) {
                    Logger.getLogger(UsersController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            login.setVisible(false);
            login.dispose();

            this.main.setVisible(true);
        }
        return true;
    }
    
    
}
