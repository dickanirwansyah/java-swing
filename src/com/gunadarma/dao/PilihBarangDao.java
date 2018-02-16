/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.entity.PilihBarang;
import com.gunadarma.repository.RepositoryPilihBarang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class PilihBarangDao implements RepositoryPilihBarang{

    private Connection connection;
    public PilihBarangDao(){
        connection = DBConnection.getConnection();
    }
    
    @Override
    public List<PilihBarang> tampilkanBarang() {
        PreparedStatement statement = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "SELECT * FROM tabel_barang";
        
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                PilihBarang pb = new PilihBarang();
                pb.setIdbarang(rs.getString("idbarang"));
                pb.setNama(rs.getString("nama"));
                pb.setJumlah(rs.getInt("jumlah"));
                pb.setHarga(rs.getInt("harga"));
                list.add(pb);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PilihBarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PilihBarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
