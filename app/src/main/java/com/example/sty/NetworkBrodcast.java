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

import androidx.activity.result.contract.ActivityResultContracts;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class NetworkBrodcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (!isConnected(context)) {
            new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("No Internet Connection")
                    .setContentText("Connect for Authentication")
                    .setConfirmText("Reconnect")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                                    if (!isConnected(context)) {
                                        Toast.makeText(context,"No Connection !",Toast.LENGTH_LONG).show();
                                    }else {
                                        sDialog.dismissWithAnimation();
                                    }
                                }
                    })
                    .setCancelButton("Later", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
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
