/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Main_Model;
import Model.SinhVien;
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
public class QLSVController {
    ConnectDB cn = new ConnectDB();
    public void themSV(String ten,String gt, String sdt, String makhoa ){
        SinhVien sv =new SinhVien(ten, gt, sdt, makhoa);
        String sql ="insert into SINHVIEN VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,sv.getMa().toString());
            ps.setString(2,ten);
            ps.setString(3,gt);
            ps.setString(4,sdt);
            ps.setString(5,makhoa);
            ps.execute();
            themTK(sv.getMa());
            JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm sinh viên thất bại");
            System.out.println(e);
        }
        this.getSV();
    }
    
    public void themTK (String id){
        String sql ="insert into TAIKHOAN VALUES(?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,id);
            ps.setString(2,"USSV."+id);
            ps.setString(3,"Sinh viên");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Thêm tài khoản thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm tài khoản thất bại");
            System.out.println(e);
        }
        this.getSV();
    }
    
    public void getSV(){
        Main_Model.DanhSachSV.clear();
        String sql ="Select * from SINHVIEN";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
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
   
    }
    
    public void xoaSV(String id){
        String sql ="DELETE FROM SINHVIEN WHERE MaSV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá sinh viên thành công");
            xoaTK(id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá sinh viên thất bại");
            System.out.println(e);
        }
        this.getSV();
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
    
    public void suaSV(String ma,String ten,String gt, String sdt, String makhoa ){
        String sql ="UPDATE SINHVIEN SET TenSV = ?,  GioiTinh = ?,  SDT = ?,  MaKhoa =?  WHERE MaSV=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ps.setString(2,gt);
            ps.setString(3,sdt);
            ps.setString(4,makhoa);
            ps.setString(5,ma);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getSV();
    }
    
    public void timMa(String ma){
        Main_Model.DanhSachSV.clear();
        String sql ="Select * from SINHVIEN where MaSV=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                SinhVien sv = new SinhVien();
                sv.setMa(rs.getString("MaSV"));
                sv.setTen(rs.getString("TenSV"));
                sv.setGioiTinh(rs.getString("GioiTinh")); 
                sv.setSdt(rs.getString("SDT"));
                sv.setMaKhoa(rs.getString("MaKhoa"));
                Main_Model.DanhSachSV.add(sv);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được sinh viên");
            return;
        }
    }
    public void timKhoa(String khoa){
        Main_Model.DanhSachSV.clear();
        String sql ="Select * from SINHVIEN where MaKhoa=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,khoa);
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
            System.out.println("Lỗi. Không tìm được sinh viên");
            return;
        }
    }
    public void timTen(String ten){
        Main_Model.DanhSachSV.clear();
        String sql ="Select * from SINHVIEN where TenSV = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
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
            System.out.println("Lỗi. Không tìm được sinh viên");
            return;
        }
    }
    
}
