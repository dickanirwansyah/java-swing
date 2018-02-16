/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.dao;

import com.gunadarma.entity.Transaksi;
import com.gunadarma.repository.RepositoryTransaksi;
import java.util.List;

/**
 *
 * @author dickajava
 */
public class TransaksiDao implements RepositoryTransaksi{
    
    

    @Override
    public boolean insertTransaksi(Transaksi transaksi) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String kodeTransaksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Transaksi> dataTransaksi() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
