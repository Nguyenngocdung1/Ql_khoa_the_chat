/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.DongPhuc;
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
public class QLDPController {

    ConnectDB cn = new ConnectDB();

    public void themDP(String tenDp, String size, int soLuong, double gia) {
        DongPhuc dp = new DongPhuc(tenDp, size, soLuong, gia);
        String sql = "INSERT INTO DONGPHUC VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, dp.setMaDpAdd().toString());
            ps.setString(2, tenDp);
            ps.setInt(3, soLuong);
            ps.setString(4, size);
            ps.setDouble(5, gia);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }
        this.getDP();
    }

    public void getDP() {
        Main_Model.DanhSachDP.clear();
        String sql = "Select * from DONGPHUC";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongPhuc dp = new DongPhuc();
                dp.setMaDp(rs.getString("MaDP"));
                dp.setTenDp(rs.getString("TenDP"));
                dp.setSoLuong(rs.getInt("SL"));
                dp.setSize(rs.getString("SIZE"));
                dp.setGia(rs.getDouble("Gia"));
                Main_Model.DanhSachDP.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách lớp học");
            return;
        }
        Collections.sort(Main_Model.DanhSachDP, new Comparator<DongPhuc>() {
            @Override
            public int compare(DongPhuc o1, DongPhuc o2) {
                return o1.getTenDp().compareToIgnoreCase(o2.getTenDp());
            }
        });
    }

    public void xoaDP(String id) {
        String sql = "DELETE FROM DONGPHUC WHERE MaDP = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
            System.out.println(e);
        }
        this.getDP();
    }

    public void suaDP(String maDp, String tenDp, String size, int soLuong, double gia) {
        String sql = "UPDATE DONGPHUC SET TenDP = ?,  SIZE = ?,  SL = ?,  Gia = ?  WHERE MaDP=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, tenDp);
            ps.setString(2, size);
            ps.setInt(3, soLuong);
            ps.setDouble(4, gia);
            ps.setString(5, maDp);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getDP();
    }
    
     public void timMa(String ma){
        Main_Model.DanhSachDP.clear();
        String sql ="Select * from DONGPHUC where MaDP=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ma);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                DongPhuc dp = new DongPhuc();
                dp.setMaDp(rs.getString("MaDP"));
                dp.setTenDp(rs.getString("TenDP"));
                dp.setSize(rs.getString("SIZE")); 
                dp.setSoLuong(rs.getInt("SL"));
                dp.setGia(rs.getDouble("Gia"));
                Main_Model.DanhSachDP.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được đồng phục");
            return;
        }
    }
    public void timTen(String ten){
       Main_Model.DanhSachDP.clear();
        String sql ="Select * from DONGPHUC where TenDP=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DongPhuc dp = new DongPhuc();
                dp.setMaDp(rs.getString("MaDP"));
                dp.setTenDp(rs.getString("TenDP"));
                dp.setSize(rs.getString("SIZE")); 
                dp.setSoLuong(rs.getInt("SL"));
                dp.setGia(rs.getDouble("Gia"));
                Main_Model.DanhSachDP.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được đồng phục");
            return;
        }
    }
    public void timGia(String gia){
       Main_Model.DanhSachDP.clear();
        String sql ="Select * from DONGPHUC where Gia=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,gia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                DongPhuc dp = new DongPhuc();
                dp.setMaDp(rs.getString("MaDP"));
                dp.setTenDp(rs.getString("TenDP"));
                dp.setSize(rs.getString("SIZE")); 
                dp.setSoLuong(rs.getInt("SL"));
                dp.setGia(rs.getDouble("Gia"));
                Main_Model.DanhSachDP.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không tìm được đồng phục");
            return;
        }
    }
    
}
