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
    Animation top,right,left;
    Button btn1, btn2, btn3, btn4;

    public Home() {
        // Required empty public constructor
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        top = AnimationUtils.loadAnimation(getContext(), R.anim.top_animation);
        right = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        left = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_left);
        TextView txt1 = view.findViewById(R.id.txtnewcollection);
        txt1.setAnimation(top);
        btn1 = view.findViewById(R.id.btnmen);
        btn1.setAnimation(top);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), mens_activity.class);
                startActivity(in);
            }
        });
        btn2 = view.findViewById(R.id.btnwomen);
        btn2.setAnimation(top);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), women_activity.class);
                startActivity(in);
            }
        });
        btn3 = view.findViewById(R.id.btnacsesori);
        btn3.setAnimation(top);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), Accessories.class);
                startActivity(in);
            }
        });
        btn4 = view.findViewById(R.id.btnnewarrivals);
        btn4.setAnimation(top);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        //image slider
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageSlider imageSlider = view.findViewById(R.id.homeImgSlide);
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.img1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.img1, ScaleTypes.FIT));
        imageSlider.setImageList(slideModels, ScaleTypes.CENTER_INSIDE);
        imageSlider.startSliding(2000);

        return view;
    }

}