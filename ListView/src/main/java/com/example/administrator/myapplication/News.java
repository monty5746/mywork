package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2016/3/14 0014.
 */
public class News {
    private int picId;
    private String title;
    private String desc;

    public News(int picId, String title, String desc) {
        this.picId = picId;
        this.title = title;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPicId() {
        return picId;
    }

    public void setPicId(int picId) {
        this.picId = picId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
