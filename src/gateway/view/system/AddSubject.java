/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.view.system;

import gateway.controllers.StreamController;
import gateway.controllers.StreamedSubjectController;
import gateway.controllers.SubjectController;
import gateway.model.Subject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class AddSubject extends javax.swing.JPanel {
    DefaultListModel<String> dlmAvailable=new DefaultListModel<>();
    DefaultListModel<String> dlmViewSubject=new DefaultListModel<>();
    DefaultListModel<String> dlmSelected=new DefaultListModel<>();
    

            /**
     * Creates new form Subjects
     */
    public AddSubject() throws SQLException, ClassNotFoundException {
        initComponents();
        listAvailable.setModel(dlmAvailable);
        listSelected.setModel(dlmSelected);
        listSubjects.setModel(dlmViewSubject);
        loadListAvailableStreams();
        loadComboAvailableStreams();
        loadSubjectList();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtSubject = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listAvailable = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSelected = new javax.swing.JList();
        btnremove = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comboViewStream = new javax.swing.JComboBox();
        btnAddNewSteam = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAddNewSteam1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listSubjects = new javax.swing.JList();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Add New Subject ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 41, -1, -1));

        jLabel4.setText("Subject Id");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        jLabel5.setText("Subject ");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));
        add(txtid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 160, -1));
        add(txtSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 160, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 30, 540));

        jLabel7.setText("View Subjects for Streams");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, -1, -1));

        jLabel6.setText("Related Streams");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));

        jScrollPane1.setViewportView(listAvailable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 260, 160, 140));

        jScrollPane2.setViewportView(listSelected);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 150, 160));

        btnremove.setText("<");
        btnremove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnremoveMouseClicked(evt);
            }
        });
        add(btnremove, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 360, -1, -1));

        btnAdd.setText(">");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 290, -1, -1));

        jLabel9.setText("Selected Streams");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, -1, -1));

        jLabel10.setText("Available Streams");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        jLabel11.setText("Stream");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, -1, -1));

        comboViewStream.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboViewStream.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboViewStreamItemStateChanged(evt);
            }
        });
        add(comboViewStream, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 60, 180, -1));

        btnAddNewSteam.setText("Refresh Streams");
        add(btnAddNewSteam, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 120, 30));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 410, -1));

        jButton1.setText("Add Subject");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, -1, -1));

        jButton2.setText("Cancel");
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, -1, -1));

        btnAddNewSteam1.setText("Add New Stream");
        add(btnAddNewSteam1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 120, 30));

        jScrollPane3.setViewportView(listSubjects);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 130, 220, 320));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        dlmSelected.addElement( listAvailable.getSelectedValue().toString());
        dlmAvailable.removeElementAt(listAvailable.getSelectedIndex());
        
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnremoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnremoveMouseClicked
        dlmAvailable.addElement( listSelected.getSelectedValue().toString());
        dlmSelected.removeElementAt(listSelected.getSelectedIndex());
    }//GEN-LAST:event_btnremoveMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        String id =txtid.getText();
        String subject=txtSubject.getText();
        ArrayList<String> streams=new ArrayList<>();
        for(int i=0;i<dlmSelected.getSize();i++){
            streams.add(dlmSelected.elementAt(i));
        }
        Subject  subjects=new Subject(id,subject);
        try {
            boolean resp=SubjectController.addSubject(subjects,streams);
            if(resp==true){
                JOptionPane.showMessageDialog(null, "Added Succesfully");
            }else{
                JOptionPane.showMessageDialog(null, "Unsuccesful");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddSubject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked

    private void comboViewStreamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboViewStreamItemStateChanged
        try {
            loadSubjectList();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AddSubject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboViewStreamItemStateChanged
    private void loadListAvailableStreams() throws SQLException, ClassNotFoundException{
        ArrayList<String> streams=StreamController.viewStreamNames();
        if(streams!=null){
        for(String stream:streams){
            dlmAvailable.addElement(stream);
        }   
        }else{
            JOptionPane.showMessageDialog(null, "Arraylist null");
        }
    }
    private void loadComboAvailableStreams() throws SQLException, ClassNotFoundException{
        ArrayList<String> streams = StreamController.viewStreamNames();
        for (String stream:streams){
            comboViewStream.addItem(stream);
        }
    }
    private void loadSubjectList() throws SQLException, ClassNotFoundException{
        ArrayList<String> rowData=StreamedSubjectController.viewStreamedSubject( comboViewStream.getSelectedItem().toString());
        for(String row:rowData){
            dlmViewSubject.addElement(row);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddNewSteam;
    private javax.swing.JButton btnAddNewSteam1;
    private javax.swing.JButton btnremove;
    private javax.swing.JComboBox comboViewStream;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JList listAvailable;
    private javax.swing.JList listSelected;
    private javax.swing.JList listSubjects;
    private javax.swing.JTextField txtSubject;
    private javax.swing.JTextField txtid;
    // End of variables declaration//GEN-END:variables
}
