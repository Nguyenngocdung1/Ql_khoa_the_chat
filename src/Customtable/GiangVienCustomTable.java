package Customtable;

import Model.GiangVien;
import Model.SinhVien;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class GiangVienCustomTable extends AbstractTableModel
{
    //Khai báo xâu chứa tiêu đề của bảng.
    private String name[]={"Mã giảng viên","Tên giảng viên","Giới tính","Số Điện Thoại","Môn dạy"};
    //Khai báo lớp Chứa kiểu dữ liệu của từng trường tương ứng.
    private Class classes[]={String.class,String.class,String.class,String.class,String.class};
    //Tạo một đối tượng arrayList có tên listThiSinh.
    ArrayList<GiangVien> dsThiSinh=new ArrayList<GiangVien>();

    //phương thức khởi tạo cho class có tham số truyền vào.
    public GiangVienCustomTable(ArrayList<GiangVien> list)
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
            
            case 0: return dsThiSinh.get(rowIndex).getMa();
            
            case 1: return dsThiSinh.get(rowIndex).getTen();
            
            case 2: return dsThiSinh.get(rowIndex).getGioiTinh();
            
            case 3: return dsThiSinh.get(rowIndex).getSdt();
            
            case 4: return dsThiSinh.get(rowIndex).getMonDay();
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
