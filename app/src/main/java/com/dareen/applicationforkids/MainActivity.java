package com.dareen.applicationforkids;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    String TabTitle[] = {"Alphapets","Animal","Fruit","Quiz"};
    SharedPreferences preferences ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        TabLayout t1 = findViewById(R.id.tabLayout);
        ViewPager2 pager = findViewById(R.id.viewPager2);
        pager.setOffscreenPageLimit(4);

        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),getLifecycle()));

        TabLayoutMediator tm = new TabLayoutMediator(t1, pager, true,
                (tab, position) -> {
                    tab.setText(TabTitle[position]);
                });
        tm.attach();
    }


}
