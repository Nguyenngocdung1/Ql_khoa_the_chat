/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.DungCu;
import Model.LopHoc;
import Model.Main_Model;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;
/**
 *
 * @author Ngoc Dung
 */
public class QLDCController {
    ConnectDB cn = new ConnectDB();
    public void themDC(String tenDungCu, int soLuong, String tinhTrang ){
        DungCu dc =new DungCu(tenDungCu, soLuong, tinhTrang);
        String sql ="insert into DUNGCU VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,dc.setMaDcReal().toString());
            ps.setString(2, tenDungCu);
            ps.setInt(3,soLuong);
            ps.setString(4,tinhTrang);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }
        this.getDC();
    }
    
    public void getDC(){
        Main_Model.DanhSachDC.clear();
        String sql ="Select * from DUNGCU";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                DungCu dc = new DungCu();
                dc.setMaDc(rs.getString("MaDc"));
                dc.setTenDc(rs.getString("TenDC"));
                dc.setSoLuong(rs.getInt("TongSl"));
                dc.setTinhTrang(rs.getString("TinhTrang")); 
                Main_Model.DanhSachDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách lớp học");
            return;
        }
        Collections.sort(Main_Model.DanhSachDC, new Comparator<DungCu>(){
            @Override
            public int compare(DungCu o1, DungCu o2) {
                return o1.getTenDc().compareToIgnoreCase(o2.getTenDc());
            }
        });
    }
    
     public void xoaDC(String id){
        String sql ="DELETE FROM DUNGCU WHERE MaDc=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
            System.out.println(e);
        }
        this.getDC();
    }
    
    public void suaDC(String maDc, String tenDungCu, int soLuong, String tinhTrang ){
        String sql ="UPDATE DUNGCU SET TenDC = ?,  TongSl = ?,  TinhTrang = ?  WHERE MaDc=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,tenDungCu);
            ps.setInt(2,soLuong);
            ps.setString(3,tinhTrang);
            ps.setString(4, maDc);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getDC();
    }
    
     public void timMa(String ma){
        Main_Model.DanhSachDC.clear();
        String sql ="Select * from DUNGCU where MaDC=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                DungCu dc = new DungCu();
                dc.setMaDc(rs.getString("MaDC"));
                dc.setTenDc(rs.getString("TenDC"));
                dc.setSoLuong(rs.getInt("TongSl")); 
                dc.setTinhTrang(rs.getString("TinhTrang"));
                Main_Model.DanhSachDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được dụng cụ");
            return;
        }
    }
    public void timTen(String ten){
       Main_Model.DanhSachDC.clear();
        String sql ="Select * from DUNGCU where TenDC=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DungCu dc = new DungCu();
                dc.setMaDc(rs.getString("MaDC"));
                dc.setTenDc(rs.getString("TenDC"));
                dc.setSoLuong(rs.getInt("TongSl")); 
                dc.setTinhTrang(rs.getString("TinhTrang"));
                Main_Model.DanhSachDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được dụng cụ");
            return;
        }
    }
    public void timTinhTrang(String tt){
        Main_Model.DanhSachDC.clear();
        String sql ="Select * from DUNGCU where TinhTrang=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,tt);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DungCu dc = new DungCu();
                dc.setMaDc(rs.getString("MaDC"));
                dc.setTenDc(rs.getString("TenDC"));
                dc.setSoLuong(rs.getInt("TongSl")); 
                dc.setTinhTrang(rs.getString("TinhTrang"));
                Main_Model.DanhSachDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được dụng cụ");
            return;
        }
    }
}
