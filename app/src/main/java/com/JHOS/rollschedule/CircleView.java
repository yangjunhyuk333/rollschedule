package com.JHOS.rollschedule;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class CircleView extends View {

    private Paint paintWhite;
    private Paint paintBlack;

    float X;
    float Y;

    public CircleView(Context context) {
        super(context);

        init(context);
    }

    public void setXY(float X, float Y){
        this.X = X;
        this.Y = Y;
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        paintWhite = new Paint();
        paintWhite.setColor(Color.WHITE);
        paintBlack = new Paint();
        paintBlack.setColor(Color.BLACK);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paintBlack.setAntiAlias(true);
        paintWhite.setAntiAlias(true);
        canvas.drawCircle(X, Y, 13, paintBlack);
        canvas.drawCircle(X, Y, (float) 12.5, paintWhite);
    }
}
