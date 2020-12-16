package com.example.poyectllamasoft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {

    ImageView img,img1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        img = findViewById(R.id.imglogo);

        Animation acercar = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);

        img.startAnimation(acercar);


       new Handler().postDelayed(() -> {
           Intent pagina2 = new Intent(getApplicationContext(), MainActivity.class);
           startActivity(pagina2);
           finish();
       },2500);
    }
}