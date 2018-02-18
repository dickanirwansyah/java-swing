/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gunadarma.repository;

import com.gunadarma.entity.Pengguna;

/**
 *
 * @author dickajava
 */
public interface RepositoryPengguna {
    
    String kodePengguna();
    
    boolean signUpPengguna(Pengguna pengguna);
    
    Pengguna loginPengguna(String username, String password);
    
    
    
}
