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
public class DongPhuc {
    private String maDp, tenDp, size;
    private int soLuong;
    private double gia;
    private static int Ma = 7;

    public DongPhuc(String tenDp, String size, int soLuong, double gia) {
        this.tenDp = tenDp;
        this.size = size;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public DongPhuc() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String setMaDpAdd() {
        return maDp = "DP"+String.format("%02d", Ma+1);
        
    }
    
    public static int getMa() {
        return Ma;
    }

    public static void setMa(int Ma) {
        DongPhuc.Ma = Ma;
    }

    public String getMaDp() {
        return maDp;
    }

    public void setMaDp(String maDp) {
        this.maDp = maDp;
    }

    public String getTenDp() {
        return tenDp;
    }

    public void setTenDp(String tenDp) {
        this.tenDp = tenDp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
}
