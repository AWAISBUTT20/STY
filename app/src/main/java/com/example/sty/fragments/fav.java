package com.example.sty.fragments;

import static com.example.sty.activity.MainActivity.bnv;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.sty.R;
import com.example.sty.databinding.FragmentFavBinding;
import com.example.sty.adapters.favadapter;

import java.util.ArrayList;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class fav extends Fragment {
    RecyclerView rv;
    Adapter adapter;
    Animation top,bottom,right;
    Button btn;
    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice = new ArrayList<>();
    ArrayList<Integer> prdctimg = new ArrayList<>();
    @SuppressLint("MissingInflatedId")
    public fav() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        //Animation
        top= AnimationUtils.loadAnimation(getContext(),R.anim.top_animation);
        bottom=AnimationUtils.loadAnimation(getContext(),R.anim.bottom_animation);
        right=AnimationUtils.loadAnimation(getContext(),R.anim.leftmove);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView txt=view.findViewById(R.id.fav_txt);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView img =view.findViewById(R.id.stylogofav);
        txt.setAnimation(top);
        img.setAnimation(top);
        //recycler View
        rv = view.findViewById(R.id.rvfav);
        favadapter myfavadapter = new favadapter(prdctname, prdctdesc, prdctprice, prdctimg, getContext());
        rv.setAdapter(myfavadapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAnimation(right);
        //Button
        btn=view.findViewById(R.id.btnaddtobag);
        btn.setAnimation(bottom);
        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingInflatedId")
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(getContext(),SweetAlertDialog.SUCCESS_TYPE).
                        setTitleText("Added to Cart").
                        setContentText("Successful").
                        setConfirmText("Go To Cart").setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                bnv.setSelectedItemId(R.id.Cart);
                            }
                        }).setCancelButton("Continue", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sweetAlertDialog) {
                                sweetAlertDialog.dismissWithAnimation();
                                bnv.setSelectedItemId(R.id.home);
                            }
                        })
                        .show();
            }
        });
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prdctname.add("STY Tee 1");
        prdctdesc.add("Black Cotton Shirt \nProduct No. #36251");
        prdctprice.add("1,700/- Rs");
        prdctimg.add(R.drawable.female);
        prdctname.add("STY Tee 2");
        prdctdesc.add("Cotton Shirt \nProduct No. #361");
        prdctprice.add("1,000/- Rs");
        prdctimg.add(R.drawable.male);
    }
}