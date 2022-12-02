package com.example.sty;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
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
    List<String> description = new ArrayList<>();
    List<Integer> Product = new ArrayList<>();
    Adapter adapter;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //for activity in fragment
        View view= inflater.inflate(R.layout.fragment_search, container, false);
        sv=view.findViewById(R.id.searchview);
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
        rv=view.findViewById(R.id.rvsearch);
        prodctadapter adapter=new prodctadapter(description,Product,getContext());
        rv.setLayoutManager(new GridLayoutManager(getActivity(),2,GridLayoutManager.VERTICAL,false));
        rv.setAdapter((RecyclerView.Adapter) adapter);

    return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //description
        description.add("Product Name 1 \n Description 1 \n Price 10$");
        description.add("Product Name 2 \n Description 2 \n Price 10$");
        description.add("Product Name 3 \n Description 3 \n Price 10$");
        description.add("Product Name 4 \n Description 4 \n Price 10$");
        description.add("Product Name 5 \n Description 5 \n Price 10$");
        description.add("Product Name 6 \n Description 6 \n Price 10$");
        //product picture
        Product.add(R.drawable.menhodies);
        Product.add(R.drawable.mentees);
        Product.add(R.drawable.womenmodle);
        Product.add(R.drawable.female);
        Product.add(R.drawable.womenhood);
        Product.add(R.drawable.womentees);
    }

}