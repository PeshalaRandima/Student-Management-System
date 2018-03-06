/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.view.system;

import gateway.controllers.CourseController;
import gateway.controllers.GradeController;
import gateway.controllers.SubjectController;
import gateway.controllers.TeacherController;
import gateway.model.Course;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class ViewCourse extends javax.swing.JPanel {
    DefaultTableModel dtm;
    /**
     * Creates new form ViewCourse
     */
    public ViewCourse() throws SQLException, ClassNotFoundException {
        initComponents();
        dtm=(DefaultTableModel)tableView.getModel();
        loadComboBoxes();
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        comboTeacherID = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboTeacherName = new javax.swing.JComboBox();
        comboSubject = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        comboGrade = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableView = new javax.swing.JTable();

        jPanel1.setLayout(null);

        jLabel1.setText("FILTER");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(20, 40, 34, 14);

        jPanel1.add(comboTeacherID);
        comboTeacherID.setBounds(120, 150, 170, 20);

        jLabel2.setText("Teacher ID");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 150, 53, 14);

        jLabel3.setText("Teacher");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 200, 39, 14);

        jPanel1.add(comboTeacherName);
        comboTeacherName.setBounds(120, 200, 170, 20);

        jPanel1.add(comboSubject);
        comboSubject.setBounds(120, 110, 170, 20);

        jLabel4.setText("Subject");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 110, 36, 14);

        jLabel5.setText("Grade");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 70, 29, 14);

        comboGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGradeActionPerformed(evt);
            }
        });
        jPanel1.add(comboGrade);
        comboGrade.setBounds(120, 70, 170, 20);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(310, 70, 10, 150);

        tableView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Corse ID", "Grade", "Subject", "Teacher's ID", "Teacher", "Monthly Fee", "Time peiriod"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableView);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(360, 60, 720, 330);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1090, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboGradeActionPerformed

     private void loadComboBoxes() throws SQLException, ClassNotFoundException{
        teacherID();
        teacherName();
        subject();
        grade();
        
    }
     private  void loadTable() throws SQLException, ClassNotFoundException{
       //methana godak subquery hedenna tyenaa 
       //eka nisa meka denata atharinawa 
       //meke gahanna puluwan issella cteacherid eka nullda nethnm mopkkda kyana eka anuwa query 2k gahanna wenawa .
       //ilangata e ena queryen gahathakisubjectideka nullda neythnm mokakda kyana eka anuwa query 1gahanaa , null num query gahanna deyak ne kalin ueryama return kraganawa
         String grade=comboGrade.getSelectedItem().toString();
         String subject=comboSubject.getSelectedItem().toString();
         String teacher=comboTeacherID.getSelectedItem().toString();
         ArrayList<String[]> courses=CourseController.viewFilteredCourse(grade,subject,teacher);
         for(String[] course:courses){
             dtm.addRow(course);
             
         }
         
     }
    private void teacherID() throws SQLException, ClassNotFoundException{
        ArrayList<String[]> teacherIDs=TeacherController.getTeacherID();
        for(String[] teacherID:teacherIDs){
            comboTeacherID.addItem(teacherID);
            
        }
    }
    private void teacherName() throws SQLException, ClassNotFoundException{
        ArrayList<String[]> teacherNames=TeacherController.getTeacherName();
        for(String[] teacherName:teacherNames){
            comboTeacherName.addItem(teacherName);
            
        }
    }
    private void subject() throws SQLException, ClassNotFoundException{
        ArrayList<String[]> teacherIDs=SubjectController.getSubject();
        for(String[] teacherID:teacherIDs){
            comboTeacherID.addItem(teacherID);
            //comboTeacherID2.addItem(teacherID);
        }
    }
    private void grade() throws SQLException, ClassNotFoundException{
        ArrayList<String[]> teacherIDs=GradeController.getGrade();
        for(String[] teacherID:teacherIDs){
            comboTeacherID.addItem(teacherID);
           // comboTeacherID2.addItem(teacherID);
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboGrade;
    private javax.swing.JComboBox comboSubject;
    private javax.swing.JComboBox comboTeacherID;
    private javax.swing.JComboBox comboTeacherName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableView;
    // End of variables declaration//GEN-END:variables
}