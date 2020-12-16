package com.example.poyectllamasoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.snackbar.SnackbarContentLayout;

import static com.google.android.material.snackbar.Snackbar.make;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = findViewById(R.id.inicio_navigation);
        navigation.setOnNavigationItemReselectedListener(mOnNavigationItemSelectedListener);
    }
    private final
    BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.addFormMenu:
                    /*codigo para abrir lo que quieras*/
                    Intent pagina2 = new Intent(getApplicationContext(), CrearFormulario.class);
                    startActivity(pagina2);
                case R.id.quienesSomosMenu:
                    Snackbar.make( findViewById(R.id.coordinatorLayout), "Somos una empresa dedicada en el desarrollo de aplicaciones moviles", BaseTransientBottomBar.LENGTH_LONG).show();
                case R.id.exitMenu:
                    //finish();
            }
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_inicio, fragment);
        transaction.commit();
    }
}
