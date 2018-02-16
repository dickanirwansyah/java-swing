/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.entity.TransaksiDetil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class TransaksiDetilDao {
    
    public TransaksiDetilDao(){
        
    }
    
    public boolean insertTransaksiDetils(Connection connection, TransaksiDetil td){
       
        PreparedStatement statement = null;
        boolean valid = false;
        String sql="INSERT INTO tabel_transaksi_detil (idtransaksi, idbarang, jumlah, harga) "
                + "VALUES (?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, td.getTransaksi().getIdtransaksi());
            statement.setString(2, td.getBarang().getIdbarang());
            statement.setInt(3, td.getJumlah());
            statement.setInt(4, td.getHarga());
            valid = true;
            statement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDetilDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDetilDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }
}
