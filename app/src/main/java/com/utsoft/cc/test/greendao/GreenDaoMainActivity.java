package com.utsoft.cc.test.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.anye.greendao.gen.UserEntityDao;
import com.utsoft.cc.test.MyApplication;
import com.utsoft.cc.test.R;

import org.greenrobot.greendao.generator.Query;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GreenDaoMainActivity extends AppCompatActivity {


    @BindView(R.id.tv_content_GreenDaoMainActivity)
    TextView tvContentGreenDaoMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_green_dao_main);
        ButterKnife.bind(this);

        UserEntityDao userEntityDao = MyApplication.getInstances().getDaoSession().getUserEntityDao();

        //增加数据
//        for(int i=0;i<10;i++){
//            UserEntity userEntity = new UserEntity((long) 0+i, "张三"+i);
//            userEntityDao.insert(userEntity);
//
//        }

        //修改数据
//        UserEntity userEntity=new UserEntity((long) 12142346, "王五");
//        userEntityDao.update(userEntity);


        //删除数据
//        userEntityDao.deleteByKey((long)12142345);
//        userEntityDao.deleteAll();

        //查询数据
//        List<UserEntity> userEntities = userEntityDao.loadAll();
//        String userName = "";
//        for (int i = 0; i < userEntities.size(); i++) {
//            userName += userEntities.get(i).getName() + "-"+userEntities.get(i).getId()+",";
//        }

        List<UserEntity> userEntities=userEntityDao.queryBuilder()
                .where(UserEntityDao.Properties.Id.eq(5)).build().list();
        String userName = "";
        for (int i = 0; i < userEntities.size(); i++) {
            userName += userEntities.get(i).getName() + "-"+userEntities.get(i).getId()+",";
        }

        tvContentGreenDaoMainActivity.setText("查询全部数据==>" + userName);

    }
}
