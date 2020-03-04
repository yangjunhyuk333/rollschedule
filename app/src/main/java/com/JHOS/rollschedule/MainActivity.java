package com.JHOS.rollschedule;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TodayFragment todayFragment;
    MonthFragment monthFragment;
    SettingFragment settingFragment;
    PagerAdapter pagerAdapter;
    TabLayout.Tab tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.bottomTabLayout);
        viewPager = findViewById(R.id.viewPager);

        viewPager.setOffscreenPageLimit(3);

        todayFragment = new TodayFragment();
        monthFragment = new MonthFragment();
        settingFragment = new SettingFragment();

        pagerAdapter = new PagerAdapter(getSupportFragmentManager()
                , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        pagerAdapter.addItem(todayFragment);
        pagerAdapter.addItem(monthFragment);
        pagerAdapter.addItem(settingFragment);

        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);

        ArrayList<Integer> images = new ArrayList<Integer>();

        images.add(R.drawable.todayxxxhdpi);
        images.add(R.drawable.monthxxxhdpi);
        images.add(R.drawable.settingxxxhdpi);

        for(int i = 0; i < 3; i++){
            tab = tabLayout.getTabAt(i).setIcon(images.get(i));

        }
    }
}
