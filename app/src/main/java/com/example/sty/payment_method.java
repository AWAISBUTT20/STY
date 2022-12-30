package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class payment_method extends AppCompatActivity {
Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);
        getWindow().setStatusBarColor(Color.BLACK);
        btn=findViewById(R.id.finalpayment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(payment_method.this, SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Transaction Successfully")
                        .setContentText("Thanks for shopping")
                        .setConfirmText("Continue Shopping")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();
                                startActivity(new Intent(payment_method.this,MainActivity.class));
                            }
                        }).show();
            }
        });
    }
}