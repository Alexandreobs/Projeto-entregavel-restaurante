package com.example.entregavelrestaurante.views.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.entregavelrestaurante.R;

import java.util.Timer;
import java.util.TimerTask;

public class TelaDeSplashActivity extends AppCompatActivity {
    private Timer timer = new Timer();
    private ImageView Logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_splash);

        getSupportActionBar().hide();

        Logo = findViewById(R.id.ImagemSplash);

        Logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jump();
            }
        });

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                jump();
            }
        }, 2000);
    }

    private void jump(){
        timer.cancel();
        startActivity(new Intent(TelaDeSplashActivity.this, TelaDeLoginActivity.class));
        finish();
    }

}