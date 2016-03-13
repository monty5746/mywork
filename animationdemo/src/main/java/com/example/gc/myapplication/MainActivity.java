package com.example.gc.myapplication;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private  ImageView imageView;
    private  ImageView imageView1;
    private AnimationDrawable animationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
        imageView = (ImageView)findViewById(R.id.imageView);
        //帧动画
        imageView1 = (ImageView)findViewById(R.id.imageView2);
        animationDrawable = (AnimationDrawable)imageView1.getBackground();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
            animationDrawable.start();
            //停止
            //mAd.stop();
            //只播放一次
            //mAd.setOneShot(true);
        }
        super.onWindowFocusChanged(hasFocus);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                testAlpha();
                break;
            case R.id.button2:
                testScale();
                break;
            case R.id.button3:
                testTranslate();
                break;
            case R.id.button4:
                testRotate();
                break;
            case R.id.button5:
                //窗口跳转
                Intent intent = new Intent(this, SecendActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in, R.anim.left_out);

                break;
            case R.id.button6:
                if(animationDrawable.isRunning()){
                     animationDrawable.stop();
                }
                else{
                     animationDrawable.start();
                }
                break;
        }
    }
    //透明度Alpha
    private  void testAlpha(){
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(3000);
        imageView.startAnimation(alphaAnimation);
    }
    //尺寸Scale
    private void testScale(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.anim_scale);
        imageView.startAnimation(animation);
    }
    //移动
    private void testTranslate()
    {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);

        //设置动画重复的次数
        //animation.setRepeatCount(3);
        /*
         * 1.LinearInterpolator：默认，线性播放即匀速播放
            2.AccelerateInterpolator：加速播放
            3.DecelerateInterpolator：减速播放
            4.AccelerateDecelerateInterpolator：先加速后减速播放
            5.CycleInterpolator：循环播放
         */
        animation.setInterpolator(new AccelerateInterpolator());

        imageView.startAnimation(animation);
    }
    /*
     * 旋转
     */
    private void testRotate()
    {
        /*
         * 参数一：开始时的角度
         * 参数二：结束时的角度
         * 参数三：x方向相对xxx旋转
         * 参数四：x方向的位置 0最左边  1最右边
         * 参数五：y方向相对xxx旋转
         * 参数六：y方向的位置 0最上边 1最下边
         */
    /*    RotateAnimation animation = new RotateAnimation(0f, 360f,Animation.RELATIVE_TO_SELF, 0.5f,  Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(1000);

        animation.setRepeatCount(10);
        animation.setRepeatMode(Animation.REVERSE);*/
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        imageView.startAnimation(animation);
    }

}
