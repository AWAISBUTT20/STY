package com.example.sty;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {
   BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
       /* btn1=findViewById(R.id.btnmen);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,mens_activity.class);
                startActivity(nxt);
            }
        });
        btn2=findViewById(R.id.btnwomen);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,women_activity.class);
                startActivity(nxt);
            }
        });
        btn3=findViewById(R.id.btnacsesori);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,Accessories.class);
                startActivity(nxt);
            }
        });*/
        //Bottom Navigation's
        bottomNavigationView =findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 int id=item.getItemId();
                if (id == R.id.home) {
                   loadfrag(new main(),true);
                }else  if (id == R.id.search) {
                    loadfrag(new search(),true);
                }else  if (id == R.id.Fav) {
                    loadfrag(new fav(),true);
                }else  if (id == R.id.Cart) {
                    loadfrag(new Cart(),true);
                }else  if (id == R.id.User) {
                    loadfrag(new Userprofile(),false);
                }
                return true;
            }
        });
    //Bottom Navigation
    bottomNavigationView.setSelectedItemId(R.id.User);
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
