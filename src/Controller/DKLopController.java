/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.KetQua;
import Model.LopHoc;
import Model.Main_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class DKLopController {
    ConnectDB cn = new ConnectDB();
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
    }
        public void getKQ() {
            Main_Model.KetQua.clear();
            Main_Model.DanhSachDK.clear();
            String sql = "Select LOPHOC.MaLop,TenLop,NGAYBATDAU,DIEM1,DIEM2,TIETNGHI,DIEMTHI "
                    + "FROM KETQUA, LOPHOC"
                    + " WHERE KETQUA.MALOP = LOPHOC.MALOP AND MASV=?";
            try {
                PreparedStatement ps = cn.conn.prepareStatement(sql);
                ps.setString(1, Main_Model.user.getID());
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    LopHoc lop = new LopHoc();
                    KetQua kq = new KetQua();
                    kq.setMaLop(rs.getString("MALOP"));
                    lop.setTenLop(rs.getString("TenLop"));
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.setNgayBatDau(rs.getString("NGAYBATDAU"));
                    kq.setDiemTX1(rs.getFloat("Diem1"));
                    kq.setDiemTX2(rs.getFloat("Diem2"));
                    kq.setTietNghi(rs.getInt("TIETNGHI"));
                    kq.setDiemThi(rs.getFloat("DiemThi"));

                    Main_Model.DanhSachDK.add(lop);
                    Main_Model.KetQua.add(kq);
                }
            } catch (Exception e) {
                System.out.println("Lỗi. Không lấy được kết quả" + e);
                return;
            }
        }
        public void themKQM(String maLop)
        {
            Main_Model.KetQua.clear();
            String sql ="insert into KETQUA VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement ps = cn.conn.prepareStatement(sql);
                ps.setString(1,maLop);
                ps.setString(2,Main_Model.user.getID());
                ps.setString(3, "0");
                ps.setString(4, "0");
                ps.setString(5, "0");
                ps.setString(6, "0");
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Thêm thành công");
                getKQ();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
                System.out.println(e);
            }
        }
       public void xoaLH(String id){
        String sql ="DELETE FROM KEtQUA WHERE MaLop=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
            System.out.println(e);
        }
        this.getKQ();
    }

}
