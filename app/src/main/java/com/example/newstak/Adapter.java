package com.example.newstak;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newstak.fragments.Entertainment;
import com.example.newstak.fragments.Health;
import com.example.newstak.fragments.Home;
import com.example.newstak.fragments.Science;
import com.example.newstak.fragments.Sports;

public class Adapter extends FragmentPagerAdapter {


    public Adapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0 : return new Home();
            case 1 : return new Sports();
            case 2 : return new Entertainment();
            case 3 : return new Science();
            case 4 : return new Health();
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
