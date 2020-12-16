package com.example.poyectllamasoft;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ControladorFormulario {
    public sqladapter adatador;

    public ControladorFormulario(Context context) {
        adatador = new sqladapter(context);
    }
    public void insertaFormulario(Formulario formulario) {
        SQLiteDatabase basededatos = adatador.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre",formulario.getNombre());
        values.put("mes",formulario.getMes());
        values.put("ano",formulario.getAno());
    }
}
