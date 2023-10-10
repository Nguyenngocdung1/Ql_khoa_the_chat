/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author tiend
 */
public class KetQua {
    private String maLop,maSV,dieuKien;
    private int tietNghi;
    private float diemTX1,diemTX2,diemThi,diemTB;

    public KetQua() {
    }

    public KetQua(String maLop, String maSV, int tietNghi, float diemTX1, float diemTX2, float diemThi) {
        this.maLop = maLop;
        this.maSV = maSV;
        this.tietNghi = tietNghi;
        this.diemTX1 = diemTX1;
        this.diemTX2 = diemTX2;
        this.diemThi = diemThi;
    }

    public KetQua(String maLop) {
        this.maLop = maLop;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getDieuKien() {
        return dieuKien;
    }

    public void setDieuKien(String dieuKien) {
        this.dieuKien = dieuKien;
    }

    public int getTietNghi() {
        return tietNghi;
    }

    public void setTietNghi(int tietNghi) {
        this.tietNghi = tietNghi;
    }

    public float getDiemTX1() {
        return diemTX1;
    }

    public void setDiemTX1(float diemTX1) {
        this.diemTX1 = diemTX1;
    }

    public float getDiemTX2() {
        return diemTX2;
    }

    public void setDiemTX2(float diemTX2) {
        this.diemTX2 = diemTX2;
    }

    public float getDiemThi() {
        return diemThi;
    }

    public void setDiemThi(float diemThi) {
        this.diemThi = diemThi;
    }

//    public float getDiemTB() {
//        return diemTB;
//    }

//    public void setDiemTB(float diemTB) {
//        this.diemTB = diemTB;
//    }

  
    public float diemTB() {
        return diemTB=((diemTX1+diemTX2)/2+diemThi*2)/3;
    }
    public String xepLoai(){
    if( 4> diemTB)
        return "F";
    else if(4 <= diemTB && diemTB <=4.6)
        return "D";
    else if(4.6 <= diemTB && diemTB <=5.4)
        return "D+";
    else if(5.4 <= diemTB && diemTB <=6.1)
        return "C";
    else if(6.1 < diemTB && diemTB <=6.9)
        return "C+";
    else if(6.9 < diemTB && diemTB <=7.6)
        return "B";
    else if(7.6 < diemTB && diemTB <=8.4)
        return "B+";
    else 
        return "A";
    } 
    public  void dieuKienThi(int tongTiet, int tietNghi){
    if((tongTiet*0.3) <= tietNghi) 
        this.dieuKien = "Đủ điều Kiện";
    else 
        this.dieuKien =  "Không đủ điều kiện";
    }

//    public void gettietNghi(int tietNghi) {
//        
//    }


}
