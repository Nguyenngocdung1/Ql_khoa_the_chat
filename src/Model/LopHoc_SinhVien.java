/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author NVT
 */
public class LopHoc_SinhVien {
    private String maLop, maSV, tenLop, ngayBatDau;
    int tietHoc, tongTiet;

    public LopHoc_SinhVien(String maLop, String maSV, String tenLop, String ngayBatDau, int tietHoc, int tongTiet) {
        this.maLop = maLop;
        this.maSV = maSV;
        this.tenLop = tenLop;
        this.ngayBatDau = ngayBatDau;
        this.tietHoc = tietHoc;
        this.tongTiet = tongTiet;
    }
    public LopHoc_SinhVien() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaLop() {
        return maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public String getTenLop() {
        return tenLop;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public int getTietHoc() {
        return tietHoc;
    }

    public int getTongTiet() {
        return tongTiet;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public void setTietHoc(int tietHoc) {
        this.tietHoc = tietHoc;
    }

    public void setTongTiet(int tongTiet) {
        this.tongTiet = tongTiet;
    }
    
}
