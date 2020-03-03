package com.fastcampus.rollschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    TodayFragment todayFragment;
    MonthFragment monthFragment;
    SettingFragment settingFragment;
    PagerAdapter pagerAdapter;

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

        for(int i = 0; i < 3; i++){
            tabLayout.getTabAt(i);
        }
    }
}
