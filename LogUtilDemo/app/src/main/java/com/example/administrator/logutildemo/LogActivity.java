package com.example.administrator.logutildemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/9.
 */

@SuppressLint("Registered")
public class LogActivity extends AppCompatActivity{
    @BindView(R.id.listview)
    ListView listView;
    private List<LogBean> mList = new ArrayList();
    private LogAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);
        mList = LogDao.getInstance(this).queryAll();
        adapter = new LogAdapter(mList,this);
        listView.setAdapter(adapter);
        setListener();
    }

    private void setListener() {
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                LogDao.getInstance(LogActivity.this).clear(mList.get(i));
                mList = LogDao.getInstance(LogActivity.this).queryAll();
                adapter = new LogAdapter(mList,LogActivity.this);
                listView.setAdapter(adapter);
                return true;
            }
        });
    }

}
