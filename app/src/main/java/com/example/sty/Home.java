package com.example.sty;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_main, container, false);
        Button btnOpen = (Button) view. findViewById(R.id.btnmen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), mens_activity.class);
                //in.putExtra("some", "Mens Wears");
                startActivity(in);
            }
        });
        Button btnOpen2 = (Button) view. findViewById(R.id.btnwomen);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), women_activity.class);
                //in.putExtra("some", "Mens Wears");
                startActivity(in);
            }
        });
        Button btnOpen3 = (Button) view. findViewById(R.id.btnacsesori);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent in = new Intent(getActivity(), Accessories.class);
                //in.putExtra("some", "Mens Wears");
                startActivity(in);
            }
        });
        return view;
    }
}