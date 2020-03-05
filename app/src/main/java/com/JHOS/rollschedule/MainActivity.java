package com.JHOS.rollschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.JHOS.rollschedule.MonthFragment;
import com.JHOS.rollschedule.PagerAdapter;
import com.JHOS.rollschedule.R;
import com.JHOS.rollschedule.SettingFragment;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity {

    //전역 변수 선언부
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

        //tabLayout, viewPager id 찾아줌
        tabLayout = findViewById(R.id.bottomTabLayout);
        viewPager = findViewById(R.id.viewPager);

        //view pager 의 page 를 3개로 설정
        viewPager.setOffscreenPageLimit(3);

        //page 로 쓸 프레그먼트 객체 생성
        todayFragment = new TodayFragment();
        monthFragment = new MonthFragment();
        settingFragment = new SettingFragment();

        //pagerAdapter 객체 생성
        pagerAdapter = new PagerAdapter(getSupportFragmentManager()
                , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        //pagerAdapter 로 프레그먼트를 페이지에 추가
        pagerAdapter.addItem(todayFragment);
        pagerAdapter.addItem(monthFragment);
        pagerAdapter.addItem(settingFragment);

        //tab 마다 쓰일 이미지를 저장하는 리스트
        ArrayList<Integer> images = new ArrayList<Integer>();

        //image 를 리스트에 저장
        images.add(R.drawable.todayxxxhdpi);
        images.add(R.drawable.monthxxxhdpi);
        images.add(R.drawable.settingxxxhdpi);

        //view pager 의 adapter 를 pager adapter 로 설정
        viewPager.setAdapter(pagerAdapter);

        //tab layout 의 pager 를 view pager 로 설정
        tabLayout.setupWithViewPager(viewPager);

        //각 tab 에 아이콘을 리스트 안에 사진으로 설정
        for(int i = 0; i < 3; i++){
            tabLayout.getTabAt(i);
            tab = tabLayout.getTabAt(i).setIcon(images.get(i));
        }
    }
}