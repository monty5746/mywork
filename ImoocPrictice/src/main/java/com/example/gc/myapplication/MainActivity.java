package com.example.gc.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化控件
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);
        imageView = (ImageView)findViewById(R.id.imageView);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //buttonView 代表被点击控件本身
                //isChecked 代表被点击控件的状态
                imageView.setBackgroundResource(isChecked?R.drawable.mxp2:R.drawable.smile);
            }
        });
    }
}
