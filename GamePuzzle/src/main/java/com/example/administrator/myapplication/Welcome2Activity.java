package com.example.administrator.myapplication;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Welcome2Activity extends Activity {

    public static Welcome2Activity welcome2Activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        welcome2Activity = this;

    }
    public  void startNewActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

}
