package com.example.poyectllamasoft;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class FormularioActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private CrearFacturaManualFragment fragmentCrearFac;
    private ListaFacturasFragment fragmentListFac;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    TextView txtQr;
    int formId;
    String anio;
    String nombre;
    String mes;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        Bundle bundle = getIntent().getExtras();
        formId = bundle.getInt("formId");
        anio = bundle.getString("anio");
        nombre = bundle.getString("nombre");
        mes = bundle.getString("mes");

        Bundle bundleArgs = new Bundle();
        bundleArgs.putInt("formId",formId);
        bundleArgs.putString("nombre",nombre);
        bundleArgs.putString("mes",mes);
        bundleArgs.putString("anio",anio);

        ListaFacturasFragment fragmentListFac = new ListaFacturasFragment();
        fragmentListFac.setArguments(bundleArgs);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ListaFactura(fragmentListFac);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menufactura, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void ListaFactura(ListaFacturasFragment fragmentListFacA) {
        try {
            DeleteFragment();
            fragmentManager = getSupportFragmentManager();
            fragmentListFac = new ListaFacturasFragment();
            fragmentListFac.setArguments(getIntent().getExtras());
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.panelId, fragmentListFac, "list");
            fragmentTransaction.replace(R.id.fragmentListaFactura, fragmentListFacA);
            fragmentTransaction.commit();
        }
        catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        String datos = result.getContents();
        txtQr.setText(datos);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.lista_fac:
                ListaFactura(fragmentListFac);
                break;
            case R.id.agregar_fac:
                Bundle bundleArgs = new Bundle();
                bundleArgs.putInt("formId",formId);
                CrearFacturaManualFragment fragmentCrearFac = new CrearFacturaManualFragment();
                fragmentCrearFac.setArguments(bundleArgs);
                AgregarFac(fragmentCrearFac);
                break;
            case R.id.agregar_facqr:
                new IntentIntegrator(this).initiateScan();
                setContentView(R.layout.fragment_listafacqr);
                txtQr = findViewById(R.id.txtQr);
                break;

            case R.id.ver_facqr:


                break;
            case  R.id.agregar_excel:
                Toast.makeText(this, "Export to Excel", Toast.LENGTH_SHORT).show();
                break;

        }


        return super.onOptionsItemSelected(item);
    }

    private void AgregarFac(CrearFacturaManualFragment fragmentCrearFacArgs) {
        try {
            fragmentManager = getSupportFragmentManager();
            fragmentCrearFac = new CrearFacturaManualFragment();
            fragmentCrearFac.setArguments(getIntent().getExtras());
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.panelId, fragmentCrearFac, "bill");
            fragmentTransaction.replace(R.id.fragmentAgregarFactura, fragmentCrearFacArgs);
            fragmentTransaction.commit();
        } catch (Exception ex) {
            Toast.makeText(this, "Error: " + ex, Toast.LENGTH_SHORT).show();
        }
    }

    private void DeleteFragment() {
        fragmentManager = getSupportFragmentManager();
        if (fragmentManager.findFragmentByTag("bill") != null) {
            getSupportFragmentManager().beginTransaction().remove(fragmentCrearFac).commit();
        }
        if(fragmentManager.findFragmentByTag("list") != null) {
            getSupportFragmentManager().beginTransaction().remove(fragmentListFac).commit();
        }
    }


}