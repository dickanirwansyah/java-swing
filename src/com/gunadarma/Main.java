/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.dialog.LoginPenggunaDialog;
import java.sql.Connection;

/**
 *
 * @author dickajava
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = DBConnection.getConnection();
        
        System.out.println(connection+" success !");
        
        
    }
    
}
