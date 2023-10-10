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
 * @author tiend
 */
public class DKLCustomTable extends AbstractTableModel {
     //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Lớp","Ma Giáo Viên","Tên Lớp","Ngày Bắt Đầu","Tiết Học","Tổng Tiết","Học Phí"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,int.class,int.class,double.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<LopHoc> dsLop=new ArrayList<LopHoc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public DKLCustomTable(ArrayList<LopHoc> list)
   {
       this.dsLop=list;
   }
    
    @Override
    public int getRowCount()
    {
        return dsLop.size();
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
            
            case 0: return dsLop.get(rowIndex).getMaLop();
            
            case 1: return dsLop.get(rowIndex).getMaGv();
            
            case 2: return dsLop.get(rowIndex).getTenLop();
            
            case 3: return dsLop.get(rowIndex).getNgayBatDau();
            
            case 4: return dsLop.get(rowIndex).getTietHoc();
            
            case 5: return dsLop.get(rowIndex).getTongTiet();
            
            case 6: return dsLop.get(rowIndex).getHocPhi();
                
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
