package com.example.sty;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class fav extends Fragment {
    RecyclerView rv;
    Adapter adapter;
    ArrayList<String> prdctname=new ArrayList<>();
    ArrayList<String> prdctdesc=new ArrayList<>();
    ArrayList<String> prdctprice=new ArrayList<>();
    ArrayList<Integer> prdctimg=new ArrayList<>();

    public fav() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fav, container, false);
    rv =view.findViewById(R.id.rvfav);
    favadapter myfavadapter=new favadapter(prdctname,prdctdesc,prdctprice,prdctimg,getContext());
    rv.setAdapter(myfavadapter);
    rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prdctname.add("STY Tee1");
        prdctname.add("STY Tee2");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctprice.add("100$");
        prdctprice.add("120$");
        prdctimg.add(R.drawable.womenmodle);
        prdctimg.add(R.drawable.female);
    }
}