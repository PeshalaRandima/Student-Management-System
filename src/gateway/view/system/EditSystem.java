/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.view.system;

import AppPackage.AnimationClass;
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import gateway.controllers.StudentController;
import gateway.controllers.TeacherController;
import gateway.model.Student;
import gateway.model.Teacher;
import gateway.report.ReportForm;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class EditSystem extends javax.swing.JPanel {
    
    private boolean visible;
    /**
     * Creates new form System
     */
    public EditSystem() throws SQLException, ClassNotFoundException {
        initComponents();
        panelsInvisible();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        btnStudent = new javax.swing.JButton();
        btnTeacher = new javax.swing.JButton();
        btnSubject = new javax.swing.JButton();
        btnPlace = new javax.swing.JButton();
        btnCourse = new javax.swing.JButton();
        labelAddStudent = new javax.swing.JLabel();
        labelViewStudwnt = new javax.swing.JLabel();
        labelAddTeacher = new javax.swing.JLabel();
        labelViewTeacher = new javax.swing.JLabel();
        labelAddPlace = new javax.swing.JLabel();
        labelViewPlace = new javax.swing.JLabel();
        labelViewSubject = new javax.swing.JLabel();
        labelAddSubject = new javax.swing.JLabel();
        labelAddCourse = new javax.swing.JLabel();
        labelViewCourse = new javax.swing.JLabel();
        loadPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setOpaque(false);
        setLayout(null);

        jPanel6.setLayout(null);

        btnStudent.setText("Student");
        btnStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnStudentMouseClicked(evt);
            }
        });
        btnStudent.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnStudentMouseMoved(evt);
            }
        });
        jPanel6.add(btnStudent);
        btnStudent.setBounds(0, 0, 132, 40);

        btnTeacher.setText("Teacher");
        btnTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTeacherMouseClicked(evt);
            }
        });
        btnTeacher.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnTeacherMouseMoved(evt);
            }
        });
        jPanel6.add(btnTeacher);
        btnTeacher.setBounds(130, 0, 140, 40);

        btnSubject.setText("Subject");
        btnSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSubjectMouseClicked(evt);
            }
        });
        btnSubject.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnSubjectMouseMoved(evt);
            }
        });
        jPanel6.add(btnSubject);
        btnSubject.setBounds(410, 0, 140, 40);

        btnPlace.setText("Places");
        btnPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPlaceMouseClicked(evt);
            }
        });
        btnPlace.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnPlaceMouseMoved(evt);
            }
        });
        jPanel6.add(btnPlace);
        btnPlace.setBounds(270, 0, 140, 40);

        btnCourse.setText("Course");
        btnCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCourseMouseClicked(evt);
            }
        });
        btnCourse.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnCourseMouseMoved(evt);
            }
        });
        jPanel6.add(btnCourse);
        btnCourse.setBounds(550, 0, 140, 40);

        add(jPanel6);
        jPanel6.setBounds(0, 0, 690, 40);

        labelAddStudent.setText("AddStudent");
        labelAddStudent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAddStudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddStudentMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                labelAddStudentMouseExited(evt);
            }
        });
        add(labelAddStudent);
        labelAddStudent.setBounds(0, -50, 130, 30);

        labelViewStudwnt.setText("View Student");
        labelViewStudwnt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelViewStudwnt.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                labelViewStudwntComponentMoved(evt);
            }
        });
        add(labelViewStudwnt);
        labelViewStudwnt.setBounds(0, -20, 130, 30);

        labelAddTeacher.setText("Add Teacher");
        labelAddTeacher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAddTeacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddTeacherMouseClicked(evt);
            }
        });
        add(labelAddTeacher);
        labelAddTeacher.setBounds(130, -20, 140, 30);

        labelViewTeacher.setText("View Teacher");
        labelViewTeacher.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(labelViewTeacher);
        labelViewTeacher.setBounds(130, 0, 140, 30);

        labelAddPlace.setText("Add Place");
        labelAddPlace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAddPlace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddPlaceMouseClicked(evt);
            }
        });
        add(labelAddPlace);
        labelAddPlace.setBounds(270, -20, 140, 30);

        labelViewPlace.setText("View Place");
        labelViewPlace.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(labelViewPlace);
        labelViewPlace.setBounds(270, 0, 140, 30);

        labelViewSubject.setText("View Subject");
        labelViewSubject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(labelViewSubject);
        labelViewSubject.setBounds(410, 0, 140, 30);

        labelAddSubject.setText("Add Subject");
        labelAddSubject.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAddSubject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelAddSubjectMouseClicked(evt);
            }
        });
        add(labelAddSubject);
        labelAddSubject.setBounds(410, -20, 140, 30);

        labelAddCourse.setText("Add course");
        labelAddCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        labelAddCourse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                labelAddCourseKeyPressed(evt);
            }
        });
        add(labelAddCourse);
        labelAddCourse.setBounds(550, -20, 140, 30);

        labelViewCourse.setText("View Course");
        labelViewCourse.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(labelViewCourse);
        labelViewCourse.setBounds(550, 0, 140, 30);

        loadPanel.setOpaque(false);
        loadPanel.setLayout(null);
        add(loadPanel);
        loadPanel.setBounds(0, 40, 1100, 470);

        jButton1.setFont(new java.awt.Font("Trajan Pro 3", 0, 18)); // NOI18N
        jButton1.setText("REPORTS");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(810, 0, 190, 40);

        jButton2.setText("Tutes");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        add(jButton2);
        jButton2.setBounds(690, 0, 120, 40);
    }// </editor-fold>//GEN-END:initComponents
    private void panelsInvisible(){
//       panelStudent.setVisible(false);
//        panelCourse.setVisible(false);
//        panelTeacher.setVisible(false);
//        panelPlace.setVisible(false);
//        panelSubject.setVisible(false);
//        panelCourse.setVisible(false);
    }
    private void labelAddStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddStudentMouseClicked
         

        try {
            AddStudent addstudent =new AddStudent();
            addstudent.setSize(loadPanel.getSize());
            loadPanel.removeAll();
            loadPanel.add(addstudent);
            loadPanel.repaint();
            loadPanel.revalidate();
            
            AnimationClass ac= new AnimationClass();
        ac.jLabelYUp(labelAddStudent.getY(),80, 5, 1, labelAddStudent);
        ac.jLabelYUp(labelViewStudwnt.getY(),110, 5, 1, labelViewStudwnt);        
            
                            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
                
    }//GEN-LAST:event_labelAddStudentMouseClicked

    private void labelAddTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddTeacherMouseClicked
       AnimationClass ac= new AnimationClass();
        ac.jLabelYUp(labelAddTeacher.getY(),60, 5, 1, labelAddTeacher);
        ac.jLabelYUp(labelViewTeacher.getY(),90, 5, 1, labelViewTeacher);
        
       
        
    }//GEN-LAST:event_labelAddTeacherMouseClicked

    private void labelAddPlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddPlaceMouseClicked
        try {
            AddPlace loadedPanel =new AddPlace();
            loadedPanel.setSize(loadPanel.getSize());
            loadPanel.removeAll();
            loadPanel.add(loadedPanel);
            loadPanel.repaint();
            loadPanel.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelAddPlaceMouseClicked

    private void labelAddSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddSubjectMouseClicked
        try {
            AddSubject loadedPanel =new AddSubject();
            loadedPanel.setSize(loadPanel.getSize());
            loadPanel.removeAll();
            loadPanel.add(loadedPanel);
            loadPanel.repaint();
            loadPanel.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelAddSubjectMouseClicked

    private void labelAddCourseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_labelAddCourseKeyPressed
        try {
            AddCourse loadedPanel =new AddCourse();
            loadedPanel.setSize(loadPanel.getSize());
            loadPanel.removeAll();
            loadPanel.add(loadedPanel);
            loadPanel.repaint();
            loadPanel.revalidate();
        } catch (SQLException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EditSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_labelAddCourseKeyPressed

    private void btnStudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMouseClicked

        AnimationClass ac= new AnimationClass();
        ac.jLabelYDown(labelAddStudent.getY(),30, 5, 1, labelAddStudent);
        ac.jLabelYDown(labelViewStudwnt.getY(),60, 5, 1, labelViewStudwnt);
    }//GEN-LAST:event_btnStudentMouseClicked

    private void btnTeacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseClicked
        
       
    }//GEN-LAST:event_btnTeacherMouseClicked

    private void btnPlaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlaceMouseClicked
        
       
    }//GEN-LAST:event_btnPlaceMouseClicked

    private void btnSubjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseClicked
     
    }//GEN-LAST:event_btnSubjectMouseClicked

    private void btnCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseMouseClicked
        
           
        
    }//GEN-LAST:event_btnCourseMouseClicked

    private void labelViewStudwntComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_labelViewStudwntComponentMoved
      // LblViewstudents.setLocation(LblViewstudents.getX(), LblViewstudents.getY());
    }//GEN-LAST:event_labelViewStudwntComponentMoved

    private void btnStudentMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnStudentMouseMoved
        
    }//GEN-LAST:event_btnStudentMouseMoved

    private void btnTeacherMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTeacherMouseMoved
        AnimationClass ac= new AnimationClass();
        ac.jLabelYDown(labelAddTeacher.getY(),30, 5, 1, labelAddTeacher);
        ac.jLabelYDown(labelViewTeacher.getY(),60, 5, 1, labelViewTeacher);
    }//GEN-LAST:event_btnTeacherMouseMoved

    private void btnPlaceMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPlaceMouseMoved
         AnimationClass ac= new AnimationClass();
        ac.jLabelYDown(labelAddPlace.getY(),30, 5, 1, labelAddPlace);
        ac.jLabelYDown(labelViewPlace.getY(),60, 5, 1, labelViewPlace);
    }//GEN-LAST:event_btnPlaceMouseMoved

    private void btnSubjectMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSubjectMouseMoved
         AnimationClass ac= new AnimationClass();
        ac.jLabelYDown(labelAddSubject.getY(),30, 5, 1, labelAddSubject);
        ac.jLabelYDown(labelViewSubject.getY(),60, 5, 1, labelViewSubject);
    }//GEN-LAST:event_btnSubjectMouseMoved

    private void btnCourseMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCourseMouseMoved
        AnimationClass ac= new AnimationClass();
        ac.jLabelYDown(labelAddCourse.getY(),30, 5, 1, labelAddCourse);
        ac.jLabelYDown(labelViewCourse.getY(),60, 5, 1, labelViewCourse);
    }//GEN-LAST:event_btnCourseMouseMoved

    private void labelAddStudentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelAddStudentMouseExited
//        AnimationClass ac= new AnimationClass();
//        ac.jLabelYUp(labelAddStudent.getY(),20, 5, 1, labelAddStudent);
//        ac.jLabelYUp(labelViewStudwnt.getY(),50, 5, 1, labelViewStudwnt);        
    }//GEN-LAST:event_labelAddStudentMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        ReportForm loadedPanel =new ReportForm();
       loadedPanel.setSize(loadPanel.getSize());
       loadPanel.removeAll();
       loadPanel.add(loadedPanel);
       loadPanel.repaint();
       loadPanel.revalidate();
            
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        AddTute loadedPanel =new AddTute();
        loadedPanel.setSize(loadPanel.getSize());
        loadPanel.removeAll();
        loadPanel.add(loadedPanel);
        loadPanel.repaint();
        loadPanel.revalidate();
    }//GEN-LAST:event_jButton2MouseClicked
    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCourse;
    private javax.swing.JButton btnPlace;
    public javax.swing.JButton btnStudent;
    private javax.swing.JButton btnSubject;
    private javax.swing.JButton btnTeacher;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel labelAddCourse;
    private javax.swing.JLabel labelAddPlace;
    private javax.swing.JLabel labelAddStudent;
    private javax.swing.JLabel labelAddSubject;
    private javax.swing.JLabel labelAddTeacher;
    private javax.swing.JLabel labelViewCourse;
    private javax.swing.JLabel labelViewPlace;
    private javax.swing.JLabel labelViewStudwnt;
    private javax.swing.JLabel labelViewSubject;
    private javax.swing.JLabel labelViewTeacher;
    private javax.swing.JPanel loadPanel;
    // End of variables declaration//GEN-END:variables
}