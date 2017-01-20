package com.utsoft.cc.test.baserecyclerviewadapterhelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.utsoft.cc.test.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewHelperMainActivity extends AppCompatActivity {


    @BindView(R.id.rv_content_RecyclerViewHelperMainActivity)
    RecyclerView rvContentRecyclerViewHelperMainActivity;

    private List<UserEntity> list;  //数据list
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_helper_main);
        ButterKnife.bind(this);


        initView();
        initData();

    }

    /**
     * 初始化view
     */
    private void initView(){



    }

    /**
     * 初始化数据
     */
    private void initData(){

        String iconUrl1="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2389140428,1315216178&fm=116&gp=0.jpg";
        String iconUrl2="https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1948129653,2713569659&fm=116&gp=0.jpg";
        String iconUrl3="https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=61092371,2557115966&fm=116&gp=0.jpg";
        String iconUrl4="http://image13-c.poco.cn/mypoco/qing/20130218/15/9774720947242458168_496x310_210.gif";


        list=new ArrayList<>();
        list.add(new UserEntity("张三",0000001,iconUrl1));
        list.add(new UserEntity("李四",0000002,iconUrl2));
        list.add(new UserEntity("王五",0000003,iconUrl4));

        //使用匿名内部类的方法加载
//        BaseQuickAdapter adapter = new BaseQuickAdapter<UserEntity,BaseViewHolder>(
//                R.layout.layout_rvitem_recyclerviewadapter,list){
//            @Override
//            protected void convert(BaseViewHolder helper, UserEntity item) {
//                helper.setText(R.id.tv_name_recyclerViewAdapter,item.getName())
//                        .setText(R.id.tv_id_recyclerViewAdapter,item.getId()+"");
//            }
//        };


        rvContentRecyclerViewHelperMainActivity.setLayoutManager(new LinearLayoutManager(this));
        rvContentRecyclerViewHelperMainActivity.setAdapter(new RecyclerViewAdapter(list));

    }
}
