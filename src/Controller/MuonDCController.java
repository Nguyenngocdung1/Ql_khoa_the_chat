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
import Model.MuonDC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Le Duc
 */
public class MuonDCController {

    ConnectDB cn = new ConnectDB();

    public int checkSL(String madc, int soluong) {
        try {
            String sql = "Select * from DUNGCU where MADC =?";
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, madc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                DungCu u = new DungCu();
                u.setSoLuong(rs.getInt("TongSL"));
                int sl = u.getSoLuong();
                return sl;
            }
        } catch (SQLException e) {
            System.out.println(e);
            return 9999;
        }
        return 9999;
    }

    public String checkMaLop(String malop) {
        Main_Model.DanhSachSV.clear();
        try {
            String sql = "Select * from LOPHOC where MALOP =?";
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, malop);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                LopHoc lh = new LopHoc();
                lh.setMaLop(rs.getString("MALOP"));
                String ml = rs.getString("MALOP");
                if (ml != "") {
                    return "true";
                } else {
                    return "false";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }

    public void suaDC(String maDc, int soLuong) {
        String sql = "UPDATE DUNGCU SET  TongSl = ?, TenDC = TenDC, TinhTrang = TinhTrang  WHERE MaDc=? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setString(2, maDc);
            ps.executeUpdate();
            //JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
            return;
        }
    }

    public void themDSMuon(String madc, String malop, int soluong, String date, int slcon) {
        MuonDC mdc = new MuonDC();
        String sql = "insert into MUONDC VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setInt(1, mdc.generatedId());
            ps.setString(2, malop);
            ps.setString(3, madc);
            ps.setInt(4, soluong);
            ps.setString(5,date);
            ps.executeUpdate();
            suaDC(madc, slcon);
            JOptionPane.showMessageDialog(null, "Mượn thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Mượn thất bại");
            System.out.println(e);
            return;
        }
        this.getDC(); 
        this.getDCMuon();
        
        
    }

    public void getDC() {
        Main_Model.DanhSachDC.clear();
        String sql = "SELECT * FROM DUNGCU";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DungCu dc = new DungCu();
                dc.setMaDc(rs.getString("MaDC"));
                dc.setTenDc(rs.getString("TenDC"));
                dc.setSoLuong(rs.getInt("TongSL"));
                dc.setTinhTrang(rs.getString("TinhTrang"));
                Main_Model.DanhSachDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách dụng cụ");
            return;
        }
        Collections.sort(Main_Model.DanhSachDC, new Comparator<DungCu>() {
            @Override
            public int compare(DungCu o1, DungCu o2) {
                return o1.getTenDc().compareToIgnoreCase(o2.getTenDc());
            }
        });
    }
    
    public void getDCMuon() {
        Main_Model.DanhSachMuonDC.clear();
        String sql = "SELECT * FROM MUONDC";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MuonDC dc = new MuonDC();
                dc.setId(rs.getInt("MaMDC"));
                dc.setMaLop(rs.getString("MaLop"));
                dc.setMaDc(rs.getString("MaDc"));
                dc.setSoluong(rs.getInt("SLMuon"));
                dc.setNgayMuon(rs.getString("NgayMuon"));  
                Main_Model.DanhSachMuonDC.add(dc);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách mượn dụng cụ");
            return;
        }
    }
}
