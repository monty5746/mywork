package com.example.administrator.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class LoginActivity extends Activity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        findViewById(R.id.imageButton1).setOnClickListener(this);
        findViewById(R.id.imageButton2).setOnClickListener(this);
        findViewById(R.id.imageButton3).setOnClickListener(this);
        findViewById(R.id.imageButton4).setOnClickListener(this);
        findViewById(R.id.imageButton5).setOnClickListener(this);
        findViewById(R.id.imageButton6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton1:
                break;
            case R.id.imageButton2:
                break;
            case R.id.imageButton3:
                break;
            case R.id.imageButton4:
                break;
            case R.id.imageButton5:
                aboutGame();
                break;
            case R.id.imageButton6:

                exitGame();
                break;
        }
    }
    //关于游戏
    private void aboutGame(){
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.about).setTitle("关于游戏").setMessage("版权所有！谢谢试玩！");
        builder.setNeutralButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
    //退出游戏
    private void exitGame(){
        AlertDialog.Builder builder =  new AlertDialog.Builder(this);
        builder.setTitle("退出游戏").setMessage("确定要退出游戏吗？").setIcon(R.drawable.about);
        builder.setNegativeButton("返回", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("退出", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
    }
}
