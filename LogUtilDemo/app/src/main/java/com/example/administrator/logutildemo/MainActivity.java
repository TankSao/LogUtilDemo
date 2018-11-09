package com.example.administrator.logutildemo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT >= 23){
            requestAllPower();
        }
    }
    public void requestAllPower() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                                Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS}, 1);
            }
        }
    }

    @OnClick({R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,R.id.btn5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                LogUtil.getInstance(this).LogError("unsaved","不保存日志打印",false);
                break;
            case R.id.btn2:
                LogUtil.getInstance(this).LogError("saved","保存日志打印",true);
                break;
            case R.id.btn3:
                LogUtil.getInstance(this).shortToast("这是短的吐司");
                break;
            case R.id.btn4:
                LogUtil.getInstance(this).longToast("这是长的吐司");
                break;
            case R.id.btn5:
                startActivity(new Intent(this,LogActivity.class));
                break;
        }
    }

}
