package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login_m extends AppCompatActivity {
    Button btn1, btn2,btn3;
    FirebaseAuth mauth;
    EditText txt1, txt2;
    BroadcastReceiver broadcastReceiver;

    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_m);
        //no internet alert
        broadcastReceiver = new NetworkBrodcast();
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        mauth = FirebaseAuth.getInstance();
        btn1 = findViewById(R.id.cirLoginButton);
        btn2 = findViewById(R.id.btnsignup);
        btn3=findViewById(R.id.btnforget);
        txt1 = findViewById(R.id.email);
        txt2 = findViewById(R.id.editTextPassword);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(login_m.this,forgetpassword.class));
            }
        });
        btn1.setOnClickListener(view -> {
            loginUser();
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt = new Intent(login_m.this, SignUp.class);
                startActivity(nxt);
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            if (bundle.getString("some") != null) {
                Toast.makeText(getApplicationContext(),
                        "data:" + bundle.getString("some"),
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void loginUser() {
        String email = txt1.getText().toString();
        String password = txt2.getText().toString();

        if (password.isEmpty()) {
            txt2.setError("Enter Password");
        } else if (email.isEmpty()) {
            txt1.setError("Enter Email Address");
        } else {
            mauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(login_m.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(login_m.this, MainActivity.class);
                        startActivity(intent);
                    } else
                        Toast.makeText(login_m.this, "Login UnSuccessfully" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(login_m.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void viewForgotPassword(View view) {
    }
}