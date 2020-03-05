package com.JHOS.rollschedule;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.google.android.material.tabs.TabLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;

//pagerAdapter를 설정하는 곳

public class PagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<String> text = new ArrayList<String>(); //tab 안에 들어갈 텍스트를 저장하는 리스트

    private ArrayList<Fragment> items = new ArrayList<>(); //tab 의 view pager 에 들어갈 프레그먼트를 저장하는 리스트

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        text.add("하루 일정");//하루 일정 text 추가
        text.add("한달 일정");//한달 일정 text 추가
        text.add("설정");//설정 text 추가
    }

    public void addItem(Fragment item){
        items.add(item);//tab 의 view pager 에 들어갈 프레그먼트를 추가
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return items.get(position);//position 에 들어온 값에 따라서 맞는 프레그먼트를 반환
    }

    @Override
    public int getCount() {
        return items.size();//tab 의 갯수를 item 의 크기 만큼  반환
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return text.get(position);//tab 에 맞는 텍스트를 반환
    }
}
