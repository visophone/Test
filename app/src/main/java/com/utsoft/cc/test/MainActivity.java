package com.utsoft.cc.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.utsoft.cc.test.baserecyclerviewadapterhelper.RecyclerViewHelperMainActivity;
import com.utsoft.cc.test.bgaBanner.BgaBannerMainActivity;
import com.utsoft.cc.test.eventbus.EventBusMainActivity;
import com.utsoft.cc.test.flycotablayout.FlycoTabMainActivity;
import com.utsoft.cc.test.greendao.GreenDaoMainActivity;
import com.utsoft.cc.test.jiecaovideoplayer.JieCaoVideoPlayerMainActivity;
import com.utsoft.cc.test.leakcancry.LeakCancryMainActivity;
import com.utsoft.cc.test.okhttp.OkhttpMainActivity;
import com.utsoft.cc.test.realm.RealmMainActivity;
import com.utsoft.cc.test.retrofit.RetrofitMainActivity;
import com.utsoft.cc.test.rxandroid.RxAndroidMainActivity;
import com.utsoft.cc.test.rxjava.RxJavaMainActivity;
import com.utsoft.cc.test.ultrapulltorefresh.RefreshMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class MainActivity extends AppCompatActivity {

    //butterknife的控件绑定
    @BindView(R.id.btn_okhttp_mainActivity)
    Button btnOkhttpMainActivity;
    @BindView(R.id.btn_retrofit_mainActivity)
    Button btnRetrofitMainActivity;
    @BindView(R.id.btn_rxJava_mainActivity)
    Button btnRxJavaMainActivity;
    @BindView(R.id.btn_rxAndroid_mainActivity)
    Button btnRxAndroidMainActivity;
    @BindView(R.id.btn_eventBus_mainActivity)
    Button btnEventBusMainActivity;
    @BindView(R.id.btn_bgaBanner_mainActivity)
    Button btnBgaBannerMainActivity;
    @BindView(R.id.btn_flycoTabLayout_mainActivity)
    Button btnFlycoTabLayoutMainActivity;
    @BindView(R.id.btn_baseRecyclerViewAdapterHelper_mainActivity)
    Button btnBaseRecyclerViewAdapterHelperMainActivity;
    @BindView(R.id.btn_ultraPullToRefresh_mainActivity)
    Button btnUltraPullToRefreshMainActivity;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;



    private Unbinder unbinder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        unbinder = ButterKnife.bind(this);

    }

    /**
     * butterknife按钮监听
     */
    @OnClick({R.id.btn_okhttp_mainActivity, R.id.btn_retrofit_mainActivity, R.id.btn_rxJava_mainActivity,
            R.id.btn_rxAndroid_mainActivity, R.id.btn_eventBus_mainActivity, R.id.btn_bgaBanner_mainActivity,
            R.id.btn_flycoTabLayout_mainActivity, R.id.btn_baseRecyclerViewAdapterHelper_mainActivity, R.id.btn_ultraPullToRefresh_mainActivity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_okhttp_mainActivity:
                startActivity(new Intent(this,OkhttpMainActivity.class));
                break;
            case R.id.btn_retrofit_mainActivity:
                startActivity(new Intent(this,RetrofitMainActivity.class));
                break;
            case R.id.btn_rxJava_mainActivity:
                startActivity(new Intent(this,RxJavaMainActivity.class));
                break;
            case R.id.btn_rxAndroid_mainActivity:
                startActivity(new Intent(this,RxAndroidMainActivity.class));
                break;
            case R.id.btn_eventBus_mainActivity:
                startActivity(new Intent(this,EventBusMainActivity.class));
                break;
            case R.id.btn_bgaBanner_mainActivity:
                startActivity(new Intent(this,BgaBannerMainActivity.class));
                break;
            case R.id.btn_flycoTabLayout_mainActivity:
                startActivity(new Intent(this,FlycoTabMainActivity.class));
                break;
            case R.id.btn_baseRecyclerViewAdapterHelper_mainActivity:
                startActivity(new Intent(this,RecyclerViewHelperMainActivity.class));
                break;
            case R.id.btn_ultraPullToRefresh_mainActivity:
//                startActivity(new Intent(this,RefreshMainActivity.class));
//                startActivity(new Intent(this,RealmMainActivity.class));
//                startActivity(new Intent(this,GreenDaoMainActivity.class));
//                startActivity(new Intent(this,JieCaoVideoPlayerMainActivity.class));
                startActivity(new Intent(this,LeakCancryMainActivity.class));
                break;
        }
    }
}
