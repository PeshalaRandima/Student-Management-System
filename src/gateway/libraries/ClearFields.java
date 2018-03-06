/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.libraries;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class ClearFields {
//    public static void clearTxtField(ArrayList<JTextField> fields){
//        for(JTextField field:fields){
//            field.setText("");
//        }
//    }
     public static void clearTxtField(ArrayList<JTextField> fields){
        for(JTextField field:fields){
            field.setText("");
        }
    }
    
    public static void clearTxtArea(ArrayList<JTextArea> fields){
        for(JTextArea field:fields){
            field.setText("");
        }
    }
    public static void clearComboBox(ArrayList<JComboBox> fields){
        for(JComboBox field:fields){
            field.removeAll();
        }
    }
    public static void clearList(ArrayList<JList> fields){
        for(JList field:fields){
            field.removeAll();
        }
    }
   
    
}
