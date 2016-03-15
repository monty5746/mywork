package com.example.administrator.myapplication;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class DownloadActivity extends Activity {
    private ImageView mImageView;
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            switch (msg.what){
                case 1:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    mImageView.setImageBitmap(bitmap);
                    break;
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_activity);

        mImageView = (ImageView) findViewById(R.id.imageView);

        new Thread(new Runnable() {
            @Override
            public void run() {
                String path = "http://192.168.1.168/myapp/i.jpg";
                try {
                    URL url = new URL(path);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("Get");
                    connection.setConnectTimeout(5000);
                    if(connection.getResponseCode() == 200){
                        InputStream is = connection.getInputStream();
                        Bitmap bitmap = BitmapFactory.decodeStream(is);
                        Message msg = Message.obtain(mHandler,1,bitmap);
                        mHandler.sendMessage(msg);
                        is.close();
                    }
                    connection.disconnect();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
