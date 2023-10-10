/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Customtable;

import Model.KetQua;
import Model.LopHoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MR TIT
 */
public class DKLopCustomTable extends AbstractTableModel {
     private String name[]={"Mã Lớp ","Tên Lớp","Ngày bắt đầu","Điểm 1","Điểm 2","Số tiết nghỉ","Điểm Thi"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,float.class,float.class,int.class,float.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<KetQua>Kq= new ArrayList<>();
    ArrayList<LopHoc> dsLH=new ArrayList<>();
     public DKLopCustomTable(ArrayList<KetQua> list1,ArrayList<LopHoc> list2)
    {
        this.Kq=list1;
        this.dsLH=list2;
    }
    
    @Override
    public int getRowCount()
    {
        return Kq.size();
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
            
            case 0: return Kq.get(rowIndex).getMaLop();
            
            case 1: return dsLH.get(rowIndex).getTenLop();
                
            case 2: return dsLH.get(rowIndex).getNgayBatDau();
            
            case 3: return Kq.get(rowIndex).getDiemTX1();
            case 4: return Kq.get(rowIndex).getDiemTX2();
            case 6: return Kq.get(rowIndex).getDiemThi();
            case 5: return Kq.get(rowIndex).getTietNghi();
            default :return null;
        }
        }
        catch (Exception e){
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
    

