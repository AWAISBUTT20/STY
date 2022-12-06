package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;

public class Women_Tees extends AppCompatActivity {
RecyclerView rv;
    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice= new ArrayList<>();
    ArrayList<Integer> prdctimg=new ArrayList<>();
    Adapter ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_women_tees);
        rv=findViewById(R.id.rvwomentee);
        prodctadapter prodctadapter=new prodctadapter(Women_Tees.this,prdctname,prdctdesc,prdctprice,prdctimg);
        rv.setLayoutManager(new GridLayoutManager(this,2,RecyclerView.VERTICAL,false));
        rv.setAdapter(prodctadapter);
        prdctname.add("STY Tee 1");
        prdctname.add("STY Tee 2");
        prdctname.add("STY Tee 3");
        prdctname.add("STY Tee 4");
        prdctdesc.add("Black Cotton Shirt");
        prdctdesc.add("Black Cotton Shirt");
        prdctdesc.add("Black Cotton Shirt ");
        prdctdesc.add("Black Cotton Shirt");
        prdctprice.add("200$");
        prdctprice.add("100$");
        prdctprice.add("150$");
        prdctprice.add("130$");
        prdctimg.add(R.drawable.menhodies);
        prdctimg.add(R.drawable.mentees);
        prdctimg.add(R.drawable.womentees);
        prdctimg.add(R.drawable.womenhood);
    }
}