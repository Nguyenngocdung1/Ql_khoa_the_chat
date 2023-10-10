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
public class DB_Main {

    /**
     * @param args the command line arguments
     */
    static CreateTable cr = new CreateTable();
    static InsertData ins = new InsertData();
    public static void main(String[] args) {
        try{
            cr.Create_TableGV();
            cr.Create_TableSV();
            cr.Create_TableLOPHOC();
            cr.Create_TableDC();
            cr.Create_TableDP();
            cr.Create_TableKQ();
            cr.Create_TableMuonDC();
            cr.Create_TableLSM();
            cr.Create_TableTK();
            ins.Insert_TableSV();
            ins.Insert_TableGV();
            ins.Insert_TableTK();
            ins.Insert_TableLOPHOC();
            ins.Insert_TableDP();
            ins.Insert_TableDC();
            ins.Insert_TableKQ();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
