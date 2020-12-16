package com.example.poyectllamasoft;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.poyectllamasoft.Clases.FacturaModel;
import com.example.poyectllamasoft.Clases.ListarFactura;

import java.util.ArrayList;


public class ListaFacturasFragment extends Fragment {

    private RecyclerView rvListaFactura;
    private View view;
    private ListarFactura adapter;
    private int id;
    private ArrayList<FacturaModel> listaFactura;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_lista_facturas, container,false);
        id = getArguments().getInt("formId");
        String nombre = getArguments().getString("nombre");
        String mes = getArguments().getString("mes");
        String anio = getArguments().getString("anio");

        rvListaFactura = view.findViewById(R.id.rvListaFac);
        rvListaFactura.setLayoutManager(new GridLayoutManager(getContext(),1));
        cargarRecyclerView();

        return view;
    }
    private void cargarListaBDD(){
        listaFactura.clear();

        sqladapter connectionDB = new sqladapter(getContext());
        SQLiteDatabase sqLiteDatabase= connectionDB.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT facturaId, nroFactura, fecha, importe FROM factura WHERE estado = 1 AND formId ="+ id,null);

        if(cursor.moveToNext()){
            do{
                FacturaModel facturaModel = new FacturaModel(
                        cursor.getInt(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getInt(3)
                );
                listaFactura.add(facturaModel);
            }while(cursor.moveToNext());
        }

    }

    private void cargarRecyclerView(){
        listaFactura = new ArrayList<FacturaModel>();
        cargarListaBDD();
        adapter = new ListarFactura(listaFactura);
        rvListaFactura.setAdapter(adapter);

    }

}