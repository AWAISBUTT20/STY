package com.example.sty.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sty.R;
import com.example.sty.activity.checkout;
import com.example.sty.adapters.cartadpater;

import java.util.ArrayList;


public class Cart extends Fragment {


    public Cart() {
        // Required empty public constructor
    }

    Animation topAnim, bottomAnim, right;
    RecyclerView rv;
    ArrayList<String> prdctname = new ArrayList<>();
    ArrayList<String> prdctdesc = new ArrayList<>();
    ArrayList<String> prdctprice = new ArrayList<>();
    ArrayList<Integer> prdctimg = new ArrayList<>();
    Button btnopen;
    public static int sum;
    int price1 = 1500;
    int price2 = 1200;
    int price3 = 800;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        //Animations
        topAnim = AnimationUtils.loadAnimation(getContext(), R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(getContext(), R.anim.bottom_animation);
        right = AnimationUtils.loadAnimation(getContext(), R.anim.leftmove);
        TextView txt = view.findViewById(R.id.cart_txt);
        TextView txt1 = view.findViewById(R.id.cartTotal);
        //total
        sum = price1 + price2 + price3;
        txt1.setText(sum + "/- Rs");
        ImageView img = view.findViewById(R.id.stylogocart);
        txt.setAnimation(topAnim);
        img.setAnimation(topAnim);
        txt1.setAnimation(right);
        //Hooks
        rv = view.findViewById(R.id.rvcart);
        btnopen = view.findViewById(R.id.btncheckout);
        // btnopen.setAnimation (bottomAnim);
        // rv.setAnimation (topAnim);
        cartadpater cartadpater = new cartadpater(getContext(), prdctname, prdctdesc, prdctprice, prdctimg);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(cartadpater);
        //rv.setAnimation(right);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(getActivity(), checkout.class);
                //in.putExtra("some", "Mens Wears");
                startActivity(in);
            }
        });
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prdctname.add("STY Tee 1");
        prdctname.add("STY Tee 2");
        prdctname.add("Bracelet");
        prdctdesc.add("Black Cotton Hoodie \nProduct No. #36251");
        prdctdesc.add("Cotton Shirt \nProduct No. #36251");
        prdctdesc.add("Black bracelet \nProduct No. #36251");
        prdctprice.add(price1 + "/- Rs");
        prdctprice.add(price2 + "/- Rs");
        prdctprice.add(price3 + "/- Rs");
        prdctimg.add(R.drawable.menhodies);
        prdctimg.add(R.drawable.womenmodle);
        prdctimg.add(R.drawable.acsesories);
    }
}