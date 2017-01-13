package com.utsoft.cc.test.bgaBanner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.utsoft.cc.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

public class BgaBanner2Activity extends AppCompatActivity {

    @BindView(R.id.banner_head_BgaBanner2Activity)
    BGABanner bannerHeadBgaBanner2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bga_banner2);
        ButterKnife.bind(this);

        initView();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid1));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid2));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid3));
        bannerHeadBgaBanner2Activity.setData(views);
    }
}
