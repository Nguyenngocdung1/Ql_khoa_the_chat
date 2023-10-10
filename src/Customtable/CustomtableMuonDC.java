/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;

import Model.MuonDC;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ngoc Dung
 */
public class CustomtableMuonDC extends AbstractTableModel{
     private String name[]={"Mã Mượn Dụng Cụ","Mã Lớp","Mã Dụng Cụ","Số lượng","Ngày Mượn"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={int.class,String.class,String.class,int.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<MuonDC> dsDungCu =new ArrayList<MuonDC>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public CustomtableMuonDC(ArrayList<MuonDC> list)
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
            
            case 0: return dsDungCu.get(rowIndex).getId();
            
            case 1: return dsDungCu.get(rowIndex).getMaLop();
            
            case 2: return dsDungCu.get(rowIndex).getMaDc();
            
            case 3: return dsDungCu.get(rowIndex).getSoluong();
            
            case 4: return dsDungCu.get(rowIndex).getNgayMuon();
            
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
