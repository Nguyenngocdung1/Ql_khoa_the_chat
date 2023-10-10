/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.GiangVien;
import Model.Main_Model;
import Model.SinhVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class XemTTTKController {
    ConnectDB cn = new ConnectDB();
   String maKhoa,maMon;
        public void getGV(){
        Main_Model.DanhSachGV.clear();
        String sql ="Select * from GIANGVIEN where MaGV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,Main_Model.user.getID());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                GiangVien gv = new GiangVien();
                gv.setMa(rs.getString("MaGV"));
                gv.setTen(rs.getString("TenGV"));
                gv.setGioiTinh(rs.getString("GioiTinh")); 
                gv.setSdt(rs.getString("SDT"));
                gv.setMonDay(rs.getString("MonDay"));
                Main_Model.DanhSachGV.add(gv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách giảng viên");
            return;
        }
        Collections.sort(Main_Model.DanhSachGV, new Comparator<GiangVien>(){
            @Override
            public int compare(GiangVien o1, GiangVien o2) {
                return o1.getTen().compareToIgnoreCase(o2.getTen());
            }
            
        });
    }
        public void getSV(){
        Main_Model.DanhSachSV.clear();
        String sql ="Select * from SINHVIEN where MaSV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, Main_Model.user.getID());
           // ps.setString(1, "SV01");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMa(rs.getString("MaSV"));
                sv.setTen(rs.getString("TenSV"));
                sv.setGioiTinh(rs.getString("GioiTinh")); 
                sv.setSdt(rs.getString("SDT"));
                sv.setMaKhoa(rs.getString("MaKhoa"));
                Main_Model.DanhSachSV.add(sv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách sinh viên");
            return;
        }
        Collections.sort(Main_Model.DanhSachSV, new Comparator<SinhVien>(){
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getTen().compareToIgnoreCase(o2.getTen());
            }
            
        });
    }
            public void suaGV(String ma,String ten,String gt, String sdt){
        String sql ="UPDATE GIANGVIEN SET TenGV = ?,  GioiTinh = ?,  SDT = ?, MonDay = MonDay WHERE MaGV=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ps.setString(2,gt);
            ps.setString(3,sdt);
            ps.setString(4,ma);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thông tin thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getGV();
    }
            public void suaSV(String ma,String ten,String gt, String sdt ){
        String sql ="UPDATE SINHVIEN SET TenSV = ?,  GioiTinh = ?,  SDT = ?  ,MaKhoa = MaKhoa  WHERE MaSV=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ps.setString(2,gt);
            ps.setString(3,sdt);
            ps.setString(4,ma);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thông tin thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getSV();
    }
}