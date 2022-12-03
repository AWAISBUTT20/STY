package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.widget.Button;
import android.view.Menu;
import android.view.View;

public class welcome extends AppCompatActivity {
    Button btn1, btn2, btn3;
    // FirebaseAuth firebaseAuth;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
   BroadcastReceiver broadcastReceiver;

    /*firebase
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if (user == null) {
            startActivity(new Intent(welcome.this,login_m.class));
        }
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome);
        //No internet signal
        broadcastReceiver=new NetworkBrodcast();
        registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        toolbar = findViewById(R.id.custom_toolbar);
        //setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.navigationmenu);
        drawerLayout = findViewById(R.id.drawer);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.Mensmenu:
                        Toast.makeText(welcome.this, "Men Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Womensmenu:
                        Toast.makeText(welcome.this, "Women Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logoutmenu:
                        Toast.makeText(welcome.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.usermenu:
                        Toast.makeText(welcome.this, "User Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.accsesorymenu:
                        Toast.makeText(welcome.this, "Accessories Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    default:
                        Toast.makeText(welcome.this, "Kuch Ni", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
        //Activity
        btn1 = findViewById(R.id.btnwelcomelog);
        btn2 = findViewById(R.id.btnwelcomesignup);
        btn3 = findViewById(R.id.btnwellcomayb);
        //firebaseAuth = FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this, login_m.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this, SignUp.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    unregisterReceiver(broadcastReceiver);
    }
/* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.Mensmenu:
                Intent intent=new Intent(welcome.this,mens_activity.class);
                Toast.makeText(welcome.this, "Mens Clicked", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.Womensmenu:
                Toast.makeText(welcome.this, "Women Clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.accsesorymenu:
                Toast.makeText(welcome.this, "Accessories Clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case R.id.logoutmenu:
                Toast.makeText(welcome.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            default:
                Toast.makeText(welcome.this, "Kuch Ni", Toast.LENGTH_SHORT).show();
        }
        return true;
    }*/
}