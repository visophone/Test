package com.utsoft.cc.test.rxandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.utsoft.cc.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;

public class RxAndroidMainActivity extends AppCompatActivity {

    @BindView(R.id.btn_send_RxAndroidMainActivity)
    Button btnSendRxAndroidMainActivity;
    @BindView(R.id.tv_content_RxAndroidMainActivity)
    TextView tvContentRxAndroidMainActivity;

    private Subscriber<String> subscriber;  //订阅者
    private Observable<String> observable;  //观察者

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_android_main);
        ButterKnife.bind(this);

        createSubscriber();


    }

    @OnClick(R.id.btn_send_RxAndroidMainActivity)
    public void onClick() {
        createObservable();
    }

    //创建Subscriber
    private void createSubscriber() {

        subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(String t) {
                tvContentRxAndroidMainActivity.setText(t);
            }
        };
    }

    //创建Observable
    private void createObservable() {
        observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("这是用rxAndroid传递过来的数据");
            }
        });
        //绑定
        observable.subscribe(subscriber);
    }
}
