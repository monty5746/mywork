package com.example.administrator.myapplication.Util;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/3/9 0009.
 */
public class ToastUtil  {
    private  static  Toast toast;

    public static void show(Context context,String text){
        if(toast==null){
            toast=Toast.makeText(context,"",Toast.LENGTH_SHORT);
        }
        toast.setText(text);
        toast.show();
    }
}
