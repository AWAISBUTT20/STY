package com.example.sty;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    //Button btn1,btn2,btn3,btn4,btn5;
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
      /*
       Bottom Navigation's
       btn1 =findViewById(R.id.home);
        btn2 =findViewById(R.id.search);
        btn3 =findViewById(R.id.Fav);
        btn4 =findViewById(R.id.Cart);
        btn5 =findViewById(R.id.User);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,Home.class);
                startActivity(nxt);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt1=new Intent(Home.this,mens_activity.class);
                startActivity(nxt1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt2=new Intent(Home.this,women_activity.class);
                startActivity(nxt2);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,Home.class);
                startActivity(nxt);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nxt=new Intent(Home.this,SignUp.class);
                startActivity(nxt);
            }
        });*/
        btn1=findViewById(R.id.btnmen);
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
        });
    }
}
