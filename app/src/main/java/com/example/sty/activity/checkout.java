package com.example.sty.activity;

import static com.example.sty.fragments.Cart.sum;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sty.R;

public class checkout extends AppCompatActivity {
Button btn;
TextView txt1,txt2,txt3;
public static int dc,total;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        getWindow().setStatusBarColor(Color.BLACK);
        txt1=findViewById(R.id.delivierycharges);
        dc=200;
        txt1.setText(dc+"/- PKR");
        txt2=findViewById(R.id.subtotal);
        txt2.setText(sum+"/- PKR");
        total=sum+dc;
        txt3=findViewById(R.id.nettotal);
        txt3.setText(total+"/- PKR");
        btn=findViewById(R.id.proceedtopayment);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(checkout.this, payment_method.class);
                startActivity(intent);
            }
        });

    }
}