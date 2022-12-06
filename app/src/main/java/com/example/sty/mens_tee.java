package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class mens_tee extends AppCompatActivity {
    RecyclerView rv;
    List<String> description = new ArrayList<>();
    List<Integer> Product = new ArrayList<>();
    Button btn2;
    Adapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_tees);
        rv=findViewById(R.id.recyclerView);
      /* btn2=findViewById(R.id.btnaddtobag);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mens_tee.this,"Added To Bag",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(mens_tee.this,Cart.class);
                startActivity(intent);
            }
        });*/
        //description
        description.add("Mens Tee 1 \n Description 1 \n Price: $10");
        description.add("Mens Tee 2 \n Description 2 \n Price: $20");
        description.add("Mens Tee 3 \n Description 3 \n Price: $30");
        description.add("Mens Tee 4 \n Description 4 \n Price: $40");
        description.add("Mens Tee 5 \n Description 5 \n Price: $50");
        description.add("Mens Tee 6 \n Description 6 \n Price: $60");
        //product picture
        Product.add(R.drawable.menhodies);
        Product.add(R.drawable.mentees);
        Product.add(R.drawable.product);
        Product.add(R.drawable.neck);
        Product.add(R.drawable.caps);
        Product.add(R.drawable.acsesories);

        prodctadapter adapter=new prodctadapter(description,Product, mens_tee.this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter((RecyclerView.Adapter) adapter);
    }
}