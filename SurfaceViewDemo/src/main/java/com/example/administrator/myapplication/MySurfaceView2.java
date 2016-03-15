package com.example.administrator.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class MySurfaceView2 extends SurfaceView implements Runnable,SurfaceHolder.Callback{

    private Bitmap mBitmap;

    private boolean mIsRun = true;
    private SurfaceHolder mHolder;
    private Paint mPaint;
    private Thread mThread;
    //Bitmap在屏幕中的位置
    private float touchX ;
    private float touchY ;

    public MySurfaceView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView2(Context context) {
        super(context);
        init();
    }

    private void init(){
        //创建笔
        mPaint = new Paint();
        //拿到控制器
        mHolder = getHolder();
        //创建线程
        mThread = new Thread(this);
        //拿到回调事件
        mHolder.addCallback(this);

        mBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        touchX = mBitmap.getWidth()/2;
        touchY = mBitmap.getWidth()/2;
    }
    //surfaceView创建成功后
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mThread.start();
    }
    //suifaceView改变时
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }
    //surfaceView销毁时
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsRun = false;
    }
    @Override
      public void run() {
        while (mIsRun){
            //负责数据更新
            update();
            //负责数据绘制
            paint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void update() {

    }
    private void paint() {
        Canvas canvas = null;
        try
        {
            //锁定画布
            canvas = mHolder.lockCanvas();
            if(canvas!=null)
            {
                //将画布涂黑
                canvas.drawColor(Color.YELLOW);
                //绘制数据
                canvas.drawBitmap(mBitmap, getWidth()/2, touchY-mBitmap.getHeight()/2, mPaint);
            }
        }
        catch (Exception e)
        {
        }
        finally
        {
            if(canvas!=null)
            {
                //解锁画布并且提交数据
                mHolder.unlockCanvasAndPost(canvas);
            }
        }
    }


}
