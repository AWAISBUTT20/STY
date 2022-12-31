package com.example.sty.fragments;

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

import com.example.sty.R;
import com.example.sty.activity.SignUp;
import com.example.sty.activity.login_m;

public class authentication extends Fragment {
    Button btn1, btn2;
    Animation bottom;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_authenticaion, container, false);
        bottom = AnimationUtils.loadAnimation(getContext(),R.anim.bottom_animation);
        //Activity
        btn1 = view.findViewById(R.id.btnwelcomelog);
        btn2 = view.findViewById(R.id.btnwelcomesignup);
        btn1.setAnimation(bottom);
        btn2.setAnimation(bottom);
        //btn3 = view.findViewById(R.id.btnwellcomayb);
        //firebaseAuth = FirebaseAuth.getInstance();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), login_m.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SignUp.class);
                startActivity(intent);
            }
        });
      /*   btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });*/
        return view;
    }
}