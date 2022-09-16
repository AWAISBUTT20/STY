package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent nxt = new Intent(this,SignUp.class);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(nxt);
                finish();
            }
        },2000);
    }
}