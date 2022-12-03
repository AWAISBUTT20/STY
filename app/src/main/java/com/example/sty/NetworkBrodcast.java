package com.example.sty;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.sty.databinding.NoInternetConnectionBinding;

public class NetworkBrodcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!isConnected(context)) {
            NoInternetConnectionBinding binding=NoInternetConnectionBinding
                    .inflate(LayoutInflater.from(context));
            AlertDialog.Builder builder=new AlertDialog.Builder(context);
            builder.setView(binding.getRoot());
            builder.setCancelable(false);
            Dialog dialog=builder.create();
            dialog.show();
            binding.btntryagain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isConnected(context)) {
                        dialog.dismiss();
                    }else {
                        Toast.makeText(context,"No Internet !",Toast.LENGTH_LONG).show();
                    }
                }
            });

        } else {
        }
    }
    private boolean isConnected(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            return networkInfo != null && networkInfo.isConnected();
        }catch (Exception e){
        e.printStackTrace();
            return false;
        }
    }
}
