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

        list=new ArrayList<>();
        list.add(new UserEntity("张三",0000001));
        list.add(new UserEntity("李四",0000002));
        list.add(new UserEntity("王五",0000003));

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
