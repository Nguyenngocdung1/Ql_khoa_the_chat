/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;

import Model.LopHoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ngoc Dung
 */
public class LopHocCustomTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Lớp","Ma Giảng Viên","Tên Lớp","Ngày Bắt Đầu","Tiết Học","Tổng Tiết","Học Phí"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,int.class,int.class,double.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<LopHoc> dsThiSinh=new ArrayList<LopHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public LopHocCustomTable(ArrayList<LopHoc> list)
   {
       this.dsThiSinh=list;
   }
    
    @Override
    public int getRowCount()
    {
        return dsThiSinh.size();
    }
    
    @Override
    public int getColumnCount()
    {
        return name.length;
    }
    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex,int columnIndex)
    {
        switch(columnIndex)
        {
            
            case 0: return dsThiSinh.get(rowIndex).getMaLop();
            
            case 1: return dsThiSinh.get(rowIndex).getMaGv();
            
            case 2: return dsThiSinh.get(rowIndex).getTenLop();
            
            case 3: return dsThiSinh.get(rowIndex).getNgayBatDau();
            
            case 4: return dsThiSinh.get(rowIndex).getTietHoc();
            
            case 5: return dsThiSinh.get(rowIndex).getTongTiet();
            
            case 6: return dsThiSinh.get(rowIndex).getHocPhi();
            default :return null;
        }
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
