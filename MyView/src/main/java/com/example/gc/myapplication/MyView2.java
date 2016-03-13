package com.example.gc.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gc on 2016/3/10.
 */
public class MyView2 extends View {
    private Paint mPaint;
    private RectF mRectF;
    public MyView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView2(Context context) {

        super(context);
        init();
    }
    private  void init(){
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mRectF = new RectF(0f,0f,500f,500f);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mAlpha+=1;
                mStartAngle+=1;
                postInvalidate();
            }
        },30,30);
    }
    private int mSweepAngle;//角度
    private int mStartAngle;//初始角度
    private int mAlpha;//亮度
    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.RED);
        mPaint.setAlpha(mAlpha);
        canvas.drawArc(mRectF, mStartAngle, 90, true, mPaint);
        mPaint.setColor(Color.GREEN);
        mPaint.setAlpha(mAlpha);
        canvas.drawArc(mRectF, mStartAngle + 90, 90, true, mPaint);
        mPaint.setColor(Color.YELLOW);
        mPaint.setAlpha(mAlpha);
        canvas.drawArc(mRectF, mStartAngle + 180, 90, true, mPaint);
        mPaint.setColor(Color.BLUE);
        mPaint.setAlpha(mAlpha);
        canvas.drawArc(mRectF,mStartAngle+270,90,true,mPaint);
        super.onDraw(canvas);
    }
}
