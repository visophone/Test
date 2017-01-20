package com.utsoft.cc.test.baserecyclerviewadapterhelper;


import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.utsoft.cc.test.R;

import java.util.List;

/**
 * Created by 周玉明 on 2017/1/16.
 * Function RecyclerView的数据填充器
 * Desc
 */

public class RecyclerViewAdapter extends BaseQuickAdapter<UserEntity,BaseViewHolder> {


    public RecyclerViewAdapter(List<UserEntity> data) {
        super(R.layout.layout_rvitem_recyclerviewadapter,data);
        Log.i("消息","data"+data.toString());
    }

    @Override
    protected void convert(com.chad.library.adapter.base.BaseViewHolder helper, UserEntity item) {
        helper.setText(R.id.tv_name_recyclerViewAdapter,item.getName())
                .setText(R.id.tv_id_recyclerViewAdapter,item.getId()+"");
        Glide.with(mContext).load(item.getIcon()).asGif().into((ImageView) helper.getView(R.id.iv_icon_RecyclerViewAdapter));
        }

        }

