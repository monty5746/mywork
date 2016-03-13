package com.example.gc.myapp;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    //定义一个借口类型的成员变量
    private View.OnClickListener onClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    startActivity(new Intent(MainActivity.this,SecendActivity.class));
                    break;
                case R.id.button2:
                    startActivity(new Intent(MainActivity.this,ThirdActivity.class));
                    break;

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //找到控件
        Button bt1 = (Button)findViewById(R.id.button1);
        Button bt2 = (Button)findViewById(R.id.button2);

        //事件监听
        bt1.setOnClickListener(onClickListener);
        bt2.setOnClickListener(onClickListener);

    }

    /*@Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            System.out.println("点击了一下屏幕");
            startActivity(new Intent(MainActivity.this, SecendActivity.class));
        }
        return super.onTouchEvent(event);
    }
    */
}
