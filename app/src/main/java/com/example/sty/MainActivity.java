package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    FirebaseAuth firebaseAuth;
    TextView txt1,txt2;
    //FirebaseFirestore db=FirebaseFirestore.getInstance();
    @SuppressLint({"MissingInflatedId", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(Color.BLACK);
        navigationView = findViewById(R.id.navigationmenumain);
        drawerLayout = findViewById(R.id.drawermain);
        txt1=findViewById(R.id.draweruser);
        txt2=findViewById(R.id.draweremail);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        firebaseAuth=FirebaseAuth.getInstance();
        //check if user already exist or not
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        //set
        imageView=findViewById(R.id.imgdraweruser);
        //navigation drawer view
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.Mensmenu:
                        startActivity(new Intent(MainActivity.this, mens_activity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Womensmenu:
                        startActivity(new Intent(MainActivity.this, women_activity.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logoutmenu:
                        if (firebaseUser != null) {
                            firebaseAuth.signOut();
                            loadfrag(new Home(),false);
                        }else {
                            Toast.makeText(MainActivity.this, "No User Register ", Toast.LENGTH_SHORT).show();
                        }
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.usermenu:
                        loadfrag(new authentication(), false);
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.accsesorymenu:
                        startActivity(new Intent(MainActivity.this, Accessories.class));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Nothing", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
        //Activity
        //Bottom Navigation's
        BottomNavigationView bnv = findViewById(R.id.bottom_nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home) {
                    loadfrag(new Home(), false);
                } else if (id == R.id.search) {
                    loadfrag(new search(), true);
                } else if (id == R.id.Fav) {
                    loadfrag(new fav(), true);
                } else if (id == R.id.Cart) {
                    loadfrag(new Cart(), true);
                } else if (id == R.id.User) {
                    if (firebaseUser != null) {
                        loadfrag(new Userprofile(),true);
                    }else {
                        loadfrag(new authentication(), true);
                    }
                }
                return true;
            }
        });
        loadfrag(new Home(), false);
        bnv.setSelectedItemId(R.id.home);
    }

    //load_fragment method
    public void loadfrag(Fragment fragment, Boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        ft.addToBackStack("h");
        if (!flag) {
            ft.add(R.id.container, fragment);
        } else {
            ft.replace(R.id.container, fragment);
        }
        ft.commit();
    }

   /* public void featchfirestore(){
        //featching data from fire store(UserName)
        DocumentReference documentReference=db.document("User/User_1");
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String username = documentSnapshot.getString("User Name");
                            String email = documentSnapshot.getString("Email");
                            if (email.isEmpty()) {
                                txt1.setText("Username");
                                txt2.setText("Email");
                            }
                            txt1.setText(username);
                            txt2.setText(email);
                        }else {
                            Toast.makeText(MainActivity.this, "FireStore Fetching Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this, "FireStore Fetching Error", Toast.LENGTH_SHORT).show();

                    }
                });
    }*/
}
