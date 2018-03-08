/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  dickajava
 * Created: Feb 16, 2018
 */

CREATE DATABASE dbaplikasi_penjualan;

USE dbaplikasi_penjualan;

create table tabel_barang(
    idbarang varchar(255) not null,
    nama varchar(255) not null,
    jumlah int not null,
    harga int not null,

    constraint pk_tabel_barang primary key (idbarang)
);

create table tabel_pengguna(

    idpengguna varchar(255) not null,
    nama varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    makedate date not null,
 
    constraint pk_tabel_pengguna primary key (idpengguna)
);


create table tabel_transaksi(
    idtransaksi varchar(255) not null,
    tanggal_transaksi date not null,
    nama varchar(255) not null,
    notelp varchar(255) not null,
    alamat varchar(255) not null,
    total int not null,
    constraint pk_tabel_transaksi primary key (idtransaksi)
);


create table tabel_transaksi_detil(
    idtransaksi varchar(255) not null,
    idbarang varchar(255) not null,
    jumlah int not null,
    harga int not null,
    
    CONSTRAINT pk_tabel_transaksi_deti_primary PRIMARY KEY (idtransaksi, idbarang),
    CONSTRAINT fk_tabel_transaksi_detil_idtransaksi FOREIGN KEY (idtransaksi)
    REFERENCES tabel_transaksi(idtransaksi),

    CONSTRAINT fk_tabel_transaksi_detil_idbarang FOREIGN KEY (idbarang)
    REFERENCES tabel_barang(idbarang)
);