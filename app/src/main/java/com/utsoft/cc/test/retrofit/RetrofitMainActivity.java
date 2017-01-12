package com.utsoft.cc.test.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.utsoft.cc.test.R;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);




//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("http://106.3.227.33/pulamsi/")
//                //增加返回值为String的支持
//                .addConverterFactory(ScalarsConverterFactory.create())
//                //增加返回值为Gson的支持(以实体类返回)
//                .addConverterFactory(GsonConverterFactory.create())
//                //增加返回值为Oservable<T>的支持
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        BlueService service = retrofit.create(BlueService.class);
    }

//    public interface BlueService {
//        @GET("book/search")
//        Call<BookSearchResponse> getSearchBooks(@Query("q") String name,
//                                                @Query("tag") String tag, @Query("start") int start,
//                                                @Query("count") int count);
//    }
}
