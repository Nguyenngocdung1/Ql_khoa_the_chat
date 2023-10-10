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
public class LopHoc {

    private String maLop, maGv, tenLop, ngayBatDau;
    private int tietHoc, tongTiet;
    private double hocPhi;
    private static int MA = 4;

    public LopHoc() {

    }

    public String getMaGv() {
        return maGv;
    }

    public void setMaGv(String maGv) {
        this.maGv = maGv;
    }

    public LopHoc(String maGv, String tenLop, String ngayBatDau, int tietHoc, int tongTiet, double hocPhi) {
        this.maLop = "L0" + String.format("%02d", MA + 1);
        this.maGv = maGv;
        this.tenLop = tenLop;
        this.ngayBatDau = ngayBatDau;
        this.tietHoc = tietHoc;
        this.tongTiet = tongTiet;
        this.hocPhi = hocPhi;
        MA++;

    }

    public String setMaLopTrue() {
        return maLop = "L0" + String.format("%02d", MA + 1);
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public int getTietHoc() {
        return tietHoc;
    }

    public void setTietHoc(int tietHoc) {
        this.tietHoc = tietHoc;
    }

    public int getTongTiet() {
        return tongTiet;
    }

    public void setTongTiet(int tongTiet) {
        this.tongTiet = tongTiet;
    }

    public double getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(double hocPhi) {
        this.hocPhi = hocPhi;
    }

    public static int getMA() {
        return MA;
    }

    public static void setMA(int MA) {
        LopHoc.MA = MA;
    }

}
