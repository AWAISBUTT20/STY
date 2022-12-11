package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgetpassword extends AppCompatActivity {
Button btn1,btn2;
EditText edt1,edt2;
FirebaseAuth mfirebaseauth;
BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgetpassword);

        mfirebaseauth=FirebaseAuth.getInstance();
        btn1=findViewById(R.id.btnforgetpass);
        btn2=findViewById(R.id.btnbacktologin);
        edt1=findViewById(R.id.edtforgetemail);
        //no internet Alert
        broadcastReceiver = new NetworkBrodcast();
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validatedata();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(forgetpassword.this,login_m.class));
            }
        });
    }

    private void validatedata() {
        String email = edt1.getText().toString();
        if (email.isEmpty()) {
            edt2.setError("Enter Email ");
        } else {
            mfirebaseauth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(forgetpassword.this,login_m.class));
                        finish();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(forgetpassword.this,"Check your Email",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }




}