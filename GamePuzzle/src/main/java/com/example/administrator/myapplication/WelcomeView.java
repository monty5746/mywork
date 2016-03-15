package com.example.administrator.myapplication;

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
 * Created by Administrator on 2016/3/10 0010.
 */
public class WelcomeView extends View{

    private final  static int[] logImages = {R.drawable.b1,R.drawable.b2,R.drawable.b3};
    private Bitmap[] mBitmap;
    private int index;

    private Paint mPaint;

    public WelcomeView(Context context) {
        super(context);
        init();
    }

    public WelcomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private  void init(){
        mBitmap = new Bitmap[logImages.length];
        mPaint = new Paint();

        for (int i = 0; i <3 ; i++) {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(),logImages[i]);
            mBitmap[i]=bitmap;
        }
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                index++;
                if(index>2){
                    timer.cancel();
                    Welcome2Activity.welcome2Activity.startNewActivity();
                    return;
                }
                postInvalidate();
            }
        }, 2000, 2000);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap[index],0,0,mPaint);
        super.onDraw(canvas);

    }
}
