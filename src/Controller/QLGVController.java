/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Main_Model;
import Model.*;
import Database.ConnectDB;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
/**
 *
 * @author DungxBuif
 */
public class QLGVController {
    ConnectDB cn = new ConnectDB();
    public void themGV(String ten,String gt, String sdt, String makhoa ){
        GiangVien gv =new GiangVien(ten, gt, sdt, makhoa);
        String sql ="insert into GIANGVIEN VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,gv.getMa().toString());
            ps.setString(2,ten);
            ps.setString(3,gt);
            ps.setString(4,sdt);
            ps.setString(5,makhoa);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm giảng viên thành công");
            themTK(gv.getMa());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm giảng viên thất bại");
            System.out.println(e);
        }
        this.getGV();
    }
    
     public void themTK (String id){
        String sql ="insert into TAIKHOAN VALUES(?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,"USGV."+id);
            ps.setString(3,"Giảng viên");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm tài khoản thất bại");
            System.out.println(e);
        }
    }
    
    public void getGV(){
        Main_Model.DanhSachGV.clear();
        String sql ="Select * from GIANGVIEN";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
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
    }
    
    public void xoaGV(String id){
        String sql ="DELETE FROM GIANGVIEN WHERE MaGV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá giảng viên thành công");
            xoaTK(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá giảng viên thất bại");
            System.out.println(e);
        }
        this.getGV();
    }
    
    public void xoaTK(String id){
        String sql ="DELETE FROM TAIKHOAN WHERE ID=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá tài khoản thất bại");
            System.out.println(e);
        }
    }
    
    public void suaGV(String ma,String ten,String gt, String sdt, String monday ){
        String sql ="UPDATE GIANGVIEN SET TenGV = ?,  GioiTinh = ?,  SDT = ?,  MonDay =?  WHERE MaGV=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ps.setString(2,gt);
            ps.setString(3,sdt);
            ps.setString(4,monday);
            ps.setString(5,ma);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getGV();
    }
    
     public void timMa(String ma){
        Main_Model.DanhSachGV.clear();
        String sql ="Select * from GIANGVIEN where MaGV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                GiangVien gv = new GiangVien();
                gv.setMa(rs.getString("MaGV"));
                gv.setTen(rs.getString("TenGV"));
                gv.setGioiTinh(rs.getString("GioiTinh")); 
                gv.setSdt(rs.getString("SDT"));
                gv.setMonDay(rs.getString("MonDay"));
                Main_Model.DanhSachGV.add(gv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được giảng viên");
            return;
        }
    }
    public void timMon(String mon){
        Main_Model.DanhSachGV.clear();
        String sql ="Select * from GIANGVIEN where MonDay=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,mon);
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
            System.out.println("Lỗi. Không tìm được giảng viên");
            return;
        }
    }
    public void timTen(String ten){
        Main_Model.DanhSachGV.clear();
        String sql ="Select * from GIANGVIEN where TenGV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
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
            System.out.println("Lỗi. Không tìm được giảng viên");
            return;
        }
    }
}
