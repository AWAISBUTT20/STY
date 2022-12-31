package com.example.sty.fragments;

import static androidx.browser.customtabs.CustomTabsClient.getPackageName;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;

import java.util.ArrayList;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sty.R;
import com.example.sty.activity.Accessories;
import com.example.sty.activity.mens_activity;
import com.example.sty.activity.women_activity;

public class Home extends Fragment {
Animation top;
    public Home() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        top= AnimationUtils.loadAnimation(getContext(),R.anim.top_animation);
        TextView txt1 = view.findViewById(R.id.txtnewcollection);
        txt1.setAnimation(top);
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

        //image slider
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageSlider imageSlider= view.findViewById(R.id.homeImgSlide);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.acsesories, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.acsesories, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.acsesories, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.acsesories, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.acsesories, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_INSIDE);
        imageSlider.startSliding(2000);

        return view;
    }

}