package com.dareen.applicationforkids;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AlphapetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alphapet);

        String name = getIntent().getStringExtra("name").toLowerCase();
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        ImageView iv = findViewById(R.id.imageView);

        int iid = getResources().getIdentifier(name,"drawable",getPackageName());
        iv.setImageResource(iid);

        int mid = getResources().getIdentifier(name,"raw",getPackageName());
        MediaPlayer mp =MediaPlayer.create(getApplicationContext(),mid);
        mp.start();
    }
}