package com.example.sty;

import static com.example.sty.R.drawable.menhodies;
import static com.example.sty.R.drawable.mentees;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Userprofile extends Fragment {

    public Userprofile() {
        // Required empty public constructor
    }
    TextView txt;
    BroadcastReceiver broadcastReceiver;
    FirebaseAuth firebaseAuth;
    String usrname;
    Button btn;
    ImageView iv;

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);
        txt = view.findViewById(R.id.txtusrname);
        iv = view.findViewById(R.id.imgprofil);
        iv.setImageResource(menhodies);
        firebaseAuth = FirebaseAuth.getInstance();
        btn = view.findViewById(R.id.btnlogout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    broadcastReceiver = new NetworkBrodcast();
                    getActivity().registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
                    new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("Logout")
                            .setContentText("Are You sure?")
                            .setConfirmText("Logout")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    firebaseAuth.signOut();
                                    sDialog.dismissWithAnimation();
                                    startActivity(new Intent(getActivity(), MainActivity.class));
                                }
                            })
                            .setCancelButton("Cancel", new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    sDialog.dismissWithAnimation();
                                }
                            })
                            .show();
                }
            }
        });
        SignUp signUp = new SignUp();
        usrname = signUp.getuser();
        txt.setText(usrname);
        return view;


    }
}