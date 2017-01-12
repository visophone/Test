package com.utsoft.cc.test.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.utsoft.cc.test.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpMainActivity extends AppCompatActivity {

    private final String  TAG="OkhttpMainActivity";
    private final String url="http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okhttp_main);

//        try {
//            okhttpPost();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.i("错误",e.toString());
//
//        }
        OkhttpGet();

    }

    /**
     * 演示okhttp的get方法
     */
    public void OkhttpGet(){
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();
        //创建一个Request
        final Request request=new Request.Builder().url("https://api.github.com/")
                .build();
        Call call=client.newCall(request);
        //请求加入调度
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.toString();
                Log.i("消息",str);
            }
        });
    }

    /**
     * 演示okhttp的Post方法
     */
    public void okhttpPost()throws Exception{

         MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        //创建OkHttpClient对象
        OkHttpClient client = new OkHttpClient();

        String postBody = "百度百度百度";

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, postBody))
                .build();

        Response response = client.newCall(request).execute();
        if (!response.isSuccessful())
            throw new IOException("Unexpected code " + response);

        Log.i("消息",response.body().toString());

    }
}
