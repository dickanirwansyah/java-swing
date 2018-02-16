/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.entity.Transaksi;
import com.gunadarma.entity.TransaksiDetil;
import com.gunadarma.repository.RepositoryTransaksi;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author dickajava
 */
public class TransaksiDao implements RepositoryTransaksi{
    
    private Connection connection;
    private PilihBarangDao barangDao;
    private TransaksiDetilDao transaksiDetilDao;
    public TransaksiDao(){
        connection = DBConnection.getConnection();
        transaksiDetilDao = new TransaksiDetilDao();
        barangDao = new PilihBarangDao();
    }

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
        PreparedStatement statement = null;
        boolean valid = false;
        String sql = "insert into tabel_transaksi(idtransaksi, tanggal_transaksi, total)"
                + "values(?, ?, ?)";
        try {
            connection.setAutoCommit(true);
            statement = connection.prepareStatement(sql);
            statement.setString(1, transaksi.getIdtransaksi());
            statement.setDate(2, new Date(transaksi.getTanggalTransaksi().getTime()));
            statement.setInt(3, transaksi.getTotal());
            
            //insert transaksi detil
            //mengurangi jumlah stok
            int validJumlah = 0;
            for(TransaksiDetil transaksiDetils : transaksi.getTransaksiDetils()){
                transaksiDetilDao.insertTransaksiDetils(connection, transaksiDetils);
                        
                barangDao = new PilihBarangDao();
                if(transaksiDetils.getBarang().getJumlah() < transaksiDetils.getJumlah()){
                    JOptionPane.showMessageDialog(null, "Maaf jumlah stok barang "
                            + "tidak mencukupi untuk melakukan transaksi !");
                validJumlah = transaksiDetils.getBarang().getJumlah() - transaksiDetils.getJumlah();
                }else{
                    barangDao.kurangJumlahStokBarang(transaksiDetils.getJumlah(), 
                            transaksiDetils.getBarang());
                }
            }
            
            connection.commit();
            valid=true;
            connection.setAutoCommit(true);
            
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                valid=false;
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public String kodeTransaksi() {
      PreparedStatement statement=null;
        ResultSet rs=null;
        String sql="select max(right(idtransaksi, 4)) from tabel_transaksi";
        String s,s1;
        int j=0;
        int panjang=4;
        String kode="";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            if(rs.first()==false){
                kode="TRANS-/0001";
            }else{
                rs.last();
                s=Integer.toString(rs.getInt(1)+1);
                s1="";
                j=s.length();
                for(int i=0; i<panjang-j; i++){
                    s1=s1+"0";
                }
                kode="TRANS-/"+s1+s;
            }
            return kode;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return kode;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Transaksi> dataTransaksi() {
      PreparedStatement statement = null;
      String sql = "select * from tabel_transaksi";
      ResultSet rs = null;
      List list = new ArrayList();
        try {
            statement = connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                Transaksi t = new Transaksi();
                t.setIdTransaksi(rs.getString("idtransaksi"));
                t.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
                t.setTotal(rs.getInt("total"));
                list.add(t);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
}
