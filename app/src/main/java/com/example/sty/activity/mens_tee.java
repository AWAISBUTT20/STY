package com.example.sty.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;

import com.example.sty.R;
import com.example.sty.adapters.prodctadapter;

import java.util.ArrayList;

public class mens_tee extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Integer> prdctimg = new ArrayList<>();
    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice = new ArrayList<>();
    Button btn2;
    Adapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mens_tees);
        getWindow().setStatusBarColor(Color.BLACK);
        rv = findViewById(R.id.recyclerView);
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

        prodctadapter adapter = new prodctadapter(mens_tee.this, prdctname, prdctdesc, prdctprice, prdctimg);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter((RecyclerView.Adapter) adapter);
    }
}