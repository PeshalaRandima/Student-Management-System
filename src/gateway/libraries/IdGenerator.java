/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gateway.libraries;

import java.sql.SQLException;
import java.text.NumberFormat;

/**
 *
 * @author Pesshala
 */
public class IdGenerator {
    
    public static String getNewId(String tableName, String columnName, String prefix) throws ClassNotFoundException, SQLException {
        String lastId = gateway.controllers.IdGenaratorController.getLastId(tableName, columnName);
        if (lastId != null) {
            int id = Integer.parseInt(lastId.split(prefix)[1]);
            id++;
            NumberFormat numberFormat = NumberFormat.getIntegerInstance();
            numberFormat.setMinimumIntegerDigits(3);
            numberFormat.setGroupingUsed(false);
            String newID = numberFormat.format(id);
            return prefix + newID;
        } else {
            return prefix + "0001";
        }
    }

}
