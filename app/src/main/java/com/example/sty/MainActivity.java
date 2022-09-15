package com.example.sty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private StorageReference storageReference;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

storageReference= FirebaseStorage.getInstance().getReference("Sty/tw8.jpg");
        try {
            final File localfile = File.createTempFile("tw8","jpg");
       storageReference.getFile(localfile).addOnSuccessListener(new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
           @Override
           public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
               Toast.makeText(MainActivity.this, "Picture Retrieved", Toast.LENGTH_SHORT).show();
               Bitmap bitmap= BitmapFactory.decodeFile(localfile.getAbsolutePath());
               ((ImageView)findViewById(R.id.btnacsesori)).setImageBitmap(bitmap);
           }
       }).addOnFailureListener(new OnFailureListener() {
           @Override
           public void onFailure(@NonNull Exception e) {
               Toast.makeText(MainActivity.this, "Retrieve Error", Toast.LENGTH_SHORT).show();
           }
       });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}