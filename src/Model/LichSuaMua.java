/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

public class LichSuaMua {
    private String maDp,maSV;
    private int soLuong;

    public LichSuaMua() {
    }

    public LichSuaMua(String maDp, String maSV, int soLuong) {
        this.maDp = maDp;
        this.maSV = maSV;
        this.soLuong = soLuong;
    }

    public LichSuaMua(String maSV, int soLuong) {
        this.maSV = maSV;
        this.soLuong = soLuong;
    }
    
    public String getMaDp() {
        return maDp;
    }
  

    public void setMaDp(String maDp) {
        this.maDp = maDp;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
}
