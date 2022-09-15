package com.example.sty;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class login_m extends AppCompatActivity {
  /*  Button gglbtn;
    private FirebaseAuth auth;
    GoogleSignInOptions googleSignInOptions;
    Button btngmail,btnout;
    GoogleSignInClient googlesignInClient;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_m);
        /*btngmail = findViewById(R.id.google);
        auth = FirebaseAuth.getInstance();
        googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail()
                .build();
        googlesignInClient = GoogleSignIn.getClient(this, googleSignInOptions);
        btngmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences Pref = getSharedPreferences("login", MODE_PRIVATE);
                SharedPreferences.Editor editor = Pref.edit();
                editor.putBoolean("flag", true);
                editor.apply();
                Intent nxt2 = new Intent(login_m.this, MainActivity.class);
                startActivity(nxt2);
                Signin();
            }
        });
    }
    private void Signin () {
        Intent intent = googlesignInClient.getSignInIntent();
        startActivityForResult(intent, 100);
    }
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try {
                task.getResult(ApiException.class);
                Toast.makeText(this, "Sign in succsesfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(login_m.this, MainActivity.class);
                startActivity(intent);
                finish();
            } catch (ApiException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        }
          */
        /*  btnout=findViewById(R.id.item7);
            btnout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SignOut();
                }
            });
        }
        private void SignOut() {
            googlesignInClient.signOut().addOnCompleteListener(this,new OnCompleteListener<Void>() {

                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    finish();
                    startActivity(new Intent(getApplicationContext(),Splash.class));
                }
            });
            Toast.makeText(this,"Logout Sucssesfully",Toast.LENGTH_SHORT).show();
        }}*/
    }
}