package com.example.sty;

import android.os.Bundle;

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
    private DBHandler DBHandler;
    String usrname;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_userprofile, container, false);
        TextView txt =view.findViewById(R.id.txtusrname);

        //usrname=DBHandler.feactch().toString();

        txt.setText("username");
        return view;
    }
}