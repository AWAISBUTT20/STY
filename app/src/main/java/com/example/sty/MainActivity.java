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
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationmenumain);
        drawerLayout = findViewById(R.id.drawermain);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.Mensmenu:
                        Toast.makeText(MainActivity.this, "Men Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.Womensmenu:
                        Toast.makeText(MainActivity.this, "Women Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.logoutmenu:
                        Toast.makeText(MainActivity.this, "Logout Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.usermenu:
                        Toast.makeText(MainActivity.this, "User Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.accsesorymenu:
                        Toast.makeText(MainActivity.this, "Accessories Clicked", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Kuch Ni", Toast.LENGTH_SHORT).show();
                }

                return true;
            }
        });
        //Activity
        //Bottom Navigation's
        BottomNavigationView bnv =findViewById(R.id.bottom_nav);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if (id == R.id.home) {
                    loadfrag(new Home(),false);
                }else  if (id == R.id.search) {
                    loadfrag(new search(),true);
                }else  if (id == R.id.Fav) {
                    loadfrag(new fav(),true);
                }else  if (id == R.id.Cart) {
                    loadfrag(new Cart(),true);
                }else  if (id == R.id.User) {
                   // loadfrag(new Userprofile(),true);
                    loadfrag(new authentication(),true);
                }
                return true;
            }
        });
        loadfrag(new Home(),false);
//My first fragment
        bnv.setSelectedItemId(R.id.home);
    }
    //load_fragment method
    public void loadfrag(Fragment fragment,Boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        if (!flag) {
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }

}
