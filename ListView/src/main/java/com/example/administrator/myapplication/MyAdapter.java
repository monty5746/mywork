package com.example.administrator.myapplication;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/3/14 0014.
 */
public class MyAdapter extends BaseAdapter {
    private List<News> mNewsList;
    public MyAdapter(List<News> newsList){
        mNewsList = newsList;
    }
    @Override
    public int getCount() {
        return mNewsList.size();
    }

    @Override
    public News getItem(int position) {
        return mNewsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //每一条内容什么样子
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
