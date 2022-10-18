package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    Button btn,btn1;
    EditText txt1,txt2,txt3,txt4;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
       txt1=findViewById(R.id.edttxtemail);
       txt2=findViewById(R.id.editregPassword);
       txt3=findViewById(R.id.edttxtConformPassword);
       txt4=findViewById(R.id.edittxtregusername);
       firebaseAuth= FirebaseAuth.getInstance();
       btn=findViewById(R.id.BtnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
            }
        });
        btn1=findViewById(R.id.btnreg_login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,login_m.class);
            startActivity(intent);
            }
        });
    }
    private void createUser() {
        String email = txt1.getText().toString();
        String password = txt2.getText().toString();
        String confirmpass = txt3.getText().toString();
        String username = txt4.getText().toString();
        if (username.isEmpty()) {
            txt4.setError("Username cannot be empty");
        }else if (email.isEmpty()) {
            txt1.setError("Email cannot be empty");
        }
        else if (password.isEmpty()) {
            txt2.setError("Password cannot be empty");
        }else if (!password.equals(confirmpass)) {
            txt3.setError("Password Unmatched");
        } else {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(SignUp.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(SignUp.this, "User Register Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
            Toast.makeText(SignUp.this, "Successful", Toast.LENGTH_SHORT).show();
        }
    }
}