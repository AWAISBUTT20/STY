package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btn1.findViewById(R.id.btnmen);
btn2.findViewById(R.id.btnwomen);
btn3.findViewById(R.id.btnacsesori);

    }
}