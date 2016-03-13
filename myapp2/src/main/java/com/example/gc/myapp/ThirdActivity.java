package com.example.gc.myapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by gc on 2016/3/1.
 */
public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        imageView = (ImageView)findViewById(R.id.imageView);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button1:
                if(imageView.isShown()){
                    imageView.setVisibility(View.INVISIBLE);
                    button1.setText("显示");
                }
                else{
                    imageView.setVisibility(View.VISIBLE);
                    button1.setText("隐藏");
                }
                break;
            case R.id.button2:
                finish();
        }
    }
}
