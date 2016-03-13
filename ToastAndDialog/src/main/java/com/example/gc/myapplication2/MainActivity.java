package com.example.gc.myapplication2;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.button4).setOnClickListener(this);
        findViewById(R.id.button5).setOnClickListener(this);
        findViewById(R.id.button6).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                testToast();
                break;
            case R.id.button2:
                testDialog1();
                break;
            case R.id.button3:
                testDialog2();
                break;
            case R.id.button4:
                testDate();
                break;
            case R.id.button5:
                testDialog3();
                break;
            case R.id.button6:
                testMyDialog();
                break;

        }
    }
    //自定义吐司
    private void testToast(){
        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        ImageView iView = new ImageView(this);
        iView.setImageResource(R.mipmap.ic_launcher);
        toast.setView(iView);
        toast.show();
    }
    //dialog
    private  void testDialog1(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("你确定删除吗？").setMessage("你真的确定删除吗？");
        builder.setIcon(R.mipmap.ic_launcher);

        builder.setNegativeButton("取消", onClickListener);
        builder.setPositiveButton("确定", onClickListener);
        builder.setNeutralButton("忽略", onClickListener);

        builder.show();
    }
    //dialog监听
    private DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch (which){
                case  DialogInterface.BUTTON_POSITIVE:
                    ToastUtil.show(MainActivity.this,"你选择了确定");
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    ToastUtil.show(MainActivity.this,"你选择了取消");
                    break;
                case DialogInterface.BUTTON_NEUTRAL:
                    Toast.makeText(MainActivity.this,"你选择了忽略",Toast.LENGTH_SHORT).show();
//                    ToastUtil.show(MainActivity.this,"你选择了忽略");
                    break;
            }
        }
    };
    //单选dialog
    private void testDialog2(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择你所在的城市");
        final String[] citys = getResources().getStringArray(R.array.citys);
        builder.setItems(citys, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(MainActivity.this,"你选择了"+citys[which]);
            }
        });
        builder.show();
    }
    //日期
    private  void testDate(){
        DatePickerDialog dialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                ToastUtil.show(MainActivity.this,"你选择了"+year+"年"+(monthOfYear+1)+"月"+dayOfMonth+"日");
            }
        },2016,2,7);
        dialog.show();
    }
    //多选Dialog
    private  void testDialog3(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择城市");
        final String[] citys = getResources().getStringArray(R.array.citys);
        final List<String> selectedCitys = new ArrayList<>();
        builder.setMultiChoiceItems(citys, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    selectedCitys.add(citys[which]);
                } else {
                    selectedCitys.remove(citys[which]);
                }
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(MainActivity.this, selectedCitys.toString());
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(MainActivity.this, "你没有选择任何城市");
            }
        });

        builder.show();

    }
    //自定义Dialog
    private  void testMyDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //将布局加载成为view
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.toast_content,null);

        builder.setView(view);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(MainActivity.this, "您提交了账号密码");
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.show(MainActivity.this,"您取消了账号密码的提交！");
            }
        });
         builder.show();
    }
}

