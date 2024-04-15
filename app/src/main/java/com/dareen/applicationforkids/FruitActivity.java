package com.dareen.applicationforkids;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FruitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fruit);

        String name = getIntent().getStringExtra("name").toLowerCase();
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
       ImageView iv = findViewById(R.id.imageview2);

       int iid = getResources().getIdentifier(name,"drawable",getPackageName());
       iv.setImageResource(iid);

        int mid = getResources().getIdentifier(name,"raw",getPackageName());
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), mid);
        mp.start();


    }
}