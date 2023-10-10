    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.GiangVien;
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
public class QLLHController {
    ConnectDB cn = new ConnectDB();
    public void themLH(String maGv, String tenLop, String ngayBatDau, int tietHoc, int TongTiet, double hocPhi ){
        LopHoc lh =new LopHoc(maGv, tenLop, ngayBatDau, tietHoc, TongTiet, hocPhi);
        String sql ="insert into LOPHOC VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,lh.setMaLopTrue().toString());
            ps.setString(2, maGv);
            ps.setString(3,tenLop);
            ps.setString(4,ngayBatDau);
            ps.setInt(5,tietHoc);
            ps.setInt(6,TongTiet);
            ps.setDouble(7, hocPhi);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }
        this.getLH();
    }
    
    public void getLH(){
        Main_Model.DanhSachLH.clear();
        String sql ="Select * from LOPHOC";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rs.getString("MaLop"));
                lh.setMaGv(rs.getString("MaGv"));
                lh.setTenLop(rs.getString("TenLop"));
                lh.setNgayBatDau(rs.getString("NgayBatDau")); 
                lh.setTietHoc(rs.getInt("TietHoc"));
                lh.setTongTiet(rs.getInt("TongTiet"));
                lh.setHocPhi(rs.getDouble("HocPhi"));
                Main_Model.DanhSachLH.add(lh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách lớp học");
            return;
        }
        Collections.sort(Main_Model.DanhSachLH, new Comparator<LopHoc>(){
            @Override
            public int compare(LopHoc o1, LopHoc o2) {
                return o1.getTenLop().compareToIgnoreCase(o2.getTenLop());
            }
        });
    }
    
     public void xoaLH(String id){
        String sql ="DELETE FROM LOPHOC WHERE MaLop=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
            System.out.println(e);
        }
        this.getLH();
    }
    
    public void suaLH(String ma, String maGv, String tenLop, String ngayBatDau, int tietHoc, int TongTiet, double hocPhi ){
        String sql ="UPDATE LOPHOC SET MaGv = ?,  TenLop = ?,  NgayBatDau = ?,  TietHoc =?, TongTiet = ?, HocPhi = ?  WHERE MaLop=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,maGv);
            ps.setString(2,tenLop);
            ps.setString(3,ngayBatDau);
            ps.setInt(4,tietHoc);
            ps.setInt(5,TongTiet);
            ps.setDouble(6, hocPhi);
            ps.setString(7, ma);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getLH();
    }
    
    public void timMa(String ma){
        Main_Model.DanhSachLH.clear();
        String sql ="Select * from LOPHOC where MaLop=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rs.getString("MaLop"));
                lh.setMaGv(rs.getString("MaGv"));
                lh.setTenLop(rs.getString("TenLop"));
                lh.setNgayBatDau(rs.getString("NgayBatDau")); 
                lh.setTietHoc(rs.getInt("TietHoc"));
                lh.setTongTiet(rs.getInt("TongTiet"));
                lh.setHocPhi(rs.getDouble("HocPhi"));
                Main_Model.DanhSachLH.add(lh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được lớp học");
            return;
        }
    }
    public void timTen(String ten){
        Main_Model.DanhSachLH.clear();
        String sql ="Select * from LOPHOC where TenLop=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rs.getString("MaLop"));
                lh.setMaGv(rs.getString("MaGv"));
                lh.setTenLop(rs.getString("TenLop"));
                lh.setNgayBatDau(rs.getString("NgayBatDau")); 
                lh.setTietHoc(rs.getInt("TietHoc"));
                lh.setTongTiet(rs.getInt("TongTiet"));
                lh.setHocPhi(rs.getDouble("HocPhi"));
                Main_Model.DanhSachLH.add(lh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được lớp học");
            return;
        }
    }
    public void timMaGv(String magv){
        Main_Model.DanhSachLH.clear();
        String sql ="Select * from LOPHOC where MaGv=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,magv);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                LopHoc lh = new LopHoc();
                lh.setMaLop(rs.getString("MaLop"));
                lh.setMaGv(rs.getString("MaGv"));
                lh.setTenLop(rs.getString("TenLop"));
                lh.setNgayBatDau(rs.getString("NgayBatDau")); 
                lh.setTietHoc(rs.getInt("TietHoc"));
                lh.setTongTiet(rs.getInt("TongTiet"));
                lh.setHocPhi(rs.getDouble("HocPhi"));
                Main_Model.DanhSachLH.add(lh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được lớp học");
            return;
        }
    }
}
