package com.utsoft.cc.test.rxjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.utsoft.cc.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class RxJavaMainActivity extends AppCompatActivity {

    @BindView(R.id.tv_content_RxJavaMainActivity)
    TextView tvContentRxJavaMainActivity;
    @BindView(R.id.btn_send_RxJavaMainActivity)
    Button btnSendRxJavaMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_main);
        ButterKnife.bind(this);

    }


    /**
     * 发送按钮监听
     */
    @OnClick(R.id.btn_send_RxJavaMainActivity)
    public void onClick() {

        test();
    }


    /**
     * 测试方法
     */
    private void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {

                        subscriber.onNext("我是rxjava发送过来的文字");  //发送数据
                    }
                });
                sender.subscribe(receiver);

            }
        }).start();

    }


    //接收源
    Observer<String> receiver = new Observer<String>() {

        @Override
        public void onCompleted() {
            //数据接收完成时调用

        }

        @Override
        public void onError(Throwable e) {
            //发生错误调用

        }

        @Override
        public void onNext(String s) {
            //正常接收数据调用
            tvContentRxJavaMainActivity.setText(s);
        }
    };

}
