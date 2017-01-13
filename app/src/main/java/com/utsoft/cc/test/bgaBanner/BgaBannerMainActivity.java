package com.utsoft.cc.test.bgaBanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.utsoft.cc.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

public class BgaBannerMainActivity extends AppCompatActivity {

    @BindView(R.id.banner_guide_BgaBannerMainActivity)
    BGABanner bannerGuideBgaBannerMainActivity;
    @BindView(R.id.btn_guideEnter_BgaBannerMainActivity)
    Button btnGuideEnterBgaBannerMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bga_banner_main);
        ButterKnife.bind(this);

        initView();
        setListener();
    }

    /**
     * 初始化控件
     */
    private void initView(){
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid1));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid2));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_guid3));
        bannerGuideBgaBannerMainActivity.setData(views);
    }

    /**
     * 事件监听方法
     */
    private void setListener() {
        // 监听页码切换事
        bannerGuideBgaBannerMainActivity.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == bannerGuideBgaBannerMainActivity.getItemCount()-1) {
                    btnGuideEnterBgaBannerMainActivity.setVisibility(View.VISIBLE);
                } else {
                    btnGuideEnterBgaBannerMainActivity.setVisibility(View.GONE);
                }
                Log.i("信息",position+"--"+positionOffset+"--"+positionOffsetPixels);
            }
        });
    }

    @OnClick(R.id.btn_guideEnter_BgaBannerMainActivity)
    public void onClick() {
        startActivity(new Intent(this,BgaBanner2Activity.class));
    }
}
