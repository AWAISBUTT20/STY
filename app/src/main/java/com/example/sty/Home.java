package com.example.sty;

import static androidx.browser.customtabs.CustomTabsClient.getPackageName;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.VideoView;

import com.denzcoskun.imageslider.ImageSlider;

import java.util.ArrayList;
import java.util.List;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

public class Home extends Fragment {

    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        Button btnOpen = (Button) view.findViewById(R.id.btnmen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), mens_activity.class);
                startActivity(in);
            }
        });
        Button btnOpen2 = (Button) view.findViewById(R.id.btnwomen);
        btnOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), women_activity.class);
                startActivity(in);
            }
        });
        Button btnOpen3 = (Button) view.findViewById(R.id.btnacsesori);
        btnOpen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Accessories.class);
                startActivity(in);
            }
        });
        return view;
    }

}