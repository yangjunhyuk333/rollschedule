package com.JHOS.rollschedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.JHOS.rollschedule.R;

import java.text.SimpleDateFormat;
import java.util.Date;

//하루 일정을 출력하는 프레그먼트

public class TodayFragment extends Fragment {

    //전역변수 선언부
    ImageView imageButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.today_fragment, container, false);

        imageButton = (ImageView) view.findViewById(R.id.imageButton);

        //이미지 뷰를 터치하면 시간표를 만드는 엑티비티로 이동(intent)
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RollScheduleMakeActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}