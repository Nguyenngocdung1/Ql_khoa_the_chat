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
public class SinhVien extends Nguoi{
    private String maKhoa;
    private static int MA=5;
    public SinhVien() {
        super();
    }

    public SinhVien(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public SinhVien(String ten, String gt,String sdt,String mk){
        super("SV"+String.format("%02d", MA+1), ten, gt, sdt);
        this.maKhoa = mk;
        MA++;
    }
    

    
    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
    
    
}
