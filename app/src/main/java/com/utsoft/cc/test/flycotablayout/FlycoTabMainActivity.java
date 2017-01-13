package com.utsoft.cc.test.flycotablayout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.utsoft.cc.test.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FlycoTabMainActivity extends AppCompatActivity {



    //tab的标题、选中图标、未选中图标
    private String[] mTitles = {"首页", "消息", "联系人", "我的"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_launcher, R.mipmap.ic_launcher,
            R.mipmap.ic_launcher, R.mipmap.ic_launcher};
    private int[] mIconSelectIds = {
            R.drawable.ic_guid1,R.drawable.ic_guid2,
            R.drawable.ic_guid3,R.drawable.ic_guid4};

    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();

    private ArrayList<Fragment> mFragments = new ArrayList<>();
//    private CommonTabLayout ctlOptionsFlycoTabMainActivity;

    @BindView(R.id.fl_content_FlycoTabMainActivity)
    FrameLayout flContentFlycoTabMainActivity;
    @BindView(R.id.ctl_options_FlycoTabMainActivity)
    CommonTabLayout ctlOptionsFlycoTabMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flyco_tab_main);
        ButterKnife.bind(this);


        initData();
//        initView();
        //给tab设置数据和关联的fragment
        ctlOptionsFlycoTabMainActivity.setTabData(mTabEntities, this, R.id.fl_content_FlycoTabMainActivity, mFragments);
        //设置红点
        ctlOptionsFlycoTabMainActivity.showDot(1);

    }

//    private void initView() {
//        ctlOptionsFlycoTabMainActivity = (CommonTabLayout) findViewById(R.id.fl_content_FlycoTabMainActivity);
//    }

    private void initData() {
        for (String title : mTitles) {
            mFragments.add(SimpleFragment.getInstance(title));
        }
        //设置tab的标题、选中图标、未选中图标
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
    }
}
