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
public class GiangVien extends Nguoi{
    private String monDay;
    static private int MA = 4;

    public GiangVien() {
        super();
    }

    public GiangVien(String monDay) {
        this.monDay = monDay;
    }

    public GiangVien(String ten, String gioiTinh, String sdt ,String monDay) {
        super("GV" +String.format("%02d", MA+1), ten, gioiTinh, sdt);
        this.monDay = monDay;
        MA++;
    }

    
    
    public String getMonDay() {
        return monDay;
    }

    public static int getMA() {
        return MA;
    }

    public void setMonDay(String monDay) {
        this.monDay = monDay;
    }

    public static void setMA(int MA) {
        GiangVien.MA = MA;
    }
    
    
    
    
    
}
