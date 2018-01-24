/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihan_hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author St0rm
 */
@Entity
@Table(name = "m_propinsi", schema = "public")
public class Provinsi extends Base {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_propinsi", updatable = false, nullable = false)
    private int id;
    
    @Column(name = "id_negara")
    private int id_negara;
    
    @Column(name = "nm_propinsi")
    private String nama;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_negara() {
        return id_negara;
    }

    public void setId_negara(int id_negara) {
        this.id_negara = id_negara;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
