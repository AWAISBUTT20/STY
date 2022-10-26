package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.GridLayout;

import java.util.ArrayList;
import java.util.List;

public class mens_product extends AppCompatActivity {
    RecyclerView rv;
    List<String> description = new ArrayList<>();
    List<Integer> Product = new ArrayList<>();
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_product);
        rv=findViewById(R.id.recyclerView);
        //description
        description.add("Product Name 1 \n Description 1 \n Price 10$");
        description.add("Product Name 2 \n Description 2 \n Price 10$");
        description.add("Product Name 3 \n Description 3 \n Price 10$");
        description.add("Product Name 4 \n Description 4 \n Price 10$");
        description.add("Product Name 5 \n Description 5 \n Price 10$");
        description.add("Product Name 6 \n Description 6 \n Price 10$");
        description.add("Product Name 7 \n Description 7 \n Price 10$");
        description.add("Product Name 8 \n Description 8 \n Price 10$");
        description.add("Product Name 9 \n Description 9 \n Price 10$");
        description.add("Product Name 10 \n Description 10 \n Price 10$");
        //product picture
        Product.add(R.drawable.menhodies);
        Product.add(R.drawable.mentees);
        Product.add(R.drawable.womenmodle);
        Product.add(R.drawable.female);
        Product.add(R.drawable.womenhood);
        Product.add(R.drawable.womentees);
        Product.add(R.drawable.product);
        Product.add(R.drawable.neck);
        Product.add(R.drawable.caps);
        Product.add(R.drawable.acsesories);

        myadapter adapter=new myadapter(description,Product,this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter((RecyclerView.Adapter) adapter);
    }
}