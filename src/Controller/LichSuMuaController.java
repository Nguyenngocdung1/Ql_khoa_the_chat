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
import javax.swing.JOptionPane;

public class LichSuMuaController {
    ConnectDB cn = new ConnectDB();
    public void getLSM(){
        Main_Model.LichSuMua.clear();
        Main_Model.DanhSachDongPhuc.clear();
        String sql ="Select LICHSUMUA.MaDP,TenDP,DONGPHUC.Size,SoLuong "
                + "FROM DONGPHUC, LICHSUMUA"
                + " WHERE DONGPHUC.MADP=LICHSUMUA.MADP AND MASV = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,Main_Model.user.getID());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LichSuaMua ls = new LichSuaMua();
                DongPhuc dp= new DongPhuc();
                ls.setMaDp(rs.getString("MADP"));
                dp.setTenDp(rs.getString("TENDP"));
                dp.setSize(rs.getString("SIZE"));
                ls.setSoLuong(rs.getInt("SOLUONG"));
                Main_Model.LichSuMua.add(ls);
                Main_Model.DanhSachDongPhuc.add(dp);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được kết quả");
            System.out.println(e);
            return;
        }
    }
     public void xoaLSM(String ID){
        String sql ="DELETE FROM LICHSUMUA WHERE MADP=?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1,ID );
            ps.execute();
            JOptionPane.showMessageDialog(null, "Xoá thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
            System.out.println(e);
        }
        this.getLSM();
    }
}
