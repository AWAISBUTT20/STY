package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class welcome extends AppCompatActivity {
Button btn1,btn2,btn3;
FirebaseAuth firebaseAuth;

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(welcome.this,login_m.class));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        btn1 =findViewById(R.id.btnwelcomelog);
        btn2 =findViewById(R.id.btnwelcomesignup);
        btn3 =findViewById(R.id.btnwellcomayb);
        firebaseAuth =FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(welcome.this,login_m.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(welcome.this,SignUp.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(welcome.this,MainActivity.class);
                startActivity(intent);
            }
        });


    }
    }