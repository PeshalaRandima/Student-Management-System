/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.report;

import gateway.controllers.CourseController;
import gateway.controllers.StudentCoursesController;
import gateway.controllers.TeacherController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pesshala
 */
public class NameListOfCourseWithAttendingClass extends javax.swing.JPanel {

    DefaultTableModel dtm;
    private boolean isconstruct;
    private boolean iscourse;

    /**
     * Creates new form NameListOfCourseWithAttendingClass
     */
    public NameListOfCourseWithAttendingClass() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        comboTeacher = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        comboCourse = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setOpaque(false);

        jLabel3.setText("Teacher       :");

        comboTeacher.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTeacherItemStateChanged(evt);
            }
        });
        comboTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTeacherActionPerformed(evt);
            }
        });

        jLabel2.setText("Course     :");

        comboCourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCourseItemStateChanged(evt);
            }
        });
        comboCourse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCourseActionPerformed(evt);
            }
        });

        jButton1.setText("Show Students Registered To Course");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission Number", "Student Name", "Class"
            }
        ));
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(104, 104, 104)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(393, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCourse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(comboTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void comboTeacherItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTeacherItemStateChanged

    }//GEN-LAST:event_comboTeacherItemStateChanged

    private void comboTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTeacherActionPerformed
        try {
            if (isconstruct) {
                comboCourse.removeAllItems();
                String teacher = comboTeacher.getSelectedItem().toString();
                System.out.println(teacher);

                ArrayList<String> courses = CourseController.getTeachersCourses(TeacherController.getTeacherName(teacher));
                for (String course : courses) {
                    comboCourse.addItem(course);
                    System.out.println(course);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(NameListOfRegisteredToClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NameListOfRegisteredToClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_comboTeacherActionPerformed

    private void comboCourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCourseItemStateChanged

    }//GEN-LAST:event_comboCourseItemStateChanged

    private void comboCourseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCourseActionPerformed

    }//GEN-LAST:event_comboCourseActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        try {
            dtm.setRowCount(0);
            String courseId = CourseController.getCourseId(comboCourse.getSelectedItem().toString());
            ArrayList<Object[]> rowDatas = StudentCoursesController.getNameListWithClassOfStudentsRegisteredToCourse(courseId);
            for (Object[] row : rowDatas) {
                dtm.addRow(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NameListOfRegisteredToClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NameListOfRegisteredToClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox comboCourse;
    private javax.swing.JComboBox comboTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
private void loadTeacher() throws SQLException, ClassNotFoundException {
        ArrayList<String[]> teachers = TeacherController.getTeacherName();
        for (String[] teacher : teachers) {
            comboTeacher.addItem(teacher[0]);
        }
        isconstruct = true;
        if (isconstruct) {
            System.out.println("true   true    true   true");
        }
    }
}
