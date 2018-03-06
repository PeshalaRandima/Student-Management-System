/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.view.Login;

import gateway.controllers.AdministratorController;
import gateway.libraries.CurInstance;
import gateway.view.home.Home;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pesshala
 */
public class SplashScreen extends javax.swing.JFrame {

    boolean admin;

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen() {
        initComponents();
        //setOpacity(0.5F);
        setSize(650, 499);
                setLocationRelativeTo(null);


        new Thread(new Runnable() {
            int i = 0;

            public void run() {
                for (i = 0; i < 20; i++) {
                    progressBar.setValue(i);
                    labelpercent.setText(i + "%");
                    label.setText("Checking admin");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(LoadingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {

                    admin = AdministratorController.adminAvailable();

                } catch (SQLException ex) {
                    Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (admin) {
                    labelAdmin.setText("Admin Passed");

                } else {
                    labelAdmin.setText("No Admin Account");
                }

                int j;
                for (j = i; j < 40; j++) {
                    progressBar.setValue(j);
                    labelpercent.setText(j + "%");

                       
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(LoadingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                JOptionPane.showMessageDialog(null, "Your system date is" + CurInstance.Date_day() + " and time is " + CurInstance.Time_12_AMPM());
                labelDate.setText("Date and time checked");
                //JOptionPane.showMessageDialog(null, "peshala");
                int k;
                for (k = j; k < 60; k++) {
                    progressBar.setValue(k);
                    labelpercent.setText(k + "%");

                    //check for database
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(LoadingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //JOptionPane.showMessageDialog(null, "peshala");
                int l;
                for (l = k; l < 80; l++) {
                    progressBar.setValue(l);
                    labelpercent.setText(l + "%");

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(LoadingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //JOptionPane.showMessageDialog(null, "");
                int m;
                for (m = l; m <= 100; m++) {
                    progressBar.setValue(m);
                    labelpercent.setText(m + "%");

                    if (m == 100 && admin ) {
                        UserAccount userAccount = new UserAccount();
                        userAccount.setSize(loadpanel.getSize());
                        loadpanel.removeAll();
                        loadpanel.add(userAccount);
                        loadpanel.repaint();
                        loadpanel.revalidate();

                    }else if(m==100 && !admin){
                        
//                        CreateNewAdminFrame p=new CreateNewAdminFrame();
//                        p.setSize(loadpanel.getSize());
//                        p.setLocationRelativeTo(null);
//                        p.setVisible(true);
//                        
//                        dispose();
                        NewAdminAccount p = new NewAdminAccount();
                        p.setSize(loadpanel.getSize());
                        loadpanel.removeAll();
                        loadpanel.add(p);
                        loadpanel.repaint();
                        loadpanel.revalidate();
                }
                    

                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        //Logger.getLogger(LoadingForm.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                //JOptionPane.showMessageDialog(null, "peshala");

            }
        }).start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loadpanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        labelLock = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelAdmin = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        labelpercent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        loadpanel.setOpaque(false);
        loadpanel.setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 130, 20));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 130, 20));
        jPanel1.add(labelLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 130, 20));

        labelDate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 20));

        labelAdmin.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(labelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 20));

        loadpanel.add(jPanel1);
        jPanel1.setBounds(70, 90, 150, 350);
        loadpanel.add(label);
        label.setBounds(470, 210, 170, 20);

        labelpercent.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        loadpanel.add(labelpercent);
        labelpercent.setBounds(500, 80, 130, 90);

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Peshala\\OOD\\Gateway\\src\\gateway\\view\\Login\\images\\Splash1.png")); // NOI18N
        loadpanel.add(jLabel1);
        jLabel1.setBounds(0, 0, 650, 510);

        progressBar.setBackground(new java.awt.Color(255, 255, 255));
        loadpanel.add(progressBar);
        progressBar.setBounds(180, 0, 470, 14);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(loadpanel, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel label;
    private javax.swing.JLabel labelAdmin;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelLock;
    private javax.swing.JLabel labelpercent;
    private javax.swing.JPanel loadpanel;
    private javax.swing.JProgressBar progressBar;
    // End of variables declaration//GEN-END:variables
}
