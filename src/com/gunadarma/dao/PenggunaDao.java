/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.entity.Pengguna;
import com.gunadarma.repository.RepositoryPengguna;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dickajava
 */
public class PenggunaDao implements RepositoryPengguna{
    
    private Connection connection;
    public PenggunaDao(){
        connection = DBConnection.getConnection();
    }

    @Override
    public String kodePengguna() {
       PreparedStatement statement = null;
        ResultSet rs = null;
        String s, s1;
        String kode = null;
        Integer panjang = 5;
        Integer j;
        String sql = "select max(right(idpengguna, 5)) from tabel_pengguna";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.first() == false) {
                kode = "P/00001";
            } else {
                rs.last();
                s = Integer.toString(rs.getInt(1) + 1);
                j = s.length();
                s1 = "";
                for (int i = 0; i <= panjang - j; i++) {
                    s1 = s1 + "0";
                }
                kode = "P/" + s1 + s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public boolean signUpPengguna(Pengguna pengguna) {
     PreparedStatement statement=null;
     boolean valid = false;
     String sql = "insert into tabel_pengguna(idpengguna, nama, username, password, makedate)"
             + "values(?,?,?,?,?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, pengguna.getIdpengguna());
            statement.setString(2, pengguna.getNama());
            statement.setString(3, pengguna.getUsername());
            statement.setString(4, pengguna.getPassword());
            statement.setDate(5, new Date(pengguna.getMakedate().getTime()));
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaDao.class.getName()).log(Level.SEVERE, null, ex);
            valid = false;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenggunaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public Pengguna loginPengguna(String username, String password) {
      PreparedStatement statement = null;
      ResultSet rs = null;
      Pengguna p = null;
      String sql = "select * from tabel_pengguna where username=? and password=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            rs = statement.executeQuery();
            while(rs.next()){
                p = new Pengguna();
                p.setIdpengguna(rs.getString("idpengguna"));
                p.setNama(rs.getString("nama"));
                p.setPassword(rs.getString("password"));
                p.setUsername(rs.getString("username"));
                p.setMakedate(rs.getDate("makedate"));
            }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenggunaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PenggunaDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
