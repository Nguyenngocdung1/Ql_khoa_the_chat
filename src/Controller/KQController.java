
package Controller;
import Model.Main_Model;
import Database.ConnectDB;
import Model.KetQua;
import Model.LopHoc;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
public class KQController {
    ConnectDB cn = new ConnectDB();
    public void getKQ(){
        Main_Model.KetQua.clear();
        String sql ="Select KETQUA.MaLop,TenLop,MaSV,Diem1,Diem2,TietNghi,DiemThi,TongTiet "
                + " FROM KETQUA, LOPHOC "
                + " WHERE KETQUA.MALOP=LOPHOC.MALOP AND MASV = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, Main_Model.user.getID());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lop = new LopHoc();
                KetQua kq = new KetQua();    
                lop.setMaLop(rs.getString("MALOP"));
                lop.setTenLop(rs.getString("TenLop"));
                kq.setMaSV(rs.getString("MaSV"));
                kq.setDiemTX1(rs.getFloat("DIEM1"));
                kq.setDiemTX2(rs.getFloat("DIEM2"));
                kq.setTietNghi(rs.getInt("TIETNGHI"));
                kq.setDiemThi(rs.getFloat("diemThi"));
                kq.dieuKienThi(Integer.parseInt(rs.getString("TongTiet")),Integer.parseInt(rs.getString("TietNghi")));
                kq.diemTB();
                kq.xepLoai();
                Main_Model.DanhSachLH.add(lop);
                Main_Model.KetQua.add(kq);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được kết quả"+e);
            return;
        }

    }
    public void getKQGV(){
        Main_Model.KetQua.clear();
        Main_Model.DanhSachLH.clear();
        String sql ="Select KETQUA.MaLop,TenLop,MaSV,Diem1,Diem2,TietNghi,DiemThi,TongTiet "
                + " FROM KETQUA, LOPHOC "
                + " WHERE KETQUA.MALOP=LOPHOC.MALOP AND MaGv = ?";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setString(1, Main_Model.user.getID());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LopHoc lop = new LopHoc();
                KetQua kq = new KetQua();    
                lop.setMaLop(rs.getString("MALOP"));
                lop.setTenLop(rs.getString("TenLop"));
                kq.setMaSV(rs.getString("MaSV"));
                kq.setDiemTX1(rs.getFloat("DIEM1"));
                kq.setDiemTX2(rs.getFloat("DIEM2"));
                kq.setTietNghi(rs.getInt("TIETNGHI"));
                kq.setDiemThi(rs.getFloat("diemThi"));
                kq.dieuKienThi(Integer.parseInt(rs.getString("TongTiet")),Integer.parseInt(rs.getString("TietNghi")));
                kq.diemTB();
                kq.xepLoai();
                Main_Model.DanhSachLH.add(lop);
                Main_Model.KetQua.add(kq);
            }
        } catch (Exception e) {
            System.out.println("Lỗi. Không lấy được kết quả"+e);
            return;
        }
    }
    public void suaLH(String malop, String masv,float Diem1,float diem2,float diemthi){
        String sql ="UPDATE KETQUA SET Diem1=?,Diem2=?,DiemThi=?  WHERE MaSV=? AND MaLop= ? ";
        try {
            PreparedStatement ps = cn.conn.prepareStatement(sql);
            ps.setFloat(1,Diem1);
            ps.setFloat(2,diem2);
            ps.setFloat(3,diemthi);
            ps.setString(4,masv);
            ps.setString(5,malop);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Sửa thành công");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
            System.out.println(e);
        }
        this.getKQGV();
    }
    //    public void themKQ(String maLop, String tenLop, float diemTX1, float diemTX2,int tietNghi ,String dieuKien, float diemThi){
//        KetQua kq =new KetQua();
//        LopHoc lop = new LopHoc();
//////                lop.set
//////                KetQua kq = new KetQua();
//////             nhu tren;
//////        kq.DieuKienThi(Integer.parseInt(rs.getString("tongtiet")), tietNghi);
//        String sql ="insert into KETQUA VALUES(?,?,?,?,?,?,?,?)";
//        try {
//            PreparedStatement ps = cn.conn.prepareStatement(sql);
//            ps.setString(1,lop.getMaLop().toString());
//            ps.setString(2,lop.getTenLop().toString());
//            ps.setFloat(3,diemTX1);
//            ps.setFloat(4,diemTX2);
//            ps.setFloat(7,diemThi);
//            ps.setInt(5, tietNghi);
//            ps.setString(6,dieuKien);
//            ps.setString(8,kq.xepLoai());
////            ps.setFloat(6,kq.DieuKienThi(lop.tongTiet,tietNghi);
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Thêm thành công");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi. Thêm thất bại");
//            System.out.println(e);
//        }
//        this.getKQ();
//    }
//    
//    public void xoaSV(String id){
//        String sql ="DELETE FROM SINHVIEN WHERE MaSV=?";
//        try {
//            PreparedStatement ps = cn.conn.prepareStatement(sql);
//            ps.setString(1, id);
//            ps.execute();
//            JOptionPane.showMessageDialog(null, "Xoá thành công");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi. Xoá thất bại");
//            System.out.println(e);
//        }
//        this.getSV();
//    }
//    
//    public void suaSV(String ma,String ten,String gt, String sdt, String makhoa ){
//        String sql ="UPDATE SINHVIEN SET TenSV = ?,  GioiTinh = ?,  SDT = ?,  MaKhoa =?  WHERE MaSV=? ";
//        try {
//            PreparedStatement ps = cn.conn.prepareStatement(sql);
//            ps.setString(1,ten);
//            ps.setString(2,gt);
//            ps.setString(3,sdt);
//            ps.setString(4,makhoa);
//            ps.setString(5,ma);
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Sửa thành công");
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Lỗi. Sửa thất bại");
//            System.out.println(e);
//        }
//        this.getSV();
//    }
}

