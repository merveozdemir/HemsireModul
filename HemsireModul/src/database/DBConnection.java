/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import hemsire.shiftYonetimiPaneli;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

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

    public void ListeleTumHastalar(DefaultTableModel dtm) {

        String hastaAdSoyad = "";
        int hastaId = 0;
        int odaNo = 0;
        String doktor = "";

        String sql = "SELECT * FROM a.HASTA";
        Statement s;
        //"Konum", "Hasta No", "Hasta Adı", "Doktor Adı"
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hastaAdSoyad = rs.getString("HASTAADI") + " ";
                hastaAdSoyad += rs.getString("HASTASOYADI");
                hastaId = rs.getInt("HASTAID");
                odaNo = rs.getInt("HASTAODANO");
                doktor = rs.getString("DOKTOR");
                System.out.println(hastaAdSoyad);
                System.out.println(hastaId);
                System.out.println(odaNo);
                System.out.println(doktor);
                dtm.addRow(new Object[]{odaNo, hastaId, hastaAdSoyad, doktor});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int tumHastaSayisi() {
        int hastaSayisi = 0;

        String sql = "SELECT * FROM a.HASTA";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hastaSayisi++;

            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hastaSayisi;

    }

    public String hemsireIsim(String kullaniciAd) {
        String hemsireAdSoyad = "";
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("KULLANICIADI").equals(kullaniciAd)) {
                    hemsireAdSoyad = rs.getString("ADI") + " ";
                    hemsireAdSoyad += rs.getString("SOYADI");
                    System.out.println(hemsireAdSoyad);
                    return hemsireAdSoyad;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public String getPassword(String kullaniciAd) {
        String sifre = "";
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

    public void kullaniciBilgiGuncelle(String ad, String soyad, String kullaniciAdi, String pozisyon, String sifre_txt, String eskiKullaniciAdi) {

        try {
            String sql = "UPDATE a.HEMSIRE SET ADI=? ,SOYADI=?  ,POZISYON=?, KULLANICIADI=? ,PAROLA=? WHERE KULLANICIADI=?";

            PreparedStatement ps = connect().prepareStatement(sql);
            ps.setString(1, ad);  //AD
            ps.setString(2, soyad);  //SOYAD
            ps.setString(3, pozisyon); //POZISYON
            ps.setString(4, kullaniciAdi);  //KULLANICIADI
            ps.setString(5, sifre_txt); //PAROLA
            ps.setString(6, eskiKullaniciAdi);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getPozisyon(String kullaniciAd) {

        String pozisyon = "";
        try {

            String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
            Statement s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                if (rs.getString("KULLANICIADI").equals(kullaniciAd)) {
                    pozisyon = rs.getString("POZISYON");
                    return pozisyon;

                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

  

    public void gorevEkle(String aciklama, String kullaniciAd, java.sql.Date tarih, java.sql.Time baslangic, java.sql.Time bitis, DefaultTableModel dtm) {
        int kullaniciId = 0;
        int gorevid = 0;

        System.out.println("saat1 : " + baslangic.toString());
        System.out.println("saat2 : " + bitis.toString());
        String sql = "SELECT * FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "'";
        Statement s;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {
                if (rs.getString("KULLANICIADI").equals(kullaniciAd)) {
                    kullaniciId = rs.getInt("ID");

                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2 = "INSERT INTO gorev (hemsireid, gorevadi, bitissaati, gorevdurum, tarih, baslangicsaati) VALUES (?,?,?,?,?,?)";
        PreparedStatement ps;

        try {
            ps = connect().prepareStatement(sql2);

            ps.setInt(1, kullaniciId);
            ps.setString(2, aciklama);
            ps.setTime(3, bitis);
            ps.setString(4, "Yapılmadı");
            ps.setDate(5, tarih);
            ps.setTime(6, baslangic);

            ps.executeUpdate();
            isler(dtm, kullaniciAd, tarih);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void atanmisHastalar(DefaultTableModel dtm) {

        String hastaAdSoyad = "";
        int hastaId = 0;
        int odaNo = 0;
        String doktor = "";

        String sql = "SELECT * FROM a.Hemsire_Hasta hh inner join Hasta h on h.HASTAID=hh.HASTAID ";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hastaAdSoyad = rs.getString("HASTAADI") + " ";
                hastaAdSoyad += rs.getString("HASTASOYADI");
                hastaId = rs.getInt("HASTAID");
                odaNo = rs.getInt("HASTAODANO");
                doktor = rs.getString("DOKTOR");
                System.out.println(hastaAdSoyad);
                System.out.println(hastaId);
                System.out.println(odaNo);
                System.out.println(doktor);
                dtm.addRow(new Object[]{odaNo, hastaId, hastaAdSoyad, doktor});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void atanmamisHastalar(DefaultTableModel dtm) {

        String hastaAdSoyad = "";
        int hastaId = 0;
        int odaNo = 0;
        String doktor = "";

        String sql = "SELECT * FROM a.Hasta WHERE HASTAID NOT IN (SELECT HASTAID FROM a.HEMSIRE_HASTA)  ";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hastaAdSoyad = rs.getString("HASTAADI") + " ";
                hastaAdSoyad += rs.getString("HASTASOYADI");
                hastaId = rs.getInt("HASTAID");
                odaNo = rs.getInt("HASTAODANO");
                doktor = rs.getString("DOKTOR");
                System.out.println(hastaAdSoyad);
                System.out.println(hastaId);
                System.out.println(odaNo);
                System.out.println(doktor);
                dtm.addRow(new Object[]{odaNo, hastaId, hastaAdSoyad, doktor});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

   
    public void isler(DefaultTableModel dtm, String kullaniciAd, java.sql.Date tarih) {

        String sql = "SELECT * FROM a.GOREV WHERE HEMSIREID IN (SELECT HEMSIREID FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "')";
        Statement s;
        Time saat;
        String gorev;
        String gorevDurum;
        String satir;
        int satirNo;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                if (rs.getDate("TARIH").equals(tarih)) {
                    gorev = rs.getString("GOREVADI");
                    saat = rs.getTime("BASLANGICSAATI");
                    satir = saat.toString().charAt(0) + "" + saat.toString().charAt(1);
                    satirNo = Integer.parseInt(satir);
                    gorevDurum = rs.getString("GOREVDURUM");
                    System.out.println("satir no : " + satirNo);
                   
                            dtm.setValueAt(gorev, satirNo, 1);
                            dtm.setValueAt(gorevDurum, satirNo, 2);
                          
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public int atanmisHastaSayisi() {
        int atanmisHastaSayisi = 0;

        String sql = "SELECT * FROM a.Hemsire_Hasta hh inner join Hasta h on h.HASTAID=hh.HASTAID ";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                atanmisHastaSayisi++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atanmisHastaSayisi;

    }

    public int atanmamisHastaSayisi() {

        int atanmamisHastaSayisi = 0;
        String sql = "SELECT * FROM a.Hasta WHERE HASTAID NOT IN (SELECT HASTAID FROM a.HEMSIRE_HASTA)  ";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                atanmamisHastaSayisi++;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return atanmamisHastaSayisi;
    }

    public void hemsireler(DefaultListModel dlm) {
        String hemsireAdSoyad;

        String sql = "SELECT * FROM a.HEMSIRE";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hemsireAdSoyad = rs.getString("ADI") + " ";
                hemsireAdSoyad += rs.getString("SOYADI");
                dlm.addElement(hemsireAdSoyad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void hemsireBul(DefaultComboBoxModel dcm) {
        Statement s;
        try {
            s = connect().createStatement();
            // ResultSet rs = s.executeQuery("select * from a.hemsire where ADI like'" + a + "'");
            ResultSet rs = s.executeQuery("select * from a.HEMSIRE");
            while (rs.next()) {

                dcm.addElement(rs.getString("ADI") + " " + rs.getString("SOYADI"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void hemsireBul(DefaultComboBoxModel dcm, String a) {
        Statement s;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery("select * from a.hemsire where ADI like'" + a + "'");

            while (rs.next()) {

                dcm.addElement(rs.getString("ADI") + " " + rs.getString("SOYADI"));
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    public void hemsireAta(int hastaId, String hemsireAdSoyad) {
        String adSoyad[] = hemsireAdSoyad.split(" ");
        int hemsireId = 0;
        Statement s;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery("Select ID FROM A.HEMSIRE WHERE ADI='" + adSoyad[0] + "' AND SOYADI='" + adSoyad[1] + "'");

            while (rs.next()) {
                hemsireId = rs.getInt("ID");
                break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        String sql2 = "INSERT INTO HEMSIRE_HASTA (HEMSIREID,HASTAID) VALUES (?,?)";
        PreparedStatement ps;

        try {
            ps = connect().prepareStatement(sql2);

            ps.setInt(1, hemsireId);
            ps.setInt(2, hastaId);

            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ayrintiliHastaBilgisi(DefaultTableModel dtmTumHastalar) {

        String sql = "SELECT * FROM a.HASTA";
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {

                // "Hasta No", "Hasta Adı","Hasta Soyadı", "Doktor Adı","Hemşire Adı"
                dtmTumHastalar.addRow(new Object[]{rs.getInt("HASTAID"), rs.getString("HASTAADI"), rs.getString("HASTASOYADI"), rs.getString("doktor")});
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sorgula(DefaultTableModel dtmSorgu, String hastaNo) {
        boolean hastaNoMu = false;
        boolean hastaAdiMi = false;
        boolean hastaSoyadiMi = false;

        if (!hastaNo.equals(" ")) {
            hastaNoMu = true;
            int hastaTc = Integer.valueOf(hastaNo);
            String sql = "SELECT * FROM a.HASTA where HASTAID=" + hastaTc;
            Statement s;

            try {
                s = connect().createStatement();
                ResultSet rs = s.executeQuery(sql);
                while (rs.next()) {

                    dtmSorgu.addRow(new Object[]{rs.getInt("HASTAID"), rs.getString("HASTAADI"), rs.getString("HASTASOYADI"), rs.getString("DOKTOR")});
                }

            } catch (SQLException ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

    }


    public void shiftListesi(DefaultListModel dlm, int hastaId) {
        String hemsireAdSoyad,hastaAdSoyad;
 String sql = "SELECT * FROM a.HEMSIRE WHERE ID IN (SELECT HEMSIREID FROM a.HEMSIRE_HASTA WHERE HASTAID = " + hastaId +")";
      
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hemsireAdSoyad = rs.getString("ADI") + " ";
                hemsireAdSoyad += rs.getString("SOYADI");
                
                dlm.addElement(hemsireAdSoyad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 

    public void gorevDurumGuncelle(int timeNo, String kullaniciAd, java.sql.Date tarih, String durum, DefaultTableModel dtm) {
        String sql = "SELECT * FROM a.GOREV WHERE HEMSIREID IN (SELECT HEMSIREID FROM a.HEMSIRE WHERE KULLANICIADI='" + kullaniciAd + "')";
        Statement s;
        Time saat;
        String gorev;
        String gorevDurum;
        String satir;
        int satirNo;
        int gorevid;
        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            int i = 0;
            while (rs.next()) {
                if (rs.getDate("TARIH").equals(tarih)) {
                    gorev = rs.getString("GOREVADI");
                    saat = rs.getTime("BASLANGICSAATI");
                    satir = saat.toString().charAt(0) + "" + saat.toString().charAt(1);
                    satirNo = Integer.parseInt(satir);
                    gorevid = rs.getInt("GOREVID");
                    gorevDurum = rs.getString("GOREVDURUM");
                    System.out.println("satir no : " + satirNo);
                    
                        if (satirNo == timeNo) {
                            try {
                              String sql2 = "UPDATE a.gorev SET gorevdurum=?  WHERE gorevid =" + gorevid;
                                PreparedStatement ps = connect().prepareStatement(sql2);
                                ps.setString(1, durum);
                                ps.executeUpdate();
                                
                            } catch (SQLException ex){
                                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            isler(dtm, kullaniciAd, tarih);
                            break;
                        
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hastaListesi(DefaultListModel dlm, String kullaniciAd) {
            String hastaAdSoyad;
 String sql = "SELECT * FROM HASTA WHERE HASTAID IN (SELECT HASTAID FROM HEMSIRE_HASTA WHERE HEMSIREID IN (SELECT ID FROM HEMSIRE WHERE KULLANICIADI = '" +kullaniciAd+"'))";
      
        Statement s;

        try {
            s = connect().createStatement();
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                hastaAdSoyad = rs.getString("HASTAADI") + " ";
                hastaAdSoyad += rs.getString("HASTASOYADI");
                
                dlm.addElement(hastaAdSoyad);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }



}
