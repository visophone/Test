package com.utsoft.cc.test.ultrapulltorefresh;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.utsoft.cc.test.R;

import java.util.List;

/**
 * Created by 周玉明 on 2017/1/16.
 * Fucntion listview的数据填充器
 * Desc
 */

public class MyAdapter extends BaseAdapter{

    private List<String> list;
    private Context context;

    public MyAdapter(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=View.inflate(context, R.layout.layout_item_refreshmainactivity,null);
        TextView tvItemContent= (TextView) view.findViewById(R.id.tv_ListViewItem_RefreshMainActivity);
        tvItemContent.setText(list.get(position));

        return view;
    }
}
