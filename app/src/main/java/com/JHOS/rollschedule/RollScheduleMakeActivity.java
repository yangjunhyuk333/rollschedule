package com.JHOS.rollschedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class RollScheduleMakeActivity extends AppCompatActivity {

    //전역 변수 선언부
    FragmentManager fragmentManager;

    //원형 시간표를 만드는 엑티비티

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll_schedule_make);

        //fragment 추가 하는 부분
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, new RollScheduleMakeFragment());
        fragmentTransaction.commit();



    }
}
