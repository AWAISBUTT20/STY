package com.example.sty;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
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
        if (!flag) {
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}
