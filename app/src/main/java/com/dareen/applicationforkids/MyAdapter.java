package com.dareen.applicationforkids;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyAdapter extends FragmentStateAdapter {
    public MyAdapter( FragmentManager fragmentManager,  Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);

    }


    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0: return new AlphapetFragment();
            case 1: return new AnimalFragment() ;
            case 2: return new FruitFragment();
            case 3 : return new QuizFragment();
        }


        return new  AlphapetFragment();


    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
