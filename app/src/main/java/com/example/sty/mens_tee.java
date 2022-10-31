package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class mens_tee extends AppCompatActivity {
    RecyclerView rv;
    List<String> description = new ArrayList<>();
    List<Integer> Product = new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_tees);
        rv=findViewById(R.id.recyclerView);
        //description
        description.add("Mens Tee 1 \n Description 1 \n Price: $10");
        description.add("Mens Tee 2 \n Description 2 \n Price: $10");
        description.add("Mens Tee 3 \n Description 3 \n Price: $10");
        description.add("Mens Tee 4 \n Description 4 \n Price: $10");
        description.add("Mens Tee 5 \n Description 5 \n Price: $10");
        description.add("Mens Tee 6 \n Description 6 \n Price: $10");
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