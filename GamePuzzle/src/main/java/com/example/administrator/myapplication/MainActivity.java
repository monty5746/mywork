package com.example.administrator.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.administrator.myapplication.Util.ToastUtil;

public class MainActivity extends Activity {

    private ImageView imageView;
    private AnimationDrawable ad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置全屏  这两句话必须写在关联布局前

        setContentView(R.layout.activity_main);
        imageView = (ImageView)findViewById(R.id.imageView);
        ad = (AnimationDrawable)imageView.getBackground();

        ToastUtil.show(this,"欢迎进入游戏");

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {

        if(hasFocus){
            ad.start();
            new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    startActivity(new Intent(MainActivity.this,LoginActivity.class));
                    finish();
                }
            }).start();
        }

        super.onWindowFocusChanged(hasFocus);
    }
}
