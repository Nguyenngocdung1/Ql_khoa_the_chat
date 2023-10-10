/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.ConnectDB;
import Model.DongPhuc;
import Model.LichSuaMua;
import Model.Main_Model;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

public class DangKyDPController {
     ConnectDB cn = new ConnectDB();

         public void getDP() {
        Main_Model.DanhSachDongPhuc.clear();
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
                Main_Model.DanhSachDongPhuc.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được danh sách lớp học");
            return;
        }
        Collections.sort(Main_Model.DanhSachDongPhuc, new Comparator<DongPhuc>() {
            @Override
            public int compare(DongPhuc o1, DongPhuc o2) {
                return o1.getTenDp().compareToIgnoreCase(o2.getTenDp());
            }
        });
    }

    public  void themLSM(String maDp,String maSV,int soLuong){
//        LichSuaMua ls = new LichSuaMua( maDp,maSV, soLuong);
        String sql="insert into LICHSUMUA VALUES(?,?,?,?)";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,maDp);
            ps.setString(2,Main_Model.user.getID());
//            ps.setString(2,"SV04");
            ps.setInt(3,soLuong);
            ps.setString(4,"2021-05-01");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Thêm thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
            System.out.println(e);
        }

    }
//    public void getDP(){
//        Main_Model.DanhSachDongPhuc.clear();
//        String sql="Select *from DONGPHUC";
//        try {
//            PreparedStatement ps = cn.conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                DongPhuc dp= new DongPhuc();
//                dp.setMaDp(rs.getString("MADP"));
//                dp.setTenDp(rs.getString("TENDP"));
//                dp.setSoLuong(rs.getInt("SOLUONG"));
//                 dp.setSize(rs.getString("SIZE"));
//                dp.setGia(rs.getDouble("GIA"));
//                Main_Model.DanhSachDongPhuc.add(dp);
//            }
//        } catch (Exception e) {
//            System.out.println("Lỗi. Không lấy được kết quả"+e);
//            return;
//        }
//    }
}


