/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;


import Model.KetQua;
import Model.LopHoc;
import Model.Main_Model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author tiend
 */
public class KetQuaCustomTable extends AbstractTableModel{
     //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Lớp","Tên Lớp ","Mã SV","Điểm Tx1","Điểm Tx2","Tiết Nghỉ","Điều Kiện Thi","Điểm Thi","Điểm TB","Xếp Loại"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,float.class,float.class,int.class,String.class,float.class,float.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<KetQua> dsKetQua=new ArrayList<KetQua>();
    ArrayList<LopHoc> dsLopHoc= new ArrayList<LopHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public KetQuaCustomTable(ArrayList<KetQua> list1,ArrayList<LopHoc> list2)
   {
       this.dsKetQua=list1;
       this.dsLopHoc=list2;
   }


    @Override
    public int getRowCount() {
        return dsKetQua.size();
    }
    

    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        try{
           switch(columnIndex)
            {

                case 0: return dsLopHoc.get(rowIndex).getMaLop();

                case 1: return dsLopHoc.get(rowIndex).getTenLop();
                
                case 2: return dsKetQua.get(rowIndex).getMaSV();

                case 3: return dsKetQua.get(rowIndex).getDiemTX1();

                case 4: return dsKetQua.get(rowIndex).getDiemTX2();

                case 5: return dsKetQua.get(rowIndex).getTietNghi();

                case 6: return dsKetQua.get(rowIndex).getDieuKien();

                case 7: return dsKetQua.get(rowIndex).getDiemThi();

                case 8: return dsKetQua.get(rowIndex).diemTB();

                case 9: return dsKetQua.get(rowIndex).xepLoai();    

                default :return null;
            } 
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    } 
    
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }


    
}
