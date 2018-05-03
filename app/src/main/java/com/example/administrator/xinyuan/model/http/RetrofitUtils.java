package com.example.administrator.xinyuan.model.http;

import android.text.TextUtils;

import com.example.administrator.xinyuan.App;
import com.example.administrator.xinyuan.model.biz.XinYuanService;
import com.example.administrator.xinyuan.model.url.Urls;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/4/7.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private final Retrofit retrofit;
    private static String s;
    private RetrofitUtils(){
        Interceptor interceptor = new Interceptor() {

            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                s = response.header("Set-Cookie");


                return response;
            }
        };
        Cache cache = new Cache(App.context.getCacheDir(), 1024 * 1024 * 10);
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(interceptor).addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if (TextUtils.isEmpty(response.cacheControl().toString())) {
                    Response build = response.newBuilder().addHeader("Cache-Control", "max-age=" + 60 * 60 * 60).build();
                    return build;
                }
                return response;
            }
        }).cache(cache).build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Urls.xinyuan_serviceurl)
                .build();
    }
    public static RetrofitUtils getInstence(){
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }
    public XinYuanService getLoadDate(){

        return retrofit.create(XinYuanService.class);
    }
    public static String getJSESSIONID(){
        return s;
    }
}
