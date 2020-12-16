package com.example.proyectollamasoft;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorFormulario extends  RecyclerView.Adapter<AdaptadorFormulario.ViewHolder> {
    private ArrayList<Formulario> listaformularios;

    public AdaptadorFormulario(ArrayList<Formulario> listaformulario) {
        this.listaformularios = listaformulario;
    }

    @NonNull
    @Override
    public AdaptadorFormulario.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_crear_form,null,false);
        return new AdaptadorFormulario.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorFormulario.ViewHolder holder, int position) {
        holder.asignarPropietario(listaformularios.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvid,tvnombre,tvmes,tvano;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //tvid = itemView.findViewById(R.id.);
            tvnombre = itemView.findViewById(R.id.txtnombre);
            tvmes = itemView.findViewById(R.id.txtmes);
            tvano = itemView.findViewById(R.id.txtano);
        }

        public void asignarPropietario(Formulario formulario) {
           /// tvid.setText("id: "+formulario.getId());
            tvnombre.setText("Modelo: "+formulario.getNombre());
            tvmes.setText("Placa: "+formulario.getMes());
            tvano.setText("Color: "+formulario.getAno());
        }
    }
}
