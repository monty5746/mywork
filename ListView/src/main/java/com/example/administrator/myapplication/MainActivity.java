package com.example.administrator.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<HashMap<String ,String>> mList = new ArrayList<>();
    private String[] mFrom = {"name","sex","age"};
    private int[] mTo = {R.id.name,R.id.sex,R.id.age};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataInit();
        //simpleAdapter 实现过程
        ListView mListView = (ListView)findViewById(R.id.listView1);
        ListAdapter mAdapter = new SimpleAdapter(this,mList,R.layout.list_item1,mFrom,mTo);
        mListView.setAdapter(mAdapter);
    }
    private void dataInit(){
        HashMap<String,String> mHashMap = new HashMap<>();
        mHashMap.put("name","张三");
        mHashMap.put("sex","男");
        mHashMap.put("age","20");
        mList.add(mHashMap);
    }
}
