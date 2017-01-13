package com.utsoft.cc.test.eventbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.utsoft.cc.test.R;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventBus2Activity extends AppCompatActivity {

    @BindView(R.id.btn_send_EventBus2Activity)
    Button btnSendEventBus2Activity;
    @BindView(R.id.tv_content_EventBus2Activity)
    TextView tvContentEventBus2Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus2);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn_send_EventBus2Activity)
    public void onClick() {
        EventBus.getDefault().post(new Event(tvContentEventBus2Activity.getText().toString()));
    }
}
