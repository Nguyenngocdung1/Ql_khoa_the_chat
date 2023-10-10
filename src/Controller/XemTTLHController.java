/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.LopHoc;
import Model.LopHoc_SinhVien;
import Model.Main_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author NVT
 */
public class XemTTLHController {
    ConnectDB cn = new ConnectDB();
    public void getLH(){
        Main_Model.DanhSachLH.clear();
        String sql ="Select * from LOPHOC where MaGv=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,Main_Model.user.getID());
//            ps.executeQuery();
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
    public void getLHSV(){
        Main_Model.DanhSachLK.clear();
        String sql ="Select lh.MaLop, kq.MaSv, TenLop, NgayBatDau, TietHoc, TongTiet  from KETQUA kq, LOPHOC lh where lh.MaLop = kq.MaLop AND kq.MaSV = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,Main_Model.user.getID());
//            ps.executeQuery();
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc_SinhVien lh = new LopHoc_SinhVien();
                lh.setMaLop(rs.getString("MaLop"));
                lh.setMaSV(rs.getString("MaSV"));
                lh.setTenLop(rs.getString("TenLop"));
                lh.setNgayBatDau(rs.getString("NgayBatDau")); 
                lh.setTietHoc(rs.getInt("TietHoc"));
                lh.setTongTiet(rs.getInt("TongTiet"));
                Main_Model.DanhSachLK.add(lh);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách lớp học");
            return;
        }
        Collections.sort(Main_Model.DanhSachLK, new Comparator<LopHoc_SinhVien>(){

            @Override
            public int compare(LopHoc_SinhVien o1, LopHoc_SinhVien o2) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                return o1.getMaLop().compareToIgnoreCase(o2.getMaLop());
            }
        });
    }
}
