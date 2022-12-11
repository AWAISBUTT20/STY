package com.example.sty;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class Cart extends Fragment {


    public Cart() {
        // Required empty public constructor
    }

    RecyclerView rv;
    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice = new ArrayList<>();
    ArrayList<Integer> prdctimg = new ArrayList<>();
    TextView quantity;
    int count;
    Button btn1, btn2, btnopen;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        rv = view.findViewById(R.id.rvcart);
        btnopen = view.findViewById(R.id.btnchckout);
        cartadpater cartadpater = new cartadpater(getContext(), prdctname, prdctdesc, prdctprice, prdctimg);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(cartadpater);

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), checkout.class);
                //in.putExtra("some", "Mens Wears");
                startActivity(in);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prdctname.add("STY Tee1");
        prdctname.add("STY Tee2");
        prdctname.add("STY Tee3");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctprice.add("100$");
        prdctprice.add("150$");
        prdctprice.add("130$");
        prdctimg.add(R.drawable.menhodies);
        prdctimg.add(R.drawable.mentees);
        prdctimg.add(R.drawable.womentees);

    }
}