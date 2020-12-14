package com.example.poyectllamasoft;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    /*QuienesSomosFragment quienesSomosFragment = new QuienesSomosFragment();*/

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
               /* case R.id.quienesSomosFrag:
                    loadFragment(quienesSomosFragment);*/
                case R.id.exitMenu:
                    finish();
            }
        }
    };

    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container_inicio, fragment);
        transaction.commit();
    }
}
