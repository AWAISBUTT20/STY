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
   BottomNavigationView bottomNavigationView;
   String fn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Bottom Navigation's
        bottomNavigationView =findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
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
                    loadfrag(new Userprofile(),true);
                }
                return true;
            }
        });
    //Bottom Navigation
    bottomNavigationView.setSelectedItemId(R.id.home);
    }
    public void loadfrag(Fragment fragment,Boolean flag){
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();

        Bundle bundle=new Bundle();
        bundle.putString("user","fn");
        fragment.setArguments(bundle);

        if (!flag) {
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }

}
