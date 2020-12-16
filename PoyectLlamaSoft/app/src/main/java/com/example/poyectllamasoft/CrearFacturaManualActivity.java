package com.example.poyectllamasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.poyectllamasoft.Clases.FacturaControl;
import com.example.poyectllamasoft.Clases.FacturaModel;

public class CrearFacturaManualActivity extends AppCompatActivity {

    private EditText etNIT, etNroFactura, etNroAutorizacion, etCodigoControl,etFecha,etImporte;
    private Button btnCrearFactura;
    private View view;
    private FacturaModel facturaModel;
    private FacturaControl facturaControl;
    private int idForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_factura_manual);

        view = inflater.inflate(R.layout.fragment_crearfac, container, false);

        etNIT = view.findViewById(R.id.etNIT);
        etNroFactura = view.findViewById(R.id.etNroFac);
        etNroAutorizacion = view.findViewById(R.id.etNroAutorizacion);
        etImporte = view.findViewById(R.id.etImporte);
        etCodigoControl = view.findViewById(R.id.etCodigoControl);
        etFecha = view.findViewById(R.id.etFecha);
        btnCrearFactura = view.findViewById(R.id.btnCrearFactura);

        facturaControl = new FacturaControl(getContext());
        idForm = getArguments().getInt("formId");
        btnCrearFactura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String NIT, nroFactura, nroAutorizacion, fecha, codigoControl, importe;
                    NIT = etNIT.getText().toString().trim();
                    nroFactura = etNroFactura.getText().toString().trim();
                    nroAutorizacion = etNroAutorizacion.getText().toString().trim();
                    fecha = etFecha.getText().toString().trim();
                    codigoControl = etCodigoControl.getText().toString().trim();
                    importe = etImporte.getText().toString().trim();
                    int nit = Integer.parseInt(NIT);
                    int nroFac = Integer.parseInt(nroFactura);
                    int nroAut = Integer.parseInt(nroAutorizacion);
                    double importeFac = Double.parseDouble(importe);
                    facturaModel = new FacturaModel(nit, nroFac, nroAut, importeFac, fecha, codigoControl, idForm);

                    long insert = facturaControl.newFac(facturaModel);
                    if (insert == -1) {
                        Toast.makeText(getContext(),"Error: Unrecorded invoice",Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getContext(), "datos almacenados", Toast.LENGTH_LONG).show();
                        Limpiar();

                    }
                }
                catch (Exception ex){
                    Toast.makeText(getContext(), "Error: " + ex, Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}