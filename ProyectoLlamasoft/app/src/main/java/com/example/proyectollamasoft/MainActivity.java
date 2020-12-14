package com.example.proyectollamasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img,img1;
    Thread tiempo = new Thread();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imglogo);

        Animation acercar = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);

        img.startAnimation(acercar);


         /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent pagina2 = new Intent(getApplicationContext(), InicioActivity.class);
                startActivity(pagina2);
                finish();
            }
        },2000);*/


        /*new Thread(new Runnable() {
            @Override
            public void run() {

                Intent pagina = new Intent(getApplicationContext(),InicioActivity.class);
                startActivity(pagina);

            }
        }).start();*/


    }

    /*@Override
    protected void onStart() {
        super.onStart();
        Intent pagina2 = new Intent(getApplicationContext(),InicioActivity.class);
        startActivity(pagina2);
    }*/
}