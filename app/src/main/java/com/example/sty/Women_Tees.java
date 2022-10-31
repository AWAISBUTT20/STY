package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class Women_Tees extends AppCompatActivity {
RecyclerView rv;
    ArrayList<String> prdctdesc=new ArrayList<>();
    ArrayList<Integer> prdctimg=new ArrayList<>();
    Adapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_tees);
        rv=findViewById(R.id.rvwomentee);
        prodctadapter prodctadapter=new prodctadapter(prdctdesc,prdctimg,this);
        rv.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));
        rv.setAdapter(prodctadapter);

        //description
        prdctdesc.add("Mens Tee 1 \n Description 1 \n Price: $10");
        prdctdesc.add("Mens Tee 2 \n Description 2 \n Price: $10");
        prdctdesc.add("Mens Tee 3 \n Description 3 \n Price: $10");
        prdctdesc.add("Mens Tee 4 \n Description 4 \n Price: $10");
        //product picture
        prdctimg.add(R.drawable.female);
        prdctimg.add(R.drawable.womentees);
        prdctimg.add(R.drawable.womenmodle);
        prdctimg.add(R.drawable.womenhood);
    }
}