/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import Database.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author ADMIN
 */
public class Dang_nhap_Controllers {

    ConnectDB cn = new ConnectDB();

    public void checkTK(String id, String mk) {
        Main_Model.user = null;
        try {
            String sql = "Select * from TAIKHOAN where ID=? and MK =?";
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                User u = new User();
                u.setID(rs.getString("ID"));
                u.setMK(rs.getString("Mk"));
                u.setLoai(rs.getString("LoaiTK"));
                Main_Model.user = u;
            }
        } catch (Exception e) {
            System.out.println("Không kiểm tra được tài khoản");
        }
    }
//    public void get_nhom() {
//        Main_Models.Nhom_Models.clear();
//        try {
//            String sql = "Select * from nhom";
//            PreparedStatement ps = n.conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                Nhom a = new Nhom();
//                a.setMa_nhom(rs.getString("manhom"));
//                a.setTen_nhom(rs.getString("tennhom"));
//                Main_Models.Nhom_Models.add(a);
//            }
//        } catch (Exception e) {
//        }
//    }
}
