package com.example.gc.myapplication2;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by gc on 2016/3/8.
 */
public class ToastUtil {
    private static Toast toast;
    public static  void show(Context context,String msg){
        if(toast == null){
            toast = Toast.makeText(context,"",Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}
