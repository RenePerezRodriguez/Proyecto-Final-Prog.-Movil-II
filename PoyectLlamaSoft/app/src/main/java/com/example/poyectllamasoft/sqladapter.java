package com.example.poyectllamasoft;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class sqladapter extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "proyecto.db",NOMBRE_TABLA="";

    public sqladapter(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public sqladapter(Context context) {
        super(context,NOMBRE_BD,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,nombre text not null,mes integer not null,ano integer not null);",NOMBRE_TABLA));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
