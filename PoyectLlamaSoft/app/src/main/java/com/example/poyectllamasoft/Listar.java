package com.example.poyectllamasoft;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class Listar extends RecyclerView.Adapter<Listar.ViewHolderDatos> implements View.OnClickListener, View.OnLongClickListener{

    ArrayList<Formulario> listaForm;
    private View.OnClickListener listener;
    private View.OnLongClickListener longListener;

    public Listar(ArrayList<Formulario> listaForm){
        this.listaForm = listaForm;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listar,null,false);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.Datos(listaForm.get(position));
    }

    @Override
    public int getItemCount() {
        return listaForm.size();
    }

    @Override
    public void onClick(View view) {
        if (listener !=null){
            listener.onClick(view);
        }

    }

    @Override
    public boolean onLongClick(View view) {
        if (longListener != null){
            longListener.onLongClick(view);
        }
        return false;
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder implements  View.OnCreateContextMenuListener{
        TextView tvMes, tvAnio, tvFormId;
        LinearLayout linearLayout;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            tvFormId = itemView.findViewById(R.id.tvFormId);
            tvMes = itemView.findViewById(R.id.tvMes);
            tvAnio = itemView.findViewById(R.id.tvAnio);
            linearLayout = itemView.findViewById(R.id.lyItems);
            linearLayout.setOnCreateContextMenuListener(this);
        }

        public void Datos(Formulario formulario) {
            tvFormId.setText(String.valueOf(formulario.getId()));
            tvMes.setText("Año: " + formulario.getMes());
            tvAnio.setText("Mes: " + formulario.getAno());
        }



        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    public void setOnLongClickListener(View.OnLongClickListener longListener) {this.longListener = longListener;}




}