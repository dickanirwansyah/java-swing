/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.connection.DBConnection;
import com.gunadarma.entity.Barang;
import com.gunadarma.repository.RepositoryBarang;
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
public class BarangDao implements RepositoryBarang {

    private Connection connection;

    public BarangDao() {
        connection = DBConnection.getConnection();
    }

    @Override
    public List<Barang> tampilkanListBarang() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql = "SELECT * FROM tabel_barang";

        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            while (rs.next()) {
                Barang b = new Barang();
                b.setIdbarang(rs.getString("idbarang"));
                b.setNama(rs.getString("nama"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getInt("harga"));
                list.add(b);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    public boolean simpanBarang(Barang barang) {
        PreparedStatement statement = null;
        boolean valid = false;
        String sql = "INSERT INTO tabel_barang(idbarang, nama, jumlah, harga)"
                + "VALUES(?, ?, ?, ?)";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, barang.getIdbarang());
            statement.setString(2, barang.getNama());
            statement.setInt(3, barang.getJumlah());
            statement.setInt(4, barang.getHarga());
            valid = true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean updateBarang(Barang barang) {
        PreparedStatement statement = null;
        boolean valid = false;
        String sql = "UPDATE tabel_barang set nama=?, jumlah=?, harga=? where idbarang=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, barang.getNama());
            statement.setInt(2, barang.getJumlah());
            statement.setInt(3, barang.getHarga());
            statement.setString(4, barang.getIdbarang());
            valid = true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean deleteBarang(Barang barang) {
        PreparedStatement statement = null;
        boolean valid = false;
        String sql = "delete from tabel_barang where idbarang=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, barang.getIdbarang());
            valid = true;
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public Barang cariBarangById(String idbarang) {
        PreparedStatement statement = null;
        Barang b = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM tabel_barang WHERE idbarang=?";
        try {
            statement = connection.prepareStatement(sql);
            statement.setString(1, idbarang);
            while (rs.next()) {
                b = new Barang();
                b.setIdbarang(rs.getString("idbarang"));
                b.setNama(rs.getString("nama"));
                b.setJumlah(rs.getInt("jumlah"));
                b.setHarga(rs.getInt("harga"));

            }
            return b;
        } catch (SQLException ex) {
            Logger.getLogger(BarangDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
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
    public String kodeBarang() {
        PreparedStatement statement = null;
        ResultSet rs = null;
        String s, s1;
        String kode = null;
        Integer panjang = 5;
        Integer j;
        String sql = "select max(right(idbarang, 5)) from tabel_barang";
        try {
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.first() == false) {
                kode = "B/00001";
            } else {
                rs.last();
                s = Integer.toString(rs.getInt(1) + 1);
                j = s.length();
                s1 = "";
                for (int i = 0; i <= panjang - j; i++) {
                    s1 = s1 + "0";
                }
                kode = "B/" + s1 + s;
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

}
