/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

/**
 *
 * @author DungxBuif
 */
public class CreateTable {
    ConnectDB conn = new ConnectDB();

    public void Create_TableGV() {
        String sql =    "CREATE TABLE GIANGVIEN(" +
                        "MaGV CHAR(4) PRIMARY KEY," +
                        "TenGV VARCHAR(20) NOT NULL," +
                        "GioiTinh VARCHAR(3) NOT NULL," +
                        "SDT VARCHAR(15) NOT NULL," +
                        "MonDay VARCHAR(20) NOT NULL)";
        conn.doSQL(sql);
    }
    
    public void Create_TableSV() {
        String sql =    "CREATE TABLE SINHVIEN(MaSV CHAR(4) PRIMARY KEY,"+
                        "TenSV VARCHAR(20) NOT NULL," +
                        "GioiTinh VARCHAR(3) NOT NULL,"+
                        "SDT VARCHAR(15) NOT NULL," +
                        "MaKhoa CHAR(4) NOT NULL)";
        conn.doSQL(sql);
    }
    
    public void Create_TableLOPHOC() {
        String sql =    "CREATE TABLE LOPHOC(" +
                        "MaLop CHAR(4) PRIMARY KEY," +
                        "MaGV CHAR(4) NOT NULL," +
                        "TenLop VARCHAR(20) NOT NULL," +
                        "NgayBatDau DATE NOT NULL," +
                        "TietHoc integer NOT NULL," +
                        "TongTiet integer NOT NULL," +
                        "HocPhi double NOT NULL," +
                        "CONSTRAINT fk_MaGV " +
                        "FOREIGN KEY (MaGV)" +
                        "REFERENCES GIANGVIEN(MaGV))";
        conn.doSQL(sql);
    }
    
    public void Create_TableDC() {
        String sql =    "CREATE TABLE DUNGCU(" +
                        "MaDC CHAR(4) PRIMARY KEY," +
                        "TenDC VARCHAR(20) NOT NULL," +
                        "TongSl integer NOT NULL," +
                        "TinhTrang VARCHAR(20) NOT NULL)";
        conn.doSQL(sql);
    }
    
     public void Create_TableDP() {
        String sql =    "CREATE TABLE DONGPHUC (MaDP CHAR(4) PRIMARY KEY," +
                        "TenDP VARCHAR(20) NOT NULL,SL integer NOT NULL," +
                        "SIZE VARCHAR(3) NOT NULL,Gia double NOT NULL)";
        conn.doSQL(sql);
    }
     
     public void Create_TableKQ() {
        String sql =    "CREATE TABLE KETQUA(" +
                        "MaLop CHAR(4) NOT NULL," +
                        "MaSV CHAR(4) NOT NULL," +
                        "Diem1 Float ," +
                        "Diem2 Float ," +
                        "DiemThi Float," +
                        "TietNghi integer," +
                        "CONSTRAINT pk_KetQua PRIMARY KEY (MaLop, MaSV)," +
                        "CONSTRAINT fk_MaLop " +
                        "FOREIGN KEY (MaLop)" +
                        "REFERENCES LOPHOC(MaLop)," +
                        "CONSTRAINT fk_MaSV " +
                        "FOREIGN KEY (MaSV)" +
                        "REFERENCES SINHVIEN(MaSV))";
        conn.doSQL(sql);
    }

      
    public void Create_TableMuonDC() {
        String sql =    "CREATE TABLE MUONDC(\n" +
                        "maMDC CHAR(4) PRIMARY KEY,\n" +
                        "MaLop CHAR(4) NOT NULL,\n" +
                        "MaDC CHAR(4) NOT NULL,\n" +
                        "SLMuon integer NOT NULL,\n" +
                        "NgayMuon DATE NOT NULL,\n" +
                        "CONSTRAINT fk_lop_mdc \n" +
                        "FOREIGN KEY (MaLop)\n" +
                        "REFERENCES LOPHOC(MaLop),\n" +
                        "CONSTRAINT fk_MaDC \n" +
                        "FOREIGN KEY (MaDC)\n" +
                        "REFERENCES DUNGCU(MaDC))";
        conn.doSQL(sql);
    }
     
      public void Create_TableLSM() {
        String sql =    "CREATE TABLE LICHSUMUA(MaDP CHAR(4) NOT NULL," +
                        "MaSV CHAR(4) NOT NULL,SoLuong integer NOT NULL," +
                        "ThoiGian DATE NOT NULL,CONSTRAINT pk_LichSuMua PRIMARY KEY (MaDP, MaSV)," +
                        "CONSTRAINT fk_MaSVLSMua FOREIGN KEY (MaSV)" +
                        "REFERENCES SINHVIEN(MaSV),CONSTRAINT fk_MaDP " +
                        "FOREIGN KEY (MaDP)REFERENCES DONGPHUC(MaDP))";
        conn.doSQL(sql);
    }
      
    public void Create_TableTK() {
        String sql =    "CREATE TABLE TAIKHOAN(" +
                        "ID CHAR(4) PRIMARY KEY,\n" +
                        "MK VARCHAR(50) NOT NULL,\n" +
                        "LoaiTK VARCHAR(15) NOT NULL\n" +
                        ")";
        conn.doSQL(sql);
    }
}
