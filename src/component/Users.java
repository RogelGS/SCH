/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package component;

import controller.UsersController;
import utility.Behavior;

/**
 *
 * @author KSGamer
 */
public class Users extends javax.swing.JPanel {
    
    private final Behavior behavior = new Behavior();
    private final UsersController users = new UsersController();

    /**
     * Creates new form Users
     */
    public Users() {
        initComponents();
        this.behavior.adjust(this);
        this.behavior.setScroll(scrollPane);
        this.users.loadUsers(this.pContenedor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane = new javax.swing.JScrollPane();
        pContenedor = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1100, 670));
        setLayout(null);

        scrollPane.setBorder(null);

        pContenedor.setBackground(new java.awt.Color(255, 255, 255));
        pContenedor.setLayout(new java.awt.GridLayout(0, 4, 10, 10));
        scrollPane.setViewportView(pContenedor);

        add(scrollPane);
        scrollPane.setBounds(20, 150, 1060, 480);

        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 150, 5);

        add(jPanel1);
        jPanel1.setBounds(0, 0, 1100, 5);

        jLabel2.setBackground(new java.awt.Color(21, 195, 202));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText(" Modulo alta de usuarios");
        jLabel2.setOpaque(true);
        add(jLabel2);
        jLabel2.setBounds(0, 5, 1100, 50);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Buscar:");
        add(jLabel3);
        jLabel3.setBounds(20, 80, 50, 20);

        jTextField1.setText("Buscar usuario");
        add(jTextField1);
        jTextField1.setBounds(20, 100, 260, 25);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pContenedor;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
}
