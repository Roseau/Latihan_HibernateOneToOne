/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihan_hibernate;

import com.gmail.asboyo.latihan_hibernate.model.Kota;
import com.gmail.asboyo.latihan_hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author St0rm
 */
public class MainApp {
    public static void main(String[] args) {
        System.out.println("Take me home, Country Roads");
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        String result = getNativeQuery(session, "select version()");
        System.out.println("Menapilkan Result! : ");
        System.out.println(result);
        
        
        List<Kota> listKota = getListKota(session);
        System.out.println(listKota.size());
        for(Kota kota : listKota){
            System.out.println(kota.getProvinsi().getNama()+" || "+kota.getNama());
        }
        
        session.close();
        HibernateUtil.shutdown();
    }
    private static String getNativeQuery(Session session, String sql){
        return(String) session.createNativeQuery(sql).getSingleResult();
    }
    
    private static List<Kota> getListKota(Session session){
        return session.createQuery("Select k from Kota k JOIN FETCH k.provinsi").getResultList();
    } 
}
