/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author DungxBuif
 */
public class User {
    private String ID,MK,Loai;

    public User() {
    }

    public User(String ID, String MK, String Loai) {
        this.ID = ID;
        this.MK = MK;
        this.Loai = Loai;
    }

    
    
    public String getID() {
        return ID;
    }

    public String getMK() {
        return MK;
    }

    public String getLoai() {
        return Loai;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public void setLoai(String Loai) {
        this.Loai = Loai;
    }
    
    
}
