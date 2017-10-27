package com.example.unitec.sqlitte.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.unitec.sqlitte.DTO.NhanVienDTO;
import com.example.unitec.sqlitte.SQLiteHelper.TaoDataBase;

/**
 * Created by Unitec on 26/10/2017.
 * Lop nay dung de ket noi database
 */

public class NhanVienDAO {
    SQLiteDatabase database;
    TaoDataBase taoDataBase;
    public NhanVienDAO(Context context){
        taoDataBase = new TaoDataBase(context);
    }

    public void open(){
        database = taoDataBase.getWritableDatabase();
    }

    public void close(){
        taoDataBase.close();
    }
    public boolean themNhanVien(NhanVienDTO nv){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TaoDataBase.TEN_NHANVIEN,nv.getTenNhanvien().toString());
        long id = database.insert(TaoDataBase.TABLE_NHANVIEN,null,contentValues);
        if(id != 0){
            return true;
        }
        else{
            return false;
        }
    }

}
