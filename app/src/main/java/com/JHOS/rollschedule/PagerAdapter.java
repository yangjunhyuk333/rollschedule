package com.JHOS.rollschedule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> text = new ArrayList<String>();

    private ArrayList<Fragment> items = new ArrayList<>();

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        text.add("하루 일정");
        text.add("한달 일정");
        text.add("설정");

    }

    public void addItem(Fragment item){
        items.add(item);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return text.get(position);
    }
}
