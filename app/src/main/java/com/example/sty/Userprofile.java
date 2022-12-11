package com.example.sty;

import static com.example.sty.R.drawable.menhodies;
import static com.example.sty.R.drawable.mentees;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
    FirebaseFirestore db=FirebaseFirestore.getInstance();
    DocumentReference documentReference;

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
        //featching data from fire store
        documentReference=db.document("User/User_1");
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String username = documentSnapshot.getString("User Name");
                            //String email = documentSnapshot.getString("Email");
                            txt.setText(username);
                        }else {
                            Toast.makeText(getContext(), "FireStore Fetching Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "FireStore Fetching Error", Toast.LENGTH_SHORT).show();

                    }
                });
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
       /* SignUp signUp = new SignUp();
        usrname = signUp.getuser();
        txt.setText(usrname);*/
        return view;


    }
}