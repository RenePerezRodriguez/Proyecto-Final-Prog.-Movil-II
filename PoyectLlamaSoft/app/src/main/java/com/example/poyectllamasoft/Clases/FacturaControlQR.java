package com.example.poyectllamasoft.Clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.poyectllamasoft.sqladapter;

public class FacturaControlQR {
    private sqladapter connectionDB;

    public FacturaControlQR(Context context){
        connectionDB=new sqladapter(context);
    }

    public long newFac(FacturaModelQR facturaModelqr){
        SQLiteDatabase sqLiteDatabase = connectionDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("facturaqrid", facturaModelqr.getFacturaQRId());
        contentValues.put("codigo", facturaModelqr.getCodigo());


        return sqLiteDatabase.insert(connectionDB.getNombreTablaFacturaQr(),null,contentValues);
    }
}
