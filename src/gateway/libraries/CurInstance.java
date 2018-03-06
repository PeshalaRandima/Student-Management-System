/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gateway.libraries;

 import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author DELL
 */
public class CurInstance {
    public static void main(String[] args) {
        System.out.println(Date());
        System.out.println(Date_day());
        System.out.println(Time_12());
        System.out.println(Time_12_s());
         System.out.println(Time_12_AMPM( ));
        System.out.println(Time_12_s_AMPM( ) );
        System.out.println(Time_24());
        System.out.println(Time_24_AMPM());
        System.out.println(Time_24_s());
        System.out.println(Time_24_s_AMPM( ));
       
        
        
    }
    public static  String Date() {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String instance=sdf.format(new Date());

        return  instance;
    }
    public static  String Date_day() {

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd EEE");
        String instance=sdf.format(new Date());

        return  instance;
    }
    
    public static String Time_12( ) {
         SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
        String instance=sdf.format(new Date());

        return  instance;
        
    }
    public static String Time_12_s( ) {
         SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
        String instance=sdf.format(new Date());

        return  instance;
        
    }
    public static String Time_12_AMPM( ) {
         SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
        String instance=sdf.format(new Date());

        return  instance;
        
    }public static String Time_12_s_AMPM( ) {
         SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss a");
        String instance=sdf.format(new Date());

        return  instance;
        
    }public static String Time_24_s_AMPM( ) {
         SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss a");
        String instance=sdf.format(new Date());

        return  instance;
        
    }
    public static  String Time_24_s() {

        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String instance=sdf.format(new Date());

        return  instance;
    }
    public static  String Time_24_AMPM() {

        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm a");
        String instance=sdf.format(new Date());

        return  instance;
    }
    public static  String Time_24() {

        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm");
        String instance=sdf.format(new Date());

        return  instance;
    }

}
