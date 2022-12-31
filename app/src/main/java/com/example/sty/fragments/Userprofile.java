package com.example.sty.fragments;

import static android.app.Activity.RESULT_OK;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sty.services.NetworkBrodcast;
import com.example.sty.R;
import com.example.sty.activity.MainActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Userprofile extends Fragment {

    public Userprofile() {
        // Required empty public constructor
    }

    TextView txt;
    BroadcastReceiver broadcastReceiver;
    Animation bottom;
    FirebaseAuth firebaseAuth;
    Button btn, btn2;
    ImageView iv;
    Bitmap bitmap;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @SuppressLint({"ResourceType", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_userprofile, container, false);
        bottom= AnimationUtils.loadAnimation(getContext(),R.anim.bottom_animation);
        featchfirestore();
        txt = view.findViewById(R.id.txtusrname);
        iv = view.findViewById(R.id.imgprofil);
        btn2 = view.findViewById(R.id.btnchange);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK);
                gallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, 1);

            }
        });
        firebaseAuth = FirebaseAuth.getInstance();
        btn = view.findViewById(R.id.btnlogout);
        btn.setAnimation(bottom);
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
        return view;
    }

    public void featchfirestore() {
        //featching data from fire store(UserName)
        DocumentReference documentReference = db.document("User/User_1");
        documentReference.get()
                .addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        if (documentSnapshot.exists()) {
                            String username = documentSnapshot.getString("User Name");
                            //String email = documentSnapshot.getString("Email");
                            txt.setText(username);
                        } else {
                            Toast.makeText(getContext(), "FireStore Fetching Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getContext(), "FireStore Fetching Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    //gallery picture
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            Uri selectimage = data.getData();
            iv.setImageURI(selectimage);
        }

    }
}