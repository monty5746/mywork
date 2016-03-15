package com.example.administrator.myapplication;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private TextView mTextTime;
    private final static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 1:
                    mTextTime.setText((String)msg.obj);
                    break;
            }
        };
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextTime = (TextView) findViewById(R.id.text_time);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                String time = sdf.format(date);
                //使用Handler将消息从子线程发往主线程
                //Message msg = new Message();
                Message msg = Message.obtain();
                msg.what = 1;//用来区分是谁发送的消息
                msg.obj = time;
                mHandler.sendMessage(msg);
            }
        }, 0, 1000);
    }
}
