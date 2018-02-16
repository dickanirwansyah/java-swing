/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.repository;

import com.gunadarma.entity.Transaksi;
import java.util.List;

/**
 *
 * @author dickajava
 */
public interface RepositoryTransaksi {
    
    boolean insertTransaksi(Transaksi transaksi);
    
    String kodeTransaksi();
    
    List<Transaksi> dataTransaksi();
}
