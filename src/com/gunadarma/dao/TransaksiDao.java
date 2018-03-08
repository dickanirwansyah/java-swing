/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.entity.LaporanTransaksi;
import com.gunadarma.entity.PilihBarang;
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
        String sql = "insert into tabel_transaksi(idtransaksi, tanggal_transaksi, nama, notelp, alamat, total)"
                + "values(?, ?, ?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
            statement.setString(1, transaksi.getIdtransaksi());
            statement.setDate(2, new Date(transaksi.getTanggalTransaksi().getTime()));
            statement.setString(3, transaksi.getNama());
            statement.setString(4, transaksi.getNotelp());
            statement.setString(5, transaksi.getAlamat());
            statement.setInt(6, transaksi.getTotal());
            statement.executeUpdate();
            
            int validJumlah = 0;
            for(TransaksiDetil transaksiDetils : transaksi.getTransaksiDetils()){
                transaksiDetilDao.insertTransaksiDetils(connection, transaksiDetils);
                        
                barangDao = new PilihBarangDao();
                if(transaksiDetils.getBarang().getJumlah() < transaksiDetils.getJumlah()){
                    JOptionPane.showMessageDialog(null, "maaf jumlah "+transaksiDetils.getBarang().getNama()
                            +" tidak mencukupi untuk transaksi !");
                validJumlah = transaksiDetils.getBarang().getJumlah() - transaksiDetils.getJumlah();
                valid = false;
                }else{
                    barangDao.kurangJumlahStokBarang(transaksiDetils.getJumlah(), transaksiDetils.getBarang());
                }
            }
            
            if(validJumlah<0){
                connection.rollback();
                connection.setAutoCommit(true);
            }else{
                connection.commit();
                connection.setAutoCommit(true);
                valid=true;
            }
            
            /**
            connection.commit();
            valid=true;
            connection.setAutoCommit(true);
            **/
            
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
                valid = false;
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
                t.setNama(rs.getString("nama"));
                t.setAlamat(rs.getString("alamat"));
                t.setNotelp(rs.getString("notelp"));
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

    @Override
    public List<LaporanTransaksi> getLaporanTransaksiById(String idtransaksi) {
      PreparedStatement statement = null;
      List list = new ArrayList();
      ResultSet rs = null;
      String sql="select * from tabel_transaksi inner join tabel_transaksi_detil "
              + "on (tabel_transaksi.idtransaksi=tabel_transaksi_detil.idtransaksi) "
              + "where tabel_transaksi.idtransaksi=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, idtransaksi);
            rs=statement.executeQuery();
            while(rs.next()){
                LaporanTransaksi lt = new LaporanTransaksi();
                Transaksi t = new Transaksi();
                t.setIdTransaksi(rs.getString("idtransaksi"));
                t.setTanggalTransaksi(rs.getDate("tanggal_transaksi"));
                t.setNama(rs.getString("nama"));
                t.setNotelp(rs.getString("notelp"));
                t.setAlamat(rs.getString("alamat"));
                t.setTotal(rs.getInt("total"));
                lt.setTransaksi(t);
                    TransaksiDetil td = new TransaksiDetil();
                    String idbarang = rs.getString("idbarang");
                    PilihBarang byidbarang = barangDao.tampilkanById(idbarang);
                    td.setBarang(byidbarang);
                    td.setHarga(rs.getInt("harga"));
                    td.setJumlah(rs.getInt("jumlah"));
                    lt.setTransaksiDetil(td);
                 list.add(lt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    public List<LaporanTransaksi> getLaporanTransaksiByDate(java.util.Date tanggalMulai, java.util.Date tanggalAkhir) {
        PreparedStatement statement = null;
        List list = new ArrayList();
        ResultSet rs = null;
        String sql = "select * from tabel_transaksi inner join tabel_transaksi_detil "
                + "on (tabel_transaksi.idtransaksi=tabel_transaksi_detil.idtransaksi) "
                + "where (tabel_transaksi.tanggal_transaksi>=?) and "
                + "(tabel_transaksi.tanggal_transaksi<=?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setDate(1, new Date(tanggalMulai.getTime()));
            statement.setDate(2, new Date(tanggalAkhir.getTime()));
            rs=statement.executeQuery();
            while(rs.next()){
                LaporanTransaksi lt = new LaporanTransaksi();
                Transaksi t = new Transaksi();
                    t.setIdTransaksi(rs.getString("tabel_transaksi.idtransaksi"));
                    t.setTanggalTransaksi(rs.getDate("tabel_transaksi.tanggal_transaksi"));
                    t.setAlamat(rs.getString("tabel_transaksi.alamat"));
                    t.setNama(rs.getString("tabel_transaksi.nama"));
                    t.setNotelp(rs.getString("tabel_transaksi.notelp"));
                    t.setTotal(rs.getInt("tabel_transaksi.total"));
                    lt.setTransaksi(t);
                TransaksiDetil td = new TransaksiDetil();
                String idbarang = rs.getString("tabel_transaksi_detil.idbarang");
                PilihBarang pb = barangDao.tampilkanById(idbarang);
                td.setBarang(pb);
                td.setHarga(rs.getInt("tabel_transaksi_detil.harga"));
                td.setJumlah(rs.getInt("tabel_transaksi_detil.jumlah"));
                lt.setTransaksiDetil(td);
                list.add(lt);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    
}
