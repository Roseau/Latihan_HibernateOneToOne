/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.asboyo.latihan_hibernate;

import com.gmail.asboyo.latihan_hibernate.model.Kecamatan;
import com.gmail.asboyo.latihan_hibernate.model.Kelurahan;
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
        
        //list kota dan provinsi
//        List<Kota> listKota = getListKota(session);
//        System.out.println(listKota.size());
//        for(Kota kota : listKota){
//            System.out.println(kota.getProvinsi().getNama()+" || "+kota.getNama());
//        }
        //list provinsi, kota, kecamatan
//        List<Kecamatan> listKec = getListKecamatan(session);
//        System.out.println(listKec.size());
//        for(Kecamatan kec : listKec){
//            System.out.println(kec.getKota().getProvinsi().getNama()+" || "+kec.getKota().getNama()+" || "+kec.getNama());
//        }
        //list provinsi, kota, kecamatan, kelurahan
        List<Kelurahan> listKeluh = getListKelurahan(session);
        System.out.println(listKeluh.size());
        for(Kelurahan keluh : listKeluh){
            System.out.println(keluh.getKecamatan().getKota().getProvinsi().getNama()+" || "
                    +keluh.getKecamatan().getKota().getNama()+" || "
                    +keluh.getKecamatan().getNama()+" || "
                    +keluh.getNama());
        }
        session.close();
        HibernateUtil.shutdown();
    }
    private static String getNativeQuery(Session session, String sql){
        return(String) session.createNativeQuery(sql).getSingleResult();
    }
    //mengambil List kota
    private static List<Kota> getListKota(Session session){
        return session.createQuery("Select k from Kota k JOIN FETCH k.provinsi").getResultList();
    }
    //mengambil List kecamatan
    private static List<Kecamatan> getListKecamatan(Session session){
        return session.createQuery("Select k from Kecamatan k JOIN FETCH k.kota").getResultList();
    }
    //mengambil list kelurahan
    private static List<Kelurahan> getListKelurahan(Session session){
        return session.createQuery("Select k from Kelurahan k JOIN FETCH k.kecamatan").getResultList();
    }
}
