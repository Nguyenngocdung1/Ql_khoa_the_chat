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
public class DungCu {
    private String maDc, tenDc, tinhTrang;
    private int soLuong;
    private static int Ma = 7;

    public DungCu() {

    }

    public DungCu(String tenDc, int soLuong, String tinhTrang) {
        this.maDc = "DC" + String.format("%02d", Ma + 1);
        this.tenDc = tenDc;
        this.soLuong = soLuong;
        this.tinhTrang = tinhTrang;
    }

    public String setMaDcReal() {
        return maDc = "DC" + String.format("%02d", Ma + 1);
    }

    public String getMaDc() {
        return maDc;
    }

    public void setMaDc(String maDc) {
        this.maDc = maDc;
    }

    public String getTenDc() {
        return tenDc;
    }

    public void setTenDc(String tenDc) {
        this.tenDc = tenDc;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
