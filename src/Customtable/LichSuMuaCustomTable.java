
package Customtable;

import Model.DongPhuc;
import Model.LichSuaMua;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LichSuMuaCustomTable extends AbstractTableModel {
     private String name[]={"Mã Đồng phục ","Tên Đồng Phục","Kích cỡ","Số Lượng"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,int.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<LichSuaMua>LichSuaMua= new ArrayList<>();
    ArrayList<DongPhuc> dsDP=new ArrayList<>();
     public LichSuMuaCustomTable(ArrayList<LichSuaMua> list1,ArrayList<DongPhuc> list2)
    {
        this.LichSuaMua=list1;
        this.dsDP=list2;
    }
    
    @Override
    public int getRowCount()
    {
        return LichSuaMua.size()+dsDP.size();
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
            
            case 0: return LichSuaMua.get(rowIndex).getMaDp();
            
            case 1: return dsDP.get(rowIndex).getTenDp();
                
            case 2: return dsDP.get(rowIndex).getSize();
                
            case 3: return LichSuaMua.get(rowIndex).getSoLuong();
            
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
