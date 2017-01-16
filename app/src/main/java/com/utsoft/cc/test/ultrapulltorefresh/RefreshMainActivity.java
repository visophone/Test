package com.utsoft.cc.test.ultrapulltorefresh;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.utsoft.cc.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class RefreshMainActivity extends AppCompatActivity {


    @BindView(R.id.lv_content_RefreshMainActivity)
    ListView lvContentRefreshMainActivity;
    @BindView(R.id.ptr_refresh_RefreshMainActivity)
    PtrClassicFrameLayout ptrRefreshRefreshMainActivity;

    private ListView listView;      //展示数据的listview
    private List<String> list;      //存数据的list
    private MyAdapter myAdapter;    //数据填充器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refresh_main);
        ButterKnife.bind(this);

        initData();

        test();

    }

    /**
     * 添加数据
     */
    private void initData(){
        list=new ArrayList<>();
        list.add("第一行数据");
        list.add("第二行数据");
        list.add("第三行数据");
        list.add("第四行数据");
        list.add("第五行数据");
        list.add("第六行数据");

        myAdapter=new MyAdapter(list,this);
        lvContentRefreshMainActivity.setAdapter(myAdapter);
    }

    /**
     * 测试方法
     */
    private void test(){

        ptrRefreshRefreshMainActivity.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(final PtrFrameLayout frame) {

                //刷新任务
                ptrRefreshRefreshMainActivity.post(new Runnable() {
                    @Override
                    public void run() {
                        //做刷新任务
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        frame.refreshComplete();
                    }
                });
            }
        });


        ptrRefreshRefreshMainActivity.setResistance(1.7f);                      //阻尼系数
        ptrRefreshRefreshMainActivity.setRatioOfHeaderHeightToRefresh(1.2f);    //触发刷新时移动的位置比例
        ptrRefreshRefreshMainActivity.setDurationToClose(200);              //回弹到刷新高度所用时间
        ptrRefreshRefreshMainActivity.setDurationToCloseHeader(1000);       //头部回弹时间
        ptrRefreshRefreshMainActivity.setPullToRefresh(false);              //下拉刷新 / 释放刷新
        ptrRefreshRefreshMainActivity.setKeepHeaderWhenRefresh(true);       //设置刷新是保持头部

    }
}
