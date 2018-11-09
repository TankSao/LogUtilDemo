package com.example.administrator.logutildemo;

/**
 * Created by Administrator on 2018/11/9.
 */

public class LogBean {
    private String tag;
    private String msg;
    private String time;
    private String app;

    public LogBean(String tag, String msg, String time, String app) {
        this.tag = tag;
        this.msg = msg;
        this.time = time;
        this.app = app;
    }

    public LogBean() {
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }
}
