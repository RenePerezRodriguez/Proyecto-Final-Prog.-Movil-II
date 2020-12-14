package com.example.proyectollamasoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PrincipalActivity extends AppCompatActivity {

    QuienesSomosFragment quienesSomosFragment = new QuienesSomosFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BottomNavigationView navigation = findViewById(R.id.principal_navigation);
        navigation.setOnNavigationItemReselectedListener(mOnNavigationItemSelectedListener);
    }
    private final
    BottomNavigationView.OnNavigationItemReselectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.addFormFrag:
                    /*codigo para abrir lo que quieras*/
                case R.id.quienesSomosFrag:
                    loadFragment(quienesSomosFragment);
                case R.id.exitFrag:
                    finish();
            }
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.commit();
    }
}
