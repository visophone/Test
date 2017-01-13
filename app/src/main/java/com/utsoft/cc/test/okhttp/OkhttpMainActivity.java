package com.utsoft.cc.test.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.utsoft.cc.test.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;

public class OkhttpMainActivity extends AppCompatActivity {


    private final String url = "http://www.baidu.com";

    @BindView(R.id.btn_get_OkhttpMainActivity)
    Button btnGetOkhttpMainActivity;
    @BindView(R.id.btn_post_OkhttpMainActivity)
    Button btnPostOkhttpMainActivity;
    @BindView(R.id.tv_content_OkhttpMainActivity)
    TextView tvContentOkhttpMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_get_OkhttpMainActivity, R.id.btn_post_OkhttpMainActivity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_get_OkhttpMainActivity:
                OkhttpGet();

                break;
            case R.id.btn_post_OkhttpMainActivity:

                    okhttpPost();
                tvContentOkhttpMainActivity.setText("这里由于使用的地址不能post数据，所以没有post成功");

                break;
        }
    }


    /**
     * 演示okhttp的get方法
     */
    public void OkhttpGet() {
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建一个Request
        final Request request = new Request.Builder().url("https://api.github.com/")
                .build();
        Call call = client.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String str = response.toString();
                Log.i("消息", str);
                //方法一
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        tvContentOkhttpMainActivity.setText(str);
//
//                    }
//                });
                //方法二，使用rxjava,这里定义发射源
                Observable<String> sender = Observable.create(new Observable.OnSubscribe<String>() {

                    @Override
                    public void call(Subscriber<? super String> subscriber) {
                        subscriber.onNext(str);
                    }
                });

                //将发射源和接收源绑定
                sender.subscribe(receiver);
            }
        });
    }

    /**
     * 演示okhttp的Post方法,由于百度的地址不能post数据上去，所以post失败
     */
    public void okhttpPost()  {

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        //创建OkHttpClient对象
        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, ""))
                .build();

        new Thread(new Runnable() {
            @Override
            public void run() {
                Response response = null;
                try {
                    response = client.newCall(request).execute();
                    if (response.isSuccessful()) {
                        final String str=response.toString();
                        Log.i("消息", str);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tvContentOkhttpMainActivity.setText(str);
                            }
                        });
                    } else {
                        throw new IOException("Unexpected code " + response);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
            tvContentOkhttpMainActivity.setText(s);
        }
    };


}
