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

public class Hastane {
    
   private int hastaneId=5;
   private String adi="FATİH SULTAN MEHMET HASTANESİ";
 

    public int getHastaneId() {
        return hastaneId;
    }

    public String getAdi() {
        return adi;
    }

  
    public void Hastane(int hastaneId){
        this.hastaneId=hastaneId;

}
            
}
