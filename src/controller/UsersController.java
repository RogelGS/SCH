/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.UsersModel;
import object.UsersObject;
import utility.Behavior;
import utility.AddUser;
import utility.LoadUser;

/**
 *
 * @author KSGamer
 */
public class UsersController {

    private final UsersModel model = new UsersModel();
    private final Behavior behavior = new Behavior();
    private final AddUser addUser = new AddUser();
    private LoadUser loadUser;

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

        this.behavior.openMain(login);

        return true;
    }
    
    public void loadUsers(JPanel container) {
        container.removeAll();
        for (UsersObject userObject : this.model.getUsers()) {
            this.loadUser = new LoadUser();
            container.add(this.loadUser.setPersonality(userObject.getUsername()));
        }
        container.add(this.addUser);
        if(container.getComponentCount() <= 11) {
            for (int i = container.getComponentCount(); i < 12; i++) {
                JPanel panel = new JPanel();
                panel.setBackground(Color.WHITE);
                container.add(panel);
            }
        }
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

            this.behavior.openMain(login);
        }
        return true;
    }
    
    
}
