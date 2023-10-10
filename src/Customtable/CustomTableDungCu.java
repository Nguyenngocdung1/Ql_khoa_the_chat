/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;

import Model.DungCu;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ngoc Dung
 */
public class CustomTableDungCu extends AbstractTableModel {
     //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Dụng Cụ","Tên Dụng Cụ","Số lượng","Tình Trạng"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,int.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<DungCu> dsDungCu =new ArrayList<DungCu>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTableDungCu(ArrayList<DungCu> list)
   {
       this.dsDungCu=list;
   }
    
    @Override
    public int getRowCount()
    {
        return dsDungCu.size();
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
            
            case 0: return dsDungCu.get(rowIndex).getMaDc();
            
            case 1: return dsDungCu.get(rowIndex).getTenDc();
            
            case 2: return dsDungCu.get(rowIndex).getSoLuong();
            
            case 3: return dsDungCu.get(rowIndex).getTinhTrang();
            
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
