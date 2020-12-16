package com.example.poyectllamasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CrearFormulario extends AppCompatActivity {

    private EditText etMes, etAnio,etNombre;
    private Button btnCrear;
    private Formulario formulario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_formulario);

        etNombre = findViewById(R.id.etNombre);
        etMes = findViewById(R.id.etMes);
        etAnio = findViewById(R.id.etAnio);
        btnCrear = findViewById(R.id.btnCrear);

        final sqladapter connectionDB = new sqladapter(getApplicationContext());

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombreString = etNombre.getText().toString().trim();
                String mesString = etMes.getText().toString().trim();
                String anoString = etAnio.getText().toString().trim();
                if (nombreString.equals("")) {
                    etNombre.setError("Ingresa el nombre");
                    etNombre.requestFocus();
                    return;
                }
                if (mesString.equals("")) {
                    etMes.setError("Ingresa el mes");
                    etMes.requestFocus();
                    return;
                }
                if (anoString.equals("")) {
                    etAnio.setError("Ingresa el ano");
                    etAnio.requestFocus();
                    return;
                }

                //pasear datos
                int mes = Integer.parseInt(mesString);
                int ano = Integer.parseInt(anoString);
                //agregar datos

                formulario = new Formulario(nombreString, mes, ano);
                connectionDB.Insert(formulario);
                //long resultado = controladorFormulario.insertaFormulario(formulario);
                    Toast.makeText(getApplicationContext(), "Error al insertar formulario", Toast.LENGTH_LONG).show();
                    limpiarFormulario();
                }
            
        });
    }
    private void limpiarFormulario() {
        etNombre.setText("");
        etMes.setText("");
        etAnio.setText("");
    }
}