package com.example.sty;

import static android.widget.Toast.LENGTH_SHORT;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Userprofile extends Fragment {

    public Userprofile() {
        // Required empty public constructor
    }
    TextView txt;
    BroadcastReceiver broadcastReceiver;
    FirebaseAuth firebaseAuth;
    String usrname;
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);
        txt = view.findViewById(R.id.txtusrname);
        firebaseAuth=FirebaseAuth.getInstance();
        btn=view.findViewById(R.id.btnlogout);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {
                    firebaseAuth.signOut();
                }
            }
        });
        /*broadcastReceiver=new NetworkBrodcast();
       registerReceiver(broadcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));  NetworkBrodcast networkBrodcast=new NetworkBrodcast();
        */
        if (getArguments() != null) {
            usrname=getArguments().getString("user");
        }
        txt.setText(usrname);
        return view;
    }

  /*  @Override
    public void onStart() {
        super.onStart();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        if (firebaseUser == null) {
            return;
        }
    }*/
    public void logout(View view) {
        firebaseAuth.signOut();
    }
}