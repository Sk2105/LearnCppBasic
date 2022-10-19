package com.sgtech.learncppbasic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {
    TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        text = findViewById(R.id.text);
        new Handler().postDelayed(() -> {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                , 3000);
    }

}