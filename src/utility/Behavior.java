/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import view.Login;
import view.Main;

/**
 *
 * @author KSGamer
 */
public class Behavior {

    public void setToNull(JFrame window) {
        window.setLocationRelativeTo(null);
    }
    
    public void startPanels(JPanel container, JPanel[] panels) {
        container.add(panels[0]);
    }
    
    public void swapPanels(JPanel panel, JPanel[] panels) {
        panels[0].setVisible(false);
        panel.setVisible(true);
    }
    
    public void adjust(JPanel panel) {
        panel.setBounds(0, 0, 1100, 670);
    }
    
    public void setScroll(JScrollPane scroll) {
        scroll.getVerticalScrollBar().setUnitIncrement(20);
        scroll.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
    }
    
    public void preconfig(JLabel lbCapsUser, JLabel lbCapsPassword) {
        lbCapsUser.setVisible(false);
        lbCapsPassword.setVisible(false);
    }

    public void reveal(java.awt.event.ItemEvent evt, JPasswordField field) {
        field.setEchoChar((evt.getStateChange() == ItemEvent.SELECTED) ? (char) 0 : '\u25cf');
    }

    public void exit(JFrame window) {
        window.dispose();
        System.exit(0);
    }

    public void minimize(JFrame window) {
        window.setExtendedState(JFrame.ICONIFIED);
    }

    public boolean checkField(JTextField field, JLabel notify, String message, java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (field.getText().equals("") || field.getText().contains("Ingrese") || field.getText().contains("Ingresa")) {
                notify.setText(message);
                return false;
            }
        }
        return true;
    }

    public boolean checkField(JTextField field, JLabel notify, String message) {
        if (field.getText().equals("") || field.getText().contains("Ingrese") || field.getText().contains("Ingresa")) {
            notify.setText(message);
            return false;
        }
        return true;
    }

    public boolean checkField(JPasswordField field, JLabel notify, String message, java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String fieldHide = String.valueOf(field.getPassword());
            if (fieldHide.equals("") || fieldHide.contains("Ingrese") || fieldHide.contains("Ingresa")) {
                notify.setText(message);
                return false;
            }
        }
        return true;
    }
    
    public void checkMayusc(JLabel icon) {
        icon.setVisible(Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK));
    }
    
    public void setIconDefaultMayusc(JLabel icon) {
        icon.setVisible(false);
    }

    public boolean checkField(JPasswordField field, JLabel notify, String message) {
        String fieldHide = String.valueOf(field.getPassword());
        if (fieldHide.equals("") || fieldHide.contains("Ingrese") || fieldHide.contains("Ingresa")) {
            notify.setText(message);
            return false;
        }
        return true;
    }

    public void clear(JTextField field) {
        field.setText((field.getText().contains("Ingresa") || field.getText().contains("Buscar") || field.getText().contains("Ingrese")) ? "" : field.getText());
    }

    public void clear(JPasswordField field) {
        String hideField = String.valueOf(field.getPassword());
        field.setText((hideField.contains("Ingresa") || hideField.contains("Ingrese")) ? "" : hideField);
    }

    public void defaultField(JTextField field, String description) {
        field.setText((field.getText().equals("")) ? description : field.getText());
    }

    public void defaultField(JPasswordField field, String description) {
        String hideField = String.valueOf(field.getPassword());
        field.setText((hideField.equals("")) ? description : hideField);
    }

    public void limiter(JTextField field, java.awt.event.KeyEvent event, int limiter) {
        if (field.getText().length() >= limiter) {
            event.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void limiter(JPasswordField field, java.awt.event.KeyEvent event, int limiter) {
        if (String.valueOf(field.getPassword()).length() >= limiter) {
            event.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void hoverEfectExit(JButton button, boolean event) {
        new Thread(() -> {
            for (int i = (event) ? 255 : 0; (event) ? i >= 0 : i <= 255; i = (event) ? i - 3 : i + 3) {
                try {
                    button.setBackground(new Color(255, i, i));
                    Thread.sleep(1);
                    button.setIcon(new ImageIcon((event) ? "src/image/Cross_White.png" : "src/image/Cross_Black.png"));
                } catch (InterruptedException ex) {
                    Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    public void hoverEfectTitleBar(JButton button, boolean event) {
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

    public void hoverEfectAuth(JButton button, boolean event) {
        new Thread(() -> {
            for (int i = (event) ? 240 : 230; (event) ? i >= 230 : i <= 240; i = (event) ? i - 1 : i + 1) {
                try {
                    button.setBackground(new Color(i, i, i));
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    public void openMain(JFrame window) {
        Main main = new Main();
        for (double i = 1; i >= 0; i -= 0.01) {
            window.setOpacity((float) i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        window.setVisible(false);
        window.dispose();
        main.setVisible(true);
    }

    public void openLogin(JFrame window) {
        Login login = new Login();
        for (double i = 1; i >= 0; i -= 0.01) {
            window.setOpacity((float) i);
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
                Logger.getLogger(Behavior.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        window.setVisible(false);
        window.dispose();
        login.setVisible(true);
    }

}
