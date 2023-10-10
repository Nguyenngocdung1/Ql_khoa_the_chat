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
public class InsertData {
    ConnectDB conn = new ConnectDB();
     public void Insert_TableGV() {
        String sql =    "INSERT INTO GIANGVIEN VALUES ('GV01', 'Nguyễn Văn A', 'Nam', '0985813746', 'Cầu lông')\n" ;
        String sql1 =   "INSERT INTO GIANGVIEN VALUES ('GV02', 'Nguyễn Văn B', 'Nam', '0985813747', 'Bóng đá')\n" ;
        String sql2 =   "INSERT INTO GIANGVIEN VALUES ('GV03', 'Nguyễn Văn C' , 'Nam', '0985813748', 'Bóng chuyền')\n" ;
        String sql3 =   "INSERT INTO GIANGVIEN VALUES ('GV04', 'Nguyễn Thị D', 'Nữ', '0985813749', 'Bóng rổ')";
   
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
    }
    
     public void Insert_TableSV() {
        String sql1 =    "INSERT INTO SINHVIEN VALUES ('SV01', 'Nguyễn Tiến Huy', 'Nam', '0123455678', 'CNTT')\n" ;
        String sql2 =    "INSERT INTO SINHVIEN VALUES ('SV02', 'Bùi Hữu Dũng', 'Nam',  '03874266545', 'CNTT')\n" ;
        String sql3 =    "INSERT INTO SINHVIEN VALUES ('SV03', 'Nguyễn Đức Hùng', 'Nam', '0347382465', 'COKI')\n" ;
        String sql  =    "INSERT INTO SINHVIEN VALUES ('SV04', 'Nguyễn Ngọc Dũng', 'Nam', '0828531788', 'CNTT')\n";
        String sql4 =    "INSERT INTO SINHVIEN VALUES ('SV05', 'Phùng Thế Thái', 'Nam',  '0456457657', 'OTO')";
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
        conn.doSQL(sql4);
    }
    
    public void Insert_TableLOPHOC() {
        String sql =    "INSERT INTO LOPHOC VALUES ('L001', 'GV04', 'Bóng rổ 1', '2021-05-01', 4 , 1, 600000)\n";
        String sql1 =    "INSERT INTO LOPHOC VALUES ('L002', 'GV03', 'Bóng chuyền 2', '01/05/2021', 4 , 1, 600000)\n" ;
        String sql2 =    "INSERT INTO LOPHOC VALUES ('L003', 'GV02', 'Bóng đá 3', '01/05/2021', 4 , 1, 600000)\n" ;
        String sql3 =    "INSERT INTO LOPHOC VALUES ('L004', 'GV01', 'Cầu lông 2', '01/05/2021', 4 , 1, 600000)\n" ;
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
    }

    
    public void Insert_TableDC() {
        String sql =    "INSERT INTO DUNGCU VALUES ('DC01', 'Bóng hơi', 20, 'Tốt')\n";
        String sql1 =    "INSERT INTO DUNGCU VALUES ('DC02', 'Vợt cầu lông', 120, 'Tốt')\n" ;
        String sql2 =    "INSERT INTO DUNGCU VALUES ('DC03', 'Bóng chuyền', 10, 'Tốt')\n" ;
        String sql3 =    "INSERT INTO DUNGCU VALUES ('DC04', 'Quả cầu lông', 90, 'Tốt')\n" ;
        String sql4 =    "INSERT INTO DUNGCU VALUES ('DC05', 'Vợt bóng bàn', 30, 'Tốt')\n" ;
        String sql5 =    "INSERT INTO DUNGCU VALUES ('DC06', 'Cầu mây', 20, 'Tốt')\n" ;
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
        conn.doSQL(sql4);
        conn.doSQL(sql5);
    }
    
     public void Insert_TableDP() {
        String sql =    "INSERT INTO DONGPHUC VALUES ('DP01', 'Bộ thể chất', 3000, 'M', 200000)";
        String sql1 =    "INSERT INTO DONGPHUC VALUES ('DP02', 'Bộ thể chất', 3000, 'L', 200000)\n" ;
        String sql2 =    "INSERT INTO DONGPHUC VALUES ('DP03', 'Bộ thể chất', 3000, 'XL', 200000)\n" ;
        String sql3 =    "INSERT INTO DONGPHUC VALUES ('DP04', 'Bộ thể thao', 1000, 'M', 150000)\n" ;
        String sql4 =    "INSERT INTO DONGPHUC VALUES ('DP05', 'Bộ thể thao', 1000, 'L', 150000)\n" ;
        String sql5 =    "INSERT INTO DONGPHUC VALUES ('DP06', 'Bộ thể thao', 1000, 'XL', 150000)\n";
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
        conn.doSQL(sql4);
        conn.doSQL(sql5);
    }
     
     public void Insert_TableKQ(){
        String sql ="INSERT INTO KETQUA VALUES ('L001','SV01',6.5,8,8,9)";
        String sql1 ="INSERT INTO KETQUA VALUES ('L002','SV02',6.5,8,8,9)\n";
        String sql3 ="INSERT INTO KETQUA VALUES ('L003','SV02',6.5,8,8,9)\n";
        String sql4 ="INSERT INTO KETQUA VALUES ('L004','SV04',6.5,8,8,9)\n";
        String sql6 ="INSERT INTO KETQUA VALUES ('L001','SV03',6.5,8,8,9)\n";
        String sql8 ="INSERT INTO KETQUA VALUES ('L004','SV03',6.5,8,8,9)\n";
        conn.doSQL(sql);
        conn.doSQL(sql1);
//        conn.doSQL(sql2);
        conn.doSQL(sql3);
        conn.doSQL(sql4);
        conn.doSQL(sql6);
//        conn.doSQL(sql7);
        conn.doSQL(sql8);
    }

    public void Insert_TableTK() {
        String sql = "INSERT INTO TAIKHOAN VALUES ('SV01', '1' , 'Sinh viên')\n" ;
        String sql1 = "INSERT INTO TAIKHOAN VALUES ('SV02', '1' , 'Sinh viên')\n" ;
        String sql2 = "INSERT INTO TAIKHOAN VALUES ('SV03', '1' , 'Sinh viên')\n" ;
        String sql3 = "INSERT INTO TAIKHOAN VALUES ('SV04', '1' , 'Sinh viên')\n" ;
        String sql4 = "INSERT INTO TAIKHOAN VALUES ('SV05', '1' , 'Sinh viên')\n" ;
        String sql5 = "INSERT INTO TAIKHOAN VALUES ('GV01', '1' , 'Giảng viên')\n" ;
        String sql6 = "INSERT INTO TAIKHOAN VALUES ('GV02', '1' , 'Giảng viên')\n" ;
        String sql7 = "INSERT INTO TAIKHOAN VALUES ('GV03', '1' , 'Giảng viên')\n" ;
        String sql8 = "INSERT INTO TAIKHOAN VALUES ('GV04', '1' , 'Giảng viên')\n" ;
        String sql10 = "INSERT INTO TAIKHOAN VALUES ('QL01', '1' , 'Người quản lý')";
        conn.doSQL(sql);
        conn.doSQL(sql1);
        conn.doSQL(sql2);
        conn.doSQL(sql3);
        conn.doSQL(sql4);
        conn.doSQL(sql5);
        conn.doSQL(sql6);
        conn.doSQL(sql7);
        conn.doSQL(sql8);
        conn.doSQL(sql10);
    }
}
