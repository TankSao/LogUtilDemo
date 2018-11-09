package com.example.administrator.logutildemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/11/9.
 */

public class LogDao {
    public static final String TABLE_NAME = "records";//表名

    private static final String ID = "id";
    private static final String TAG = "tag";
    private static final String MSG = "msg";
    private static final String TIME = "create_time";
    private static final String APP = "app_name";
    private LogHelper dbHelper;
    public static final String SQL_CREATE_TABLE = "create table " + TABLE_NAME + "(" +
            ID + " integer primary key," +
            TAG + " varchar(50)," +
            MSG + " varchar(50)," +
            TIME + " varchar(50)," +
            APP + " varchar(50)" +
            ")";

    public LogDao(Context context) {
        dbHelper = new LogHelper(context);
    }

    public static LogDao getInstance(Context context) {
        return new LogDao(context);
    }
    //新增日志
    public void insert(LogBean bean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TAG, bean.getTag());
        cv.put(MSG, bean.getMsg());
        cv.put(TIME, bean.getTime());
        cv.put(APP, bean.getApp());
        db.insert(TABLE_NAME, null, cv);
        db.close();
    }
    //清空日志
    public void clearAll() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + TABLE_NAME;

        try {
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
    public void clear(LogBean bean) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "delete from " + TABLE_NAME + " where tag = '" + bean.getTag()+"' and msg = '"+bean.getMsg()+"' and create_time = '"+bean.getTime()+"' and app_name = '"+bean.getApp()+"'";
        try {
            db.execSQL(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
    public List<LogBean> queryAll() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        List<LogBean> list = new ArrayList<>();
        Cursor cursor = db.rawQuery("select * from " + TABLE_NAME +"" ,null);
        for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()) {
            LogBean bean= new LogBean(cursor.getString(cursor.getColumnIndex(TAG)),cursor.getString(cursor.getColumnIndex(MSG)),cursor.getString(cursor.getColumnIndex(TIME)),cursor.getString(cursor.getColumnIndex(APP)));
            list.add(bean);
        }
        if (cursor != null) {
            cursor.close();
        }
        if (db != null) {
            db.close();
        }
        return list;
    }
}
