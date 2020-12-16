package com.example.poyectllamasoft;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqladapter extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "proyecto.db",NOMBRE_TABLA="",NOMBRE_TABLA_FACTURA="factura",NOMBRE_TABLA_FACTURA_QR="facturaqr";
    public static String getNombreTablaFactura() {
        return NOMBRE_TABLA_FACTURA;}

    public static String getNombreTablaFacturaQr() {
        return NOMBRE_TABLA_FACTURA_QR;}

    public sqladapter(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public sqladapter(Context context) {
        super(context,NOMBRE_BD,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,nombre text not null,mes integer not null,ano integer not null);",NOMBRE_TABLA));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(facturaId INTEGER PRIMARY KEY AUTOINCREMENT,NIT INTEGER NOT NULL, nroFactura INTEGER NOT NULL, codigoControl TEXT NOT NULL, nroAutorizacion INTEGER NOT NULL, fecha TEXT NOT NULL, importe REAL NOT NULL, formId INTEGER NOT NULL, estado DEFAULT 1);",NOMBRE_TABLA_FACTURA));
        db.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(facturaqrid INTEGER PRIMARY KEY AUTOINCREMENT,codigo TEXT NOT NULL);",NOMBRE_TABLA_FACTURA_QR));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
