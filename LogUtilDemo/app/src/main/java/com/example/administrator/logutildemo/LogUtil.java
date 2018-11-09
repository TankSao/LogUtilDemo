package com.example.administrator.logutildemo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/9.
 */

public class LogUtil {
    private Context context;
    public LogUtil(Context context){
        this.context = context;
    }
    public static LogUtil getInstance(Context context){
        LogUtil logUtil = new LogUtil(context);
        return logUtil;
    }
    public void LogInfo(String tag,String msg,boolean save){
        Log.i(tag,msg);
        if(save){
            //保存日志
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time = format.format(new Date());
            LogDao.getInstance(context).insert(new LogBean(tag,msg,time,getAppName(context)));
        }
    }
    public void LogVerbose(String tag,String msg,boolean save){
        Log.v(tag,msg);
        if(save){
            //保存日志
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time = format.format(new Date());
            LogDao.getInstance(context).insert(new LogBean(tag,msg,time,getAppName(context)));
        }
    }
    public void LogDebug(String tag,String msg,boolean save){
        Log.d(tag,msg);
        if(save){
            //保存日志
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time = format.format(new Date());
            LogDao.getInstance(context).insert(new LogBean(tag,msg,time,getAppName(context)));
        }
    }
    public void LogWarn(String tag,String msg,boolean save){
        Log.w(tag,msg);
        if(save){
            //保存日志
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time = format.format(new Date());
            LogDao.getInstance(context).insert(new LogBean(tag,msg,time,getAppName(context)));
        }
    }
    public void LogError(String tag,String msg,boolean save){
        Log.e(tag,msg);
        if(save){
            //保存日志
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String time = format.format(new Date());
            LogDao.getInstance(context).insert(new LogBean(tag,msg,time,getAppName(context)));
        }
    }
    public void shortToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_SHORT).show();
    }
    public void longToast(String msg){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show();
    }
    public void LookLogs(){

    }

    public String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
