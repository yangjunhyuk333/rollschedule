package com.JHOS.rollschedule;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

//원형 시간표를 만드는 프레그먼트

public class RollScheduleMakeFragment extends Fragment{

    //전역 변수 선언부

    ImageView imageView;

    ImageView imageButton;

    ImageView imageView2;

    ImageView viewPlusLine, viewPlusCircle;

    CircleView circleView;

    ConstraintSet constraintSet;

    ConstraintLayout constraintLayout;

    private boolean isMoveSlideButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.rollschedule_maker_fragment, container, false);

        imageView = (ImageView) view.findViewById(R.id.imageButtonplus);

        imageButton = (ImageView) view.findViewById(R.id.rollSchedule);

        viewPlusLine = (ImageView) view.findViewById(R.id.plusLine);
        viewPlusCircle = (ImageView) view.findViewById(R.id.plusCircle);

        constraintLayout = (ConstraintLayout) view.findViewById(R.id.constrain);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        imageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final float viewX = viewPlusCircle.getX();
                final float viewY = viewPlusCircle.getY();

                final int centerX = imageButton.getWidth() / 2;
                final int centerY = imageButton.getHeight() / 2;

                final PointF centerPoint = new PointF(centerX, centerY);
                final PointF viewPoint = new PointF(viewX, viewY);
                final PointF touchPoint = new PointF((int)event.getX(), (int)event.getY());

                int radius = imageButton.getHeight()/2 - 34;

                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_MOVE:
                            constraintSet.constrainCircle(R.id.plusCircle, R.id.rollSchedule, radius, (int) getAngle(touchPoint, centerPoint)+90);
                            constraintSet.applyTo(constraintLayout);
                }

                return true;
            }
        });

        viewPlusCircle.setClickable(false);

        circleView = new CircleView(getActivity().getApplicationContext());

        circleView.setXY(viewPlusCircle.getPivotX(), viewPlusCircle.getPivotY());

        //추가 버튼을 눌렀을 때 취할 행동
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPlusCircle.setImageResource(R.drawable.circle);
                imageView.setEnabled(false);
            }
        });

        return view;
    }

    //각도 구하는 메소드
    public double getAngle(PointF end, PointF start) {
        double dy = end.y-start.y;
        double dx = end.x-start.x;

        return Math.atan2(dy, dx) * (180.0 / Math.PI);
    }
}
