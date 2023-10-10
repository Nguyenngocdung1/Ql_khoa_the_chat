/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Ngoc Dung
 */
public class MuonDC {
    private static int autoId = 0;
    private int id = 0;
    private String MaLop, MaDc, NgayMuon;
    private int soluong;
    public int generatedId() {
        autoId++;
        return autoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getMaDc() {
        return MaDc;
    }

    public void setMaDc(String MaDc) {
        this.MaDc = MaDc;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "MuonDC{" + "id=" + id +  "MaLop=" + MaLop + ", MaDc=" + MaDc + ", NgayMuon=" + NgayMuon + ", soluong=" + soluong + '}';
    }
    
}
