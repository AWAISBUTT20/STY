package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.core.FirestoreClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SignUp extends AppCompatActivity {
    Button btn, btn1;
    EditText txt1, txt2, txt3, txt4;
    ImageView iv;
    private FirebaseAuth firebaseAuth;
    private DBHandler DBHandler;
    String name;
    String user = "Awais butt";
    BroadcastReceiver broadcastReceiver;
    DocumentReference documentReference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        txt1 = findViewById(R.id.edttxtemail);
        txt2 = findViewById(R.id.editregPassword);
        txt3 = findViewById(R.id.edttxtConformPassword);
        txt4 = findViewById(R.id.edittxtregusername);
        iv=findViewById(R.id.imgprofil);
        //no internet Alert
        broadcastReceiver = new NetworkBrodcast();
        registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        // creating a new DBHandler class
        // and passing our context to it.
        DBHandler = new DBHandler(SignUp.this);
        firebaseAuth = FirebaseAuth.getInstance();

        //user = txt4.getText().toString();
        btn = findViewById(R.id.BtnRegister);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadfirestore();
              createUser();
               // Toast.makeText(SignUp.this, "UserName", Toast.LENGTH_SHORT).show();
            }
        });
        btn1 = findViewById(R.id.btnreg_login);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUp.this, login_m.class);
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
        } else if (email.isEmpty()) {
            txt1.setError("Email cannot be empty");
        } else if (password.isEmpty()) {
            txt2.setError("Password cannot be empty");
        } else if (!password.equals(confirmpass)) {
            txt3.setError("Password Unmatched");
        } else {
            //SQLite database

            sqldb();
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
            Intent intent = new Intent(SignUp.this, login_m.class);
            startActivity(intent);
            Toast.makeText(SignUp.this, "Successful", Toast.LENGTH_SHORT).show();
        }
    }

    private void sqldb() {
        String userName = txt4.getText().toString();
        if (userName.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter UserName", Toast.LENGTH_SHORT).show();
            return;
        }
        DBHandler.addnewuser(userName);
        Toast.makeText(SignUp.this, "User has been added to SQL.", Toast.LENGTH_SHORT).show();

        Log.d("info", "Name : " + DBHandler.feactch());
        name = DBHandler.feactch();

    }

    public void uploadfirestore() {
        String username = txt4.getText().toString();
        String email = txt1.getText().toString();
        //FireStore
        FirebaseFirestore cloud_db = FirebaseFirestore.getInstance();
        Map<String, Object> user = new HashMap<>();
        user.put("User Name", username);
        user.put("Email", email);
        cloud_db.collection("User").document("User_1").set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(SignUp.this, "Firestore Success", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(SignUp.this, "FireStore Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }

    public String getuser() {
        if (setuser().isEmpty()) {
            return "Empty";
        }
        return setuser();
    }

    public String setuser() {
        return user;
    }

}

