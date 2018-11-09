package com.example.administrator.logutildemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2018/11/9.
 */

public class LogAdapter extends BaseAdapter{
    private List<LogBean> mList;
    private Context context;

    public LogAdapter(List<LogBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.log_item, null);
            viewHolder = new ViewHolder(convertView);
            assert convertView != null;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tag.setText(mList.get(position).getTag());
        viewHolder.msg.setText(mList.get(position).getMsg());
        viewHolder.app.setText(mList.get(position).getApp());
        viewHolder.time.setText(mList.get(position).getTime());
        return convertView;
    }

    private class ViewHolder {
        TextView tag,msg,time,app;
        ViewHolder(View view) {
            tag = view.findViewById(R.id.tag);
            msg = view.findViewById(R.id.msg);
            app = view.findViewById(R.id.app);
            time = view.findViewById(R.id.time);
        }
    }
}
