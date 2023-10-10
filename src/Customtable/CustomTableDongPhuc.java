/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;

import Model.DongPhuc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ngoc Dung
 */
public class CustomTableDongPhuc extends AbstractTableModel {
     //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã Đồng Phục","Tên Đồng Phục","Size","Số lượng", "Giá"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,int.class, double.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<DongPhuc> dsDongPhuc =new ArrayList<DongPhuc>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomTableDongPhuc(ArrayList<DongPhuc> list)
   {
       this.dsDongPhuc=list;
   }
    
    @Override
    public int getRowCount()
    {
        return dsDongPhuc.size();
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
            
            case 0: return dsDongPhuc.get(rowIndex).getMaDp();
            
            case 1: return dsDongPhuc.get(rowIndex).getTenDp();
            
            case 2: return dsDongPhuc.get(rowIndex).getSize();
            
            case 3: return dsDongPhuc.get(rowIndex).getSoLuong();
            
            case 4: return dsDongPhuc.get(rowIndex).getGia();
            
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
