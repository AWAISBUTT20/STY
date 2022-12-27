package com.example.sty;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class search extends Fragment {


    public search() {
        // Required empty public constructor
    }

    RecyclerView rv;
    SearchView sv;
    ArrayList<String> productname = new ArrayList<>();
    ArrayList<String> productdesc = new ArrayList<>();
    ArrayList<String> productprice = new ArrayList<>();
    ArrayList<Integer> Product = new ArrayList<>();

    // Adapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //for activity in fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        //search view
        sv = view.findViewById(R.id.searchview);
        sv.setIconified(false);
        sv.clearFocus();
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        //recycler view
        rv = view.findViewById(R.id.rvsearch);
        prodctadapter adapter = new prodctadapter(getContext(), productname, productdesc, productprice, Product);
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false));
        rv.setAdapter((RecyclerView.Adapter) adapter);

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        productname.add("STY Tee 1");
        productname.add("STY Tee 2");
        productname.add("STY Tee 3");
        productname.add("STY Tee 4");
        productdesc.add("Black Cotton Shirt");
        productdesc.add("Black Cotton Shirt");
        productdesc.add("Black Cotton Shirt ");
        productdesc.add("Black Cotton Shirt");
        productprice.add("1,700/- Rs");
        productprice.add("1,000/- Rs");
        productprice.add("2,500/- Rs");
        productprice.add("900/- Rs");
        Product.add(R.drawable.menhodies);
        Product.add(R.drawable.mentees);
        Product.add(R.drawable.womentees);
        Product.add(R.drawable.womenhood);
    }

}