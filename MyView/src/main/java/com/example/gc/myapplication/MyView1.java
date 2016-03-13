package com.example.gc.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gc on 2016/3/10.
 */
public class MyView1 extends View{
    private final static int[] i = {R.drawable.smile,R.drawable.aa,R.drawable.yj1};
    private  int mIndex;
    private Paint mPaint;
    private Bitmap mBitmap;

    public MyView1(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyView1(Context context) {
        super(context);
        init();
    }
    private void init(){
        mPaint = new Paint();
        mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.smile);
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mIndex++;

                if(mIndex>2) {
                    timer.cancel();
                    return;
                }
                mBitmap= BitmapFactory.decodeResource(getResources(),i[mIndex]);
                postInvalidate();
            }
        },2000,2000);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap,0,0,mPaint);
        super.onDraw(canvas);
    }
}
