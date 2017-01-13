package com.utsoft.cc.test.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.utsoft.cc.test.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBusMainActivity extends AppCompatActivity {

    @BindView(R.id.btn_nextPage_EventBusMainActivity)
    Button btnNextPageEventBusMainActivity;
    @BindView(R.id.tv_content_EventBusMainActivity)
    TextView tvContentEventBusMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_main);
        //注册EventBus
//        EventBus.getDefault().register(this);

        EventBus.getDefault().register(this);
        ButterKnife.bind(this);


    }

    /**
     * 进入到下一个页面
     */
    @OnClick(R.id.btn_nextPage_EventBusMainActivity)
    public void onClick() {
        startActivity(new Intent(this,EventBus2Activity.class));
    }

    /**
     * 这里接收传递回来的数据
     * @param event
     */
    @Subscribe
    public void onEventMainThread(Event event) {
        Toast.makeText(this, "接收数据成功", Toast.LENGTH_SHORT).show();
        tvContentEventBusMainActivity.setText(event.getmMsg());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        注销EventBus
        EventBus.getDefault().unregister(this);
    }
}
