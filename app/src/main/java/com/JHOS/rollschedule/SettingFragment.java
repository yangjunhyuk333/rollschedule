package com.JHOS.rollschedule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.JHOS.rollschedule.R;

//설정을 할 수 있게 해주는 프레그먼트

//설정: 테마(올해의 색) 사용/사용 안함, 알림 설정(알림 음악, 효과음, 진동, 무음), 다크 모드 사용/사용안함

public class SettingFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment, container, false);
        return view;
    }
}
