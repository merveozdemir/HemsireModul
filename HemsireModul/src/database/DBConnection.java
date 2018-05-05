/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author seeda
 */
public class DBConnection {

    public Connection connect() {
        Connection connection = null;

        try {

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your  JDBC Driver?");
            e.printStackTrace();

        }

        try {

            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/HemsireModul", "a", "a");

        } catch (SQLException e) {

            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();

        }

        if (connection != null) {
            System.out.println("Bağlanti basarili");
        } else {
            System.out.println("Başarisiz baglanti!");
        }
        return connection;
    }

    public String girisSorgula(String kullaniciAd, String parola) {
        String kullanici = "";
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "' AND PAROLA='" + parola + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("KULLANICIADI").equals(kullaniciAd) && rs.getString("PAROLA").equals(parola)) {
                    kullanici = rs.getString("KULLANICIADI");
                    System.out.println(kullanici);
                    return kullanici;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return kullanici;

    }
        public String hemsireIsim(String kullaniciAd) {
        String hemsireAdSoyad="";
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("KULLANICIADI").equals(kullaniciAd)) {
                    hemsireAdSoyad = rs.getString("ADI")+" ";
                    hemsireAdSoyad+=rs.getString("SOYADI");
                    System.out.println(hemsireAdSoyad);
                    return hemsireAdSoyad;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }
        
        
        public String getPassword(String kullaniciAd){
             String sifre="";
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("KULLANICIADI").equals(kullaniciAd)) {
                    sifre = rs.getString("PAROLA");
                    return sifre;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

        
        }
        
        
           public String kullaniciBilgiGuncelle(String kullaniciAd){
         
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

//                if (rs.getString("KULLANICIADI").equals(  sifre = rs.getString("SIFRE");
//                    return sifre;
//
//                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

        
        }
        


}
