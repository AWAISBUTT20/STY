package com.example.sty;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Userprofile extends Fragment {

    public Userprofile() {
        // Required empty public constructor
    }
    TextView txt;
    String usrname;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);
        txt = view.findViewById(R.id.txtusrname);

        if (getArguments() != null) {
            usrname=getArguments().getString("user");
        }
        txt.setText(usrname);
        return view;
    }
}