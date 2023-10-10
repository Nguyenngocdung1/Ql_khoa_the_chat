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
public class Nguoi {
    private String ma,ten,gioiTinh,sdt;
    public Nguoi() {
    }

    public Nguoi(String ma, String ten, String gioiTinh, String sdt) {
        this.ma = ma;
        this.ten = ten;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    
    
    public String getMa() {
        return ma;
    }

    
    public String getTen() {
        return ten;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }


    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    
    
}
