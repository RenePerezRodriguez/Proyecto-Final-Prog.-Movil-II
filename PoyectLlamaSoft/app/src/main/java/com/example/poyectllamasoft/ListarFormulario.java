package com.example.poyectllamasoft;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ListarFormulario extends Fragment {

    private RecyclerView rvListaForms;
    private ArrayList<Formulario> listaForms;
    private Listar listar;
    private int mes;
    private int anio;
    private int  formId;

    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_listar_formulario ,container,false);
        rvListaForms = view.findViewById(R.id.rvListaForms);

        rvListaForms.setLayoutManager(new GridLayoutManager(getContext(),1));
        cargarRecyclerView();
        return view;
    }
    private void DBlista() {


        sqladapter connectionDB = new sqladapter(getContext());
        SQLiteDatabase sqLiteDatabase= connectionDB.getReadableDatabase();


        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM formulario WHERE estado = 1",null);

        if(cursor.moveToNext()){
            do{
                Formulario formularioCrear = new Formulario(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)

                );
                listaForms.add(formularioCrear);
            }while(cursor.moveToNext());
        }
    }

    private void cargarRecyclerView(){
        listaForms = new ArrayList<Formulario>();
        DBlista();
        listar =  new Listar(listaForms);
        listar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                formId = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getId();
                mes = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getMes();
                anio = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getAno();
                return false;
            }
        });

        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Intent intent = new Intent(getContext(), FormularioActivity.class);
                int idForm = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getId();
                String nombre = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getNombre();
                int mes = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getMes();
                int anio = listaForms.get(rvListaForms.getChildAdapterPosition(v)).getAno();

                bundle.putInt("formId", idForm);
                bundle.putString("nombre",nombre);
                bundle.putString("mes", String.valueOf(mes));
                bundle.putString("anio", String.valueOf(anio));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        rvListaForms.setAdapter(listar);
    }


}