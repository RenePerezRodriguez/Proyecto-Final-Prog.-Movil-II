package com.example.proyectollamasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearForm extends AppCompatActivity {

    private EditText nombre,mes,ano;
    private Button btnGuardar;
    private ControladorFormulario controladorFormulario;
    private Formulario formulario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_form);

        nombre = findViewById(R.id.txtnombre);
        mes = findViewById(R.id.txtmes);
        ano = findViewById(R.id.txtano);
        btnGuardar = findViewById(R.id.btnguardar);

        controladorFormulario = new ControladorFormulario(CrearForm.this);
        formulario = new Formulario();
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreString = nombre.getText().toString().trim();
                String mesString = mes.getText().toString().trim();
                String anoString = ano.getText().toString().trim();
                if (nombreString.equals("")) {
                    nombre.setError("Ingresa el nombre");
                    nombre.requestFocus();
                    return;
                }
                if (mesString.equals("")) {
                    mes.setError("Ingresa el mes");
                    mes.requestFocus();
                    return;
                }
                if (anoString.equals("")) {
                    ano.setError("Ingresa el ano");
                    ano.requestFocus();
                    return;
                }

                //pasear datos
                int mes = Integer.parseInt(mesString);
                int ano = Integer.parseInt(anoString);
                //agregar datos

                formulario = new Formulario(nombreString, mes, ano);
                long resultado = controladorFormulario.insertaFormulario(formulario);
                if (resultado == -1) {
                    //error al insertar
                    Toast.makeText(getApplicationContext(), "Error al insertar formulario", Toast.LENGTH_LONG).show();
                } else {
                    //se inserto correctamente
                    Toast.makeText(getApplicationContext(), "Formulario insertado correctamente", Toast.LENGTH_LONG).show();
                    //cargarVehiculosSqlite();
                    //adaptador = new Adaptador(listaVehiculos);
                    //rvListaVehiculos.setAdapter(adaptador);
                    limpiarFormulario();
                }
            }
        });
    }
    private void limpiarFormulario() {
        nombre.setText("");
        mes.setText("");
        ano.setText("");
    }
}