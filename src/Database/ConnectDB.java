/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ConnectDB {

    Statement stm = null;
    ResultSet rs = null;
    public Connection conn = null;

    String uRl = "jdbc:derby://localhost:1527/QLKhoaTheChat_N4_HAUI";
    String userName = "N4";
    String pas = "1";

    public ConnectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(uRl, userName, pas);
            System.out.println("ket noi thanh cong");
        } catch (Exception ex) {
            System.out.println("ket noi that bai" + ex.toString());
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại");
        }
    }
    
    public void doSQL(String sql) {
        try {
            stm = conn.createStatement();
            stm.execute(sql);
            System.out.println("Thực thi thành công");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println(" khong thuc hien dc cau lẹnh sql\n" + sql);
        }
    } 
}
