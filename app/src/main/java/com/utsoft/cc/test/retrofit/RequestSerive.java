package com.utsoft.cc.test.retrofit;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by 周玉明 on 2017/1/13.
 */

public interface RequestSerive {
    @POST("mobileLogin/submit.html")
    Call<String> getString(@Query("loginname") String loginname,
                           @Query("nloginpwd") String nloginpwd);
}
