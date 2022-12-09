package com.example.sty;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class Accessories extends AppCompatActivity {
    VideoView videoview;
    String vidpath;
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accessories);
        videoview=findViewById(R.id.accsesoriesvid);
        vidpath="android.resource://"+getPackageName()+"/"+R.raw.acsesoryvid;
        uri=Uri.parse(vidpath);
        videoview.setVideoURI(uri);
        //for play and pause manually
      /*  MediaController mediaController=new MediaController(this);
        videoview.setMediaController(mediaController);
        mediaController.setAnchorView(videoview);*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        videoview.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
            }
        });

        //if you want video was play again and again
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }
}