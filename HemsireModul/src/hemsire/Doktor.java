/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hemsire;

import database.DBConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seeda
 */
public class Doktor {

    private int hastaneId = 5, poliklinikId = 0;
    private String ad, soyad;
    private int id;
    private String unvan;
    private String brans;
    DBConnection d;
    public Doktor() {

    }

    public Doktor(int id, String ad, String soyad) {
        
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
          d = new DBConnection();
    }

    public int doktorIdBul(String brans) {
        int doktorId = 0;
        try {

           
            String sql = "SELECT * FROM DOKTORLAR INNER JOIN  POLIKLINIKLER ON DOKTORLAR.POLIKLINIK_ID=POLIKLINIKLER.POLIKLINIK_ID WHERE POLIKLINIK_ADI='" + brans + "'";
            Statement s = d.connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                doktorId = rs.getInt(1);
            }

        } catch (SQLException ex) {

        }
        return doktorId;
    }

    public int getHastaneId() {
        return hastaneId;
    }

    public int getPoliklinikId() {
        return poliklinikId;
    }

    public void setPoliklinikId(int poliklinikId) {
        this.poliklinikId = poliklinikId;
    }

    public String getUnvan() {
        return unvan;
    }

    public void setUnvan(String unvan) {
        this.unvan = unvan;
    }

    public String getBrans() {
        return brans;
    }

    public void setBrans(String brans) {
        this.brans = brans;
    }

    public static ArrayList<Doktor> getDoktorlar() {
        return doktorlar;
    }

    public static void setDoktorlar(ArrayList<Doktor> doktorlar) {
        Doktor.doktorlar = doktorlar;
    }

//    public ArrayList<Randevu> getDoktorunRandevuları() {
//        return doktorunRandevuları;
//    }
//
//    public void setDoktorunRandevuları(ArrayList<Randevu> doktorunRandevuları) {
//        this.doktorunRandevuları = doktorunRandevuları;
//    }
    static ArrayList<Doktor> doktorlar = new ArrayList();

}
