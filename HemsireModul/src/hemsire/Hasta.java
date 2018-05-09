/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hemsire;

/**
 *
 * @author seeda
 */
import java.util.ArrayList;
import java.util.Date;

public class Hasta {

    static ArrayList<Hasta> hastalar = new ArrayList();

    private String adi, soyadi, dogumYeri, babaAdi, anneAdi, email;
    private String cinsiyet, diyabet, kanGrubu, sosyalGüvenlik, hepatit, hiv;
    private String telefon, tcNo;
    private Date dogumTarihi;

    public String toString() {
        return "Hasta{" + "adi=" + adi + ", soyadi=" + soyadi + ", dogumYeri=" + dogumYeri + ", babaAdi=" + babaAdi + ", anneAdi=" + anneAdi + ", email=" + email + ", cinsiyet=" + cinsiyet + ", diyabet=" + diyabet + ", kanGrubu=" + kanGrubu + ", sosyalG\u00fcvenlik=" + sosyalGüvenlik + ", hepatit=" + hepatit + ", hiv=" + hiv + ", telefon=" + telefon + ", tcNo=" + tcNo + ", dogumTarihi=" + dogumTarihi + '}';
    }

    public String getTcNo() {
        return tcNo;
    }

    public void setTcNo(String tcNo) {
        this.tcNo = tcNo;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getDogumYeri() {
        return dogumYeri;
    }

    public void setDogumYeri(String dogumYeri) {
        this.dogumYeri = dogumYeri;
    }

    public String getBabaAdi() {
        return babaAdi;
    }

    public void setBabaAdi(String babaAdi) {
        this.babaAdi = babaAdi;
    }

    public String getAnneAdi() {
        return anneAdi;
    }

    public void setAnneAdi(String anneAdi) {
        this.anneAdi = anneAdi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getDiyabet() {
        return diyabet;
    }

    public void setDiyabet(String diyabet) {
        this.diyabet = diyabet;
    }

    public String getKanGrubu() {
        return kanGrubu;
    }

    public void setKanGrubu(String kanGrubu) {
        this.kanGrubu = kanGrubu;
    }

    public String getSosyalGüvenlik() {
        return sosyalGüvenlik;
    }

    public void setSosyalGüvenlik(String sosyalGüvenlik) {
        this.sosyalGüvenlik = sosyalGüvenlik;
    }

    public String getHepatit() {
        return hepatit;
    }

    public void setHepatit(String hepatit) {
        this.hepatit = hepatit;
    }

    public String getHiv() {
        return hiv;
    }

    public void setHiv(String hiv) {
        this.hiv = hiv;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Date getDogumTarihi() {
        return dogumTarihi;
    }

    public void setDogumTarihi(Date dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }
}
