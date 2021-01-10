/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ItemEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author KSGamer
 */
public class Behavior {
    
    public void setToNull(JFrame window) {
        window.setLocationRelativeTo(null);
    }
    
    public void reveal(java.awt.event.ItemEvent evt, JPasswordField field) {
        field.setEchoChar((evt.getStateChange() == ItemEvent.SELECTED) ? (char) 0 : '\u25cf');
    }
    
    public void exit(JFrame window) {
        window.dispose();
        System.exit(0);
    }
    
    public void minimize(JFrame window) {
        window.setExtendedState(ICONIFIED);
    }
    
    public void clear(JTextField field) {
        field.setText((field.getText().contains("Ingresa") || field.getText().contains("Buscar") || field.getText().contains("Ingrese")) ? "" : field.getText());
    }
    
    public void clear(JPasswordField field) {
        String hideField = String.valueOf(field.getPassword());
        field.setText((hideField.contains("Ingresa") || hideField.contains("Ingrese")) ? "" : hideField);
    }
    
    public void defaultField(JTextField field, String description) {
        if (field.getText().equals("")) {
            field.setText(description);
        }
    }
    
    public void defaultField(JPasswordField field, String description) {
        if (String.valueOf(field.getPassword()).equals("")) {
            field.setText(description);
        }
    }
    
    public void hoverEfectExit(JButton button, boolean event) {
        new Thread(() -> {
            for (int i = (event) ? 255 : 0; (event) ? i >= 0 : i <= 255; i = (event) ? i - 3 : i + 3) {
                button.setIcon(new ImageIcon((event) ? "src/image/Cross_White.png" : "src/image/Cross_Black.png"));
                try {
                    button.setBackground(new Color(255, i, i));
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
    
    public void hoverEfectMinimize(JButton button, boolean event) {
        new Thread(() -> {
            for (int i = (event) ? 255 : 230; (event) ? i >= 230 : i <= 255; i = (event) ? i - 1 : i + 1) {
                try {
                    button.setBackground(new Color(i, i, i));
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
